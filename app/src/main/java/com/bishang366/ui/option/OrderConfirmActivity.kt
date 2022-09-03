package com.bishang366.ui.option

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.bishang366.R
import com.bishang366.base.BaseActivity
import com.bishang366.databinding.ActivityOrderConfirmBinding
import com.bishang366.ui.wallet.WalletViewModel
import com.chad.library.adapter.base.BaseViewHolder
import java.math.BigDecimal
import java.text.DecimalFormat

class OrderConfirmActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityOrderConfirmBinding

    lateinit var viewModel: OptionViewModel
    lateinit var walletViewModel: WalletViewModel
    private val TYPE_UP = 0
    private val TYPE_DOWNN = 1
    private val type by lazy { intent.getIntExtra(TYPE, 0) }
    private val currentPrice by lazy { intent.getStringExtra(CURRENT_PRICE) }
    private val symbol by lazy { intent.getStringExtra(SYMBOL) }
    private lateinit var adapter: OptionModeAdapter
    private lateinit var adapterCycle: OptionCycleAdapter
    private var currentPosition = 0
    private var currentCycle = 0
    override fun getActivityLayoutId(): Int {
        return NO_LAYOUT_ID
    }

    override fun getContentView(): View {
        binding = ActivityOrderConfirmBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(viewModelStore, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(OptionViewModel::class.java)
        walletViewModel = ViewModelProvider(viewModelStore, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(WalletViewModel::class.java)
        return binding.root
    }

    override fun initViews(savedInstanceState: Bundle?) {
        binding.directionValue.text = if (type == TYPE_UP) getString(R.string.text_look_up) else getString(R.string.text_look_down)
        binding.nameValue.text = symbol
        binding.currentPriceValue.text = currentPrice
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTime.layoutManager = manager
        val managerCurrent = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTransferMode.layoutManager = managerCurrent
        adapter = OptionModeAdapter(R.layout.adapter_transfer_mode, viewModel.sureCoins.value)
        adapter.setOnItemClickListener { adapter, view, position ->
            viewModel.sureCoins.value?.get(position)?.let { walletViewModel.getSecondWalletBalance(it) }
            currentPosition = position
            adapter.notifyDataSetChanged()
        }
        adapter.setItemSelectedCallBack(object : OptionModeAdapter.ItemSelectedCallBack {
            override fun convert(holder: BaseViewHolder, position: Int) {
                //初始化组件
                val tv = holder.getView<TextView>(R.id.tv_coin)
                //判断传入的position是否和当前一致
                if (position == currentPosition) {
                    tv.setBackgroundResource(R.drawable.shape_yellow_new)
                    tv.setTextColor(resources.getColor(R.color.white))
                } else {
                    tv.setBackgroundResource(R.drawable.shape_gray)
                    tv.setTextColor(resources.getColor(R.color.black_58595B))
                }
            }
        })
        adapterCycle = OptionCycleAdapter(R.layout.adapter_option_cycle, viewModel.cycleBeans.value)
        adapterCycle.setOnItemClickListener { adapter, view, position ->
            currentCycle = position
            adapterCycle.notifyDataSetChanged()
        }
        adapterCycle.setItemSelectedCallBack(object : OptionCycleAdapter.ItemSelectedCallBack {
            override fun convert(holder: BaseViewHolder, position: Int) {
                val ll = holder.getView<LinearLayout>(R.id.ll_transfer)
                val time = holder.getView<TextView>(R.id.tv_time)
                val percent = holder.getView<TextView>(R.id.tv_percent)
                //判断传入的position是否和当前一致
                if (position == currentCycle) {
                    ll.setBackgroundResource(R.drawable.shape_yellow_new)
                    percent.setBackgroundResource(R.drawable.shape_black_new)
                    time.setTextColor(resources.getColor(R.color.white))
                    percent.setTextColor(resources.getColor(R.color.yellowDark_sell))
                } else {
                    ll.setBackgroundResource(R.drawable.shape_gray)
                    percent.setBackgroundResource(R.drawable.shape_gray)
                    time.setTextColor(resources.getColor(R.color.gray_B5BBCC))
                    percent.setTextColor(resources.getColor(R.color.gray_B5BBCC))
                }
            }
        })
        binding.rvTime.adapter = adapterCycle
        binding.rvTransferMode.adapter = adapter
        binding.rvTime.isNestedScrollingEnabled = false
        binding.rvTransferMode.isNestedScrollingEnabled = false
        binding.btnCancel.setOnClickListener(this)
        binding.sure.setOnClickListener(this)

        viewModel.sureCoins.observe(this, Observer {
            it?.let {
                adapter.addData(it)
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.cycleBeans.observe(this,Observer {
            it?.let {
                adapterCycle.addData(it)
                adapterCycle.notifyDataSetChanged()
            }
        })

        walletViewModel.balance.observe(this,Observer {
            it?.let {
                val format = DecimalFormat("#,##0.0000");//不以科学计数法显示，并把结果用逗号隔开保留两位小数
                val bigDecimal = BigDecimal(it);//不以科学计数法显示，正常显示保留两位小数
//                binding.balance.text = "" + format.format(it) + "\n" + bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP)
                binding.balance.text = "${bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP)}"
            }
        })

        viewModel.addResult.observe(this,Observer {
            it?.let {
                hideLoadingPopup()
                if (it) {
                    Toast.makeText(this, resources.getString(R.string.success), Toast.LENGTH_SHORT).show()
                    setResult(RESULT_CODE)
                    finish()
                } else {
                    Toast.makeText(this, resources.getString(R.string.fail), Toast.LENGTH_SHORT).show()
                }

            }
        })

    }

    override fun obtainData() {
        viewModel.getSecondOptionCycles()
        viewModel.getSecondOptionCoins()
        walletViewModel.getSecondWalletBalance("USDT")
    }

    override fun fillWidget() {
    }

    override fun loadData() {
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCancel -> {
                finish()
            }
            R.id.sure -> {
                val count = binding.etCount.text.toString()
                if (count.isNullOrEmpty() || count.toInt() <= 0) {
                    Toast.makeText(this, resources.getString(R.string.number_hint), Toast.LENGTH_SHORT).show()
                    return
                }
                displayLoadingPopup()
                viewModel.add(symbol, "$type", "${viewModel.cycleBeans.value?.get(currentCycle)?.id}",
                        count, viewModel.sureCoins.value?.get(currentPosition))
            }
        }
    }
}

private const val TYPE = "type"
private const val CURRENT_PRICE = "current_price"
private const val SYMBOL = "symbol"
const val REQUEST_CODE = 1000
const val RESULT_CODE = 1001
fun goOrderConfirmActivity(context: Activity, type: Int, price: String, symbol: String) {
    val intent = Intent(context, OrderConfirmActivity::class.java)
    intent.putExtra(TYPE, type)
    intent.putExtra(CURRENT_PRICE, price)
    intent.putExtra(SYMBOL, symbol)
    context.startActivityForResult(intent,REQUEST_CODE)
}