package com.bishang366.ui.option

import com.bishang366.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class OptionModeAdapter(layoutResId: Int, data: List<String?>?) : BaseQuickAdapter<String?, BaseViewHolder>(layoutResId, data) {
    private var mCallBack: ItemSelectedCallBack? = null
    override fun convert(helper: BaseViewHolder, item: String?) {
        helper.setText(R.id.tv_coin, item)
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