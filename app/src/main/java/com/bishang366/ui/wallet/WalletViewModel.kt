package com.bishang366.ui.wallet

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bishang366.app.UrlFactory
import com.bishang366.entity.WalletInfo
import com.bishang366.utils.WonderfulLogUtils
import com.bishang366.utils.okhttp.StringCallback
import com.bishang366.utils.okhttp.WonderfulOkhttpUtils
import com.google.gson.reflect.TypeToken
import okhttp3.Request
import org.json.JSONObject

class WalletViewModel : ViewModel() {
    private val TAG = "WalletViewModel"
    val walletInfo = MutableLiveData<List<WalletInfo>>()
    val balance = MutableLiveData<Double>()
    fun getSecondWalletList() {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondWalletList()).build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "查询账号 onError" + e.message)
                    }

                    override fun onResponse(res: String) {
                        WonderfulLogUtils.logi(TAG, "查询账号$res")
                        try {
                            val `object` = JSONObject(res)
                            if (`object`.optInt("code") == 0) {
                                val obj = gson.fromJson<List<WalletInfo>>(`object`.getJSONArray("data").toString(), object : TypeToken<List<WalletInfo?>?>() {}.type)
                                walletInfo.value = obj
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    fun getSecondWalletBalance(coinSymbol: String) {
        WonderfulLogUtils.logi(TAG, "查询期权账户可用余额 req:coinSymbol=$coinSymbol")
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondWalletBalance(coinSymbol))
                .build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "查询期权账户可用余额 onError" + e.message)
                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "查询期权账户可用余额$response")
                        try {
                            val `object` = JSONObject(response)
                            if (`object`.optInt("code") == 0) {
                                val obj = gson.fromJson<Double>(`object`.getDouble("data").toString(), object : TypeToken<Double?>() {}.type)
                                balance.value = obj
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    //资金划转
    fun walletTrans(unit: String?, from: String?, to: String?, amount: String?) {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondWalletTrans())
                .addParams("unit", unit)//划转币种单位 例如 BTC
                .addParams("from", from)//转出钱包类型 0币币 2期权
                .addParams("to", to)//转入钱包类型 0币币 2期权
                .addParams("amount", amount)//划转数量
                .build().execute(object : StringCallback() {
                    override fun onError(request: Request, e: java.lang.Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "资金划转 onError" + e.message)

                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "资金划转:$response")
                    }
                })
    }
}