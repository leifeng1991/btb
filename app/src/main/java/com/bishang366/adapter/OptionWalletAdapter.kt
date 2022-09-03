package com.bishang366.adapter

import android.support.annotation.LayoutRes
import com.bishang366.R
import com.bishang366.entity.WalletInfo
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import java.math.BigDecimal

/**
 * Created by Administrator on 2018/2/5.
 */
class OptionWalletAdapter(@LayoutRes layoutResId: Int, data: List<WalletInfo?>?) : BaseQuickAdapter<WalletInfo, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: WalletInfo) {
        helper.setText(R.id.tvCoinUnit, item.coin?.unit)
                .setText(R.id.tvCanUse, processPrice(BigDecimal(item.balance)))
                .setText(R.id.tv_suocang, processPrice(BigDecimal(item.balance)))
                .setText(R.id.tvFrozon, processPrice(BigDecimal(item.frozenBalance)))
                .addOnClickListener(R.id.tvRecharge).addOnClickListener(R.id.tvExtract)
    }

    private fun processPrice(bPrice: BigDecimal): String {
        if (bPrice.compareTo(BigDecimal.valueOf(1000000)) >= 0) {
            return bPrice.setScale(0, BigDecimal.ROUND_DOWN).toPlainString()
        }
        if (bPrice.compareTo(BigDecimal.valueOf(100000)) >= 0) {
            return bPrice.setScale(1, BigDecimal.ROUND_DOWN).toPlainString()
        }
        if (bPrice.compareTo(BigDecimal.valueOf(10000)) >= 0) {
            return bPrice.setScale(2, BigDecimal.ROUND_DOWN).toPlainString()
        }
        if (bPrice.compareTo(BigDecimal.valueOf(1000)) >= 0) {
            return bPrice.setScale(3, BigDecimal.ROUND_DOWN).toPlainString()
        }
        if (bPrice.compareTo(BigDecimal.valueOf(100)) >= 0) {
            return bPrice.setScale(4, BigDecimal.ROUND_DOWN).toPlainString()
        }
        if (bPrice.compareTo(BigDecimal.valueOf(10)) >= 0) {
            return bPrice.setScale(5, BigDecimal.ROUND_DOWN).toPlainString()
        }
        return if (bPrice.compareTo(BigDecimal.valueOf(1)) >= 0) {
            bPrice.setScale(6, BigDecimal.ROUND_DOWN).toPlainString()
        } else bPrice.setScale(7, BigDecimal.ROUND_DOWN).toPlainString()
    }
}