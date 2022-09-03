package com.bishang366.ui.option

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.view.View
import com.bishang366.R
import android.arch.lifecycle.Observer
import com.bishang366.adapter.PagerAdapter
import com.bishang366.app.MyApplication
import com.bishang366.app.UrlFactory
import com.bishang366.base.BaseFragment
import com.bishang366.base.BaseTransFragmentActivity
import com.bishang366.databinding.ActivityOptionBinding
import com.bishang366.entity.Currency
import com.bishang366.entity.OptionBean
import com.bishang366.ui.home.BTCMarket2Fragment
import com.bishang366.ui.home.ETHMarket2Fragment
import com.bishang366.ui.home.Favorite2Fragment
import com.bishang366.ui.home.MarketBaseFragment.MarketOperateCallback
import com.bishang366.ui.home.USDTMarket2Fragment
import com.bishang366.ui.kline.KlineActivity
import com.bishang366.utils.WonderfulLogUtils
import com.bishang366.utils.okhttp.StringCallback
import com.bishang366.utils.okhttp.WonderfulOkhttpUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Request
import java.util.*

class OptionActivity : BaseTransFragmentActivity(), MarketOperateCallback {

    private lateinit var sevenFragment: OptionRealFragment
    private val menusFragments2: ArrayList<BaseFragment> = ArrayList()
    private lateinit var binding: ActivityOptionBinding
    private lateinit var viewModel: OptionViewModel
    private lateinit var usdtMarketFragment2: USDTMarket2Fragment
    private lateinit var btcMarketFragment2: BTCMarket2Fragment
    private lateinit var ethMarketFragment2: ETHMarket2Fragment
    private lateinit var favoriteFragment2: Favorite2Fragment
    private var baseUsdt: ArrayList<Currency> = ArrayList()
    private var baseBtc: ArrayList<Currency> = ArrayList()
    private var baseEth: ArrayList<Currency> = ArrayList()
    val currencyListAll: ArrayList<Currency> = ArrayList()
    override fun getActivityLayoutId(): Int {
        return NO_LAYOUT_ID
    }

    override fun getContentView(): View {
        binding = ActivityOptionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initViews(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(viewModelStore, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(OptionViewModel::class.java)

        binding.ibCloseOption.setOnClickListener { binding.dlRoot.closeDrawers() }
        val type = MarketOperateCallback.TYPE_SWITCH_SYMBOL
        usdtMarketFragment2 = USDTMarket2Fragment.getInstance(type)
        btcMarketFragment2 = BTCMarket2Fragment.getInstance(type)
        ethMarketFragment2 = ETHMarket2Fragment.getInstance(type)
        favoriteFragment2 = Favorite2Fragment.getInstance(type)
        menusFragments2.add(usdtMarketFragment2)
        menusFragments2.add(btcMarketFragment2)
        menusFragments2.add(ethMarketFragment2)
        menusFragments2.add(favoriteFragment2)

        val titles = resources.getStringArray(R.array.option_top_tab).toList()
        binding.vpOption.adapter = PagerAdapter(supportFragmentManager, menusFragments2, titles)
        binding.tab.setupWithViewPager(binding.vpOption)
        binding.tab.getTabAt(0)?.select()
        viewModel.coins.observe(this, Observer {
            it?.let {
                setData_Option(it)
            }
        })
    }

    override fun obtainData() {
    }

    override fun fillWidget() {
    }

    override fun loadData() {
        //获取期权币种
        getHttpCode()
        viewModel.getSecondOptionCoins()
    }

    override fun recoverFragment() {
    }

    override fun initFragments() {
    }

    override fun getContainerId(): Int {
        return R.id.flContainer
    }

    override fun itemClick(currency: Currency?, type: Int) {
        WonderfulLogUtils.logi(OptionViewModel.TAG, "执行点击")
        if (type == MarketOperateCallback.TYPE_SWITCH_SYMBOL) {
            binding.dlRoot.closeDrawers()
            sevenFragment.resetSymbol(currency)
        } else if (type == MarketOperateCallback.TYPE_TO_KLINE) {
            KlineActivity.actionStart(this, currency!!.symbol, "1")
        }
    }

    override fun itemClick2(optionBean: OptionBean.DataBean?, type: Int) {
    }

    private fun getHttpCode() {
        displayLoadingPopup()
        WonderfulOkhttpUtils.post().url(UrlFactory.getAllCurrencySecond()).build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        super.onError(request, e)
                    }

                    override fun onResponse(response: String) {
                        hideLoadingPopup()
                        WonderfulLogUtils.logi(OptionViewModel.TAG, "所有币种$response")
                        // 获取所有币种
                        try {
                            val obj = Gson().fromJson<List<Currency>>(response, object : TypeToken<List<Currency?>?>() {}.type)
                            setCurrency(obj)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    }

    private fun setCurrency(currencies: List<Currency>?) {
        if (currencies == null || currencies.size == 0) return
        currencyListAll.clear()
        currencyListAll.addAll(currencies)
        MyApplication.list.clear()
        MyApplication.list.addAll(currencies)
        baseUsdt = Currency.baseCurrencies(currencyListAll, "USDT") as ArrayList<Currency>
        baseBtc = Currency.baseCurrencies(currencyListAll, "BTC") as ArrayList<Currency>
        baseEth = Currency.baseCurrencies(currencyListAll, "ETH") as ArrayList<Currency>
        WonderfulLogUtils.logi(OptionViewModel.TAG, "baseUsdt:" + baseUsdt.size)
        if (MyApplication.getApp().isLogin) {
            WonderfulLogUtils.logi(OptionViewModel.TAG, "2baseUsdt:" + baseUsdt.size)
            setData()
        } else {
            WonderfulLogUtils.logi(OptionViewModel.TAG, "3baseUsdt:" + baseUsdt.size)
            setData()
        }
        sevenFragment = OptionRealFragment()
        addFragment(sevenFragment)
        sevenFragment.setCurrencyInfo(currencies)
    }

    private fun setData() {
        usdtMarketFragment2.dataLoaded(baseUsdt)
        WonderfulLogUtils.logi(OptionViewModel.TAG, "11baseUsdt:" + baseUsdt.size)
        btcMarketFragment2.dataLoaded(baseBtc)
        ethMarketFragment2.dataLoaded(baseEth)
        favoriteFragment2.dataLoaded(currencyListAll)
    }

    fun getDlRoot(): DrawerLayout {
        return binding.dlRoot
    }

    fun show_option() {
        binding.llOption.visibility = View.VISIBLE
    }

    private fun setCurrency_option(currencies: List<OptionBean.DataBean>?) {
        if (currencies == null || currencies.size == 0) return
//        this.currenciesOption.clear()
//        this.currenciesOption.addAll(currencies)

//        constract = Currency.baseCurrencies(currencyListAll, "USDT");
//        if (MyApplication.getApp().isLogin) {
////            presenter.find(getToken());
//            WonderfulLogUtils.logi("miao", "2baseUsdt:" + currenciesOption.size)
//            setData_Option(currenciesOption)
//        } else {
//            WonderfulLogUtils.logi("miao", "3baseUsdt:" + currenciesOption.size)
//            setData_Option(currenciesOption)
//            // 请求成功为前三个模块设置数据
//            //重要提示： 这里所有数据源都是这里的currencies，几个fragment共用，这段内存数据 一改全改
//        }
    }

    private fun setData_Option(currenciesoption: List<OptionBean.DataBean>) {
//        optionFragment.dataLoaded(currenciesoption)
    }

    fun tcpNotify() {
        usdtMarketFragment2.tcpNotify()
        btcMarketFragment2.tcpNotify()
        ethMarketFragment2.tcpNotify()
        favoriteFragment2.tcpNotify()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        WonderfulLogUtils.logi(OptionViewModel.TAG, "onActivityResult requestCode=$requestCode resultCode=$resultCode")
        if (resultCode == RESULT_CODE) {
            sevenFragment.onActivityResult(requestCode, resultCode, data)
        }
    }
}

fun goOptionActivity(context: Context) {
    val intent = Intent(context, OptionActivity::class.java)
    context.startActivity(intent)
}