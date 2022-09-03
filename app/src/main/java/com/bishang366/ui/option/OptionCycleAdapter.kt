package com.bishang366.ui.option

import com.bishang366.R
import com.bishang366.entity.CycleBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class OptionCycleAdapter(layoutResId: Int, data: List<CycleBean>?) : BaseQuickAdapter<CycleBean, BaseViewHolder>(layoutResId, data) {
    private var mCallBack: ItemSelectedCallBack? = null
    override fun convert(helper: BaseViewHolder, item: CycleBean) {
        helper.setText(R.id.tv_time, "${item.cycleLength}")
        helper.setText(R.id.tv_percent, "${item.cycleRate*100}%")
        if (mCallBack != null) {
            mCallBack!!.convert(helper, helper.layoutPosition)
        }
    }

    fun setItemSelectedCallBack(CallBack: ItemSelectedCallBack?) {
        mCallBack = CallBack
    }

    interface ItemSelectedCallBack {
        fun convert(holder: BaseViewHolder, position: Int)
    }
}