package com.bishang366.ui.option

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bishang366.app.UrlFactory
import com.bishang366.entity.*
import com.bishang366.utils.WonderfulLogUtils
import com.bishang366.utils.okhttp.StringCallback
import com.bishang366.utils.okhttp.WonderfulOkhttpUtils
import com.google.gson.reflect.TypeToken
import okhttp3.Request
import org.json.JSONObject

class OptionViewModel : ViewModel() {
    companion object {
        val TAG = "OptionViewModel"
    }

    val compensationBeanS = MutableLiveData<List<CompensationBean>>()
    val cycleBeans = MutableLiveData<List<CycleBean>>()
    val coins = MutableLiveData<List<OptionBean.DataBean>>()
    val sureCoins = MutableLiveData<List<String>>()
    val currentSortInfo = MutableLiveData<List<OptionDetailInfo>>()
    val historySortInfo = MutableLiveData<List<OptionDetailInfo>>()
    val addResult = MutableLiveData<Boolean>()
    val last= arrayListOf<OptionDetailInfo>()

    fun getSecondOptionCurrent(symbol: String?) {
        WonderfulLogUtils.logi(TAG, "获取当前交易对持仓记录 symbol=$symbol")
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionCurrent())
                .addParams("symbol", symbol)//交易对 例如 BTC/USDT
                .build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "获取当前交易对持仓记录 onError" + e.message)
                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "获取当前交易对持仓记录$response")
                        try {
                            val data = JSONObject(response)
                            if (data.optInt("code") == 0) {
                                WonderfulLogUtils.logi(TAG, "获取当前交易对持仓记录 code=0")
                                val obj = gson.fromJson<OptionCurrentInfo>(response, object : TypeToken<OptionCurrentInfo?>() {}.type)
                                obj.content.forEach {
                                    val time = last.find { itt -> it.id == itt.id }?.countDownTime?:-1
                                    it.countDownTime = if (time >=0) time else it.cycleLength
                                }
                                currentSortInfo.value = obj.content
                                WonderfulLogUtils.logi(TAG, "获取当前交易对持仓记录 ${obj.size}")
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    fun getSecondOptionCoins() {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionCoins()).build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "获取可交易的币种 onError" + e.message)
                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "获取可交易的币种$response")
                        try {
                            val `object` = JSONObject(response)
                            if (`object`.optInt("code") == 0) {
                                val obj = gson.fromJson<List<String>>(`object`.getJSONArray("data").toString(), object : TypeToken<List<String?>?>() {}.type)
                                sureCoins.value = obj
                                val arr = arrayListOf<OptionBean.DataBean>()
                                obj.forEach {
                                    val data = OptionBean.DataBean()
                                    data.coinSymbol = it
                                    arr.add(data)
                                }
                                coins.value = arr
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    fun getSecondOptionCycles() {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionCycles()).build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "获取周期 onError" + e.message)
                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "获取周期$response")
                        try {
                            val `object` = JSONObject(response)
                            if (`object`.optInt("code") == 0) {
                                val obj = gson.fromJson<List<CycleBean>>(`object`.getJSONArray("data").toString(), object : TypeToken<List<CycleBean?>?>() {}.type)
                                cycleBeans.value = obj
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    fun getSecondOptionAllSets() {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionAllSets()).build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "获取包赔设置 onError" + e.message)
                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "获取包赔设置$response")
                        try {
                            val `object` = JSONObject(response)
                            if (`object`.optInt("code") == 0) {
                                val obj = gson.fromJson<List<CompensationBean>>(`object`.getJSONArray("data").toString(), object : TypeToken<List<CompensationBean?>?>() {}.type)
                                compensationBeanS.value = obj
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    fun getSecondOptionHistory(symbol: String?, pageNo: String?, pageSize: String?) {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionHistory())
                .addParams("symbol", symbol)//交易对 例如 BTC/USDT
                .addParams("pageNo", pageNo)// 当前页数
                .addParams("pageSize", pageSize)//每页条数
                .build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "获取当前交易对历史记录 onError" + e.message)
                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "获取当前交易对历史记录$response")
                        try {
                            val data = JSONObject(response)
                            if (data.optInt("code") == 0) {
                                val obj = gson.fromJson<OptionInfo>(response, object : TypeToken<OptionInfo?>() {}.type)
                                historySortInfo.value = obj.content
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    //下单接口
    fun add(symbol: String?, direction: String?, cycleId: String?, amount: String?, coinSymbol: String?) {
        WonderfulLogUtils.logi(TAG, "下单接口 symbol=$symbol direction=$direction " +
                "cycleId=$cycleId amount=$amount coinSymbol=$coinSymbol")
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionAdd())
                .addParams("symbol", symbol)//交易对 例如 BTC/USDT
                .addParams("coinSymbol", coinSymbol)// 交易币种 例如 BTC ETH USDT
                .addParams("direction", direction)//购买方向 0看涨  1看跌
                .addParams("cycleId", cycleId)//周期id
                .addParams("amount", amount)//参与金额
                .build().execute(object : StringCallback() {
                    override fun onError(request: Request, e: java.lang.Exception) {
                        super.onError(request, e)
                        WonderfulLogUtils.logi(TAG, "下单接口 onError" + e.message)

                    }

                    override fun onResponse(response: String) {
                        WonderfulLogUtils.logi(TAG, "下单接口:$response")
                        val data = JSONObject(response)
                        addResult.postValue(data.optInt("code") == 0)
                    }
                })
    }
}