package com.bishang366.ui.option

import com.bishang366.R
import com.bishang366.entity.CompensationBean
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class CompensationAdapter(layoutResId: Int, data: List<CompensationBean>?) : BaseQuickAdapter<CompensationBean, BaseViewHolder>(layoutResId, data) {
    private var mCallBack: ItemSelectedCallBack? = null

    override fun convert(helper: BaseViewHolder, item: CompensationBean) {
        helper.setText(R.id.ctc_createtime, "${item.startTime}-${item.endTime}")
        helper.setText(R.id.ctc_amount, ": ${item.orderNum}")
        if (mCallBack != null) {
            mCallBack!!.convert(helper, helper.layoutPosition)
        }
    }

    fun setItemSelectedCallBack(CallBack: ItemSelectedCallBack?) {
        mCallBack = CallBack
    }

    interface ItemSelectedCallBack {
        fun convert(holder: BaseViewHolder?, position: Int)
    }
}