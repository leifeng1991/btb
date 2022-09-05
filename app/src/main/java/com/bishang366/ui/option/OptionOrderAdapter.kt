package com.bishang366.ui.option

import com.bishang366.R
import com.bishang366.entity.OptionDetailInfo
import com.bishang366.utils.SharedPreferenceInstance
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.github.mikephil.charting.components.YAxis
import java.text.SimpleDateFormat
import java.util.*

class OptionOrderAdapter(layoutResId: Int, data: List<OptionDetailInfo?>?, private val isHistory: Boolean = false) : BaseQuickAdapter<OptionDetailInfo, BaseViewHolder>(layoutResId, data) {
    private var mCallBack: ItemSelectedCallBack? = null
    override fun convert(helper: BaseViewHolder, item: OptionDetailInfo) {
        helper.setText(R.id.name, "${item.id}")

//        helper.setText(R.id.time, item.createTime)
        val sdfLa = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        when (SharedPreferenceInstance.getInstance().languageCode) {
            -1, 1 -> sdfLa.timeZone = TimeZone.getTimeZone("Asia/Shanghai")
            3 -> sdfLa.timeZone = TimeZone.getTimeZone("Asia/Tokyo")
            4 -> sdfLa.timeZone = TimeZone.getTimeZone("Asia/Seoul")
            5 -> sdfLa.timeZone = TimeZone.getTimeZone("Europe/Berlin")
            6 -> sdfLa.timeZone = TimeZone.getTimeZone("Europe/Paris")
            7 -> sdfLa.timeZone = TimeZone.getTimeZone("Europe/Rome")
            8 -> sdfLa.timeZone = TimeZone.getTimeZone("America/Los_Angeles")
        }
        val format = sdfLa.format(YAxis.dateToStamp(item.createTime))
        helper.setText(R.id.time, format)

        helper.setText(R.id.ctc_tra, "${item.symbol},${item.cycleLength}s")
        helper.setText(R.id.ctc_price, "${item.openPrice}")
        helper.setText(R.id.count, "${item.betAmount} ${item.coinSymbol}")
        helper.setGone(R.id.close, isHistory)
        helper.setGone(R.id.closseprice, isHistory)
        helper.setGone(R.id.profit_loss, isHistory)
        helper.setGone(R.id.profit_loss_name, isHistory)
        helper.setGone(R.id.countDownName, !isHistory)
        helper.setGone(R.id.countDown, !isHistory)
        helper.setText(R.id.countDown, "${item.countDownTime}s")
        helper.setText(R.id.closseprice, "${item.closePrice}")
        helper.setText(R.id.profit_loss, "${item.winAmount} ${item.coinSymbol}")
        if (item.direction == "BUY") { //涨
            helper.setTextColor(R.id.ctc_direction, mContext.resources.getColor(R.color.typeGreen))
                .setText(R.id.ctc_direction, mContext.getString(R.string.text_look_up_1))
        } else if (item.direction == "SELL") { //跌
            helper.setTextColor(R.id.ctc_direction, mContext.resources.getColor(R.color.typeRed))
                .setText(R.id.ctc_direction, mContext.getString(R.string.text_look_down_1))
        }
        if (item.type >= "YES") { //涨
            helper.setTextColor(R.id.reparation, mContext.resources.getColor(R.color.typeGreen))
                .setText(R.id.reparation, mContext.getString(R.string.yes_1))
        } else { //跌
            helper.setTextColor(R.id.reparation, mContext.resources.getColor(R.color.typeRed))
                .setText(R.id.reparation, mContext.getString(R.string.no_1))
        }
        if (mCallBack != null) {
            mCallBack!!.convert(helper, helper.layoutPosition)
        }
    }

    fun setItemSelectedCallBack(CallBack: ItemSelectedCallBack?) {
        mCallBack = CallBack
    }

    interface ItemSelectedCallBack {
        fun convert(holder: BaseViewHolder?, position: Int)
        fun notifyData(data: List<OptionDetailInfo?>?)
    }
}