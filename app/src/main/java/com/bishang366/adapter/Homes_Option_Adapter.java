package com.bishang366.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.math.BigDecimal;
import java.util.List;

import com.bishang366.R;
import com.bishang366.entity.OptionBean;

/**
 * author: wuzongjie
 * time  : 2018/4/16 0016 18:18
 * desc  :
 */

public class Homes_Option_Adapter extends BaseQuickAdapter<OptionBean.DataBean, BaseViewHolder> {

    public Homes_Option_Adapter(@Nullable List<OptionBean.DataBean> data) {
        super(R.layout.adapter_layout_option, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, OptionBean.DataBean item) {

            helper.setText(R.id.item_home_symbol, item.getCoinSymbol() );
        helper.addOnClickListener(R.id.ll_option);
    }

    private String processAmount(BigDecimal bAmount){
        String v1 = "0.00";
        if(bAmount.compareTo(BigDecimal.ZERO) >= 0){
            v1 = bAmount.setScale(7, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        }

        if(bAmount.compareTo(new BigDecimal(10)) >= 0){
            v1 = bAmount.setScale(6, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        }
        if(bAmount.compareTo(new BigDecimal(100)) >= 0){
            v1 = bAmount.setScale(5, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        }
        // 1100 将以 1.1k显示（千计数）
        if(bAmount.compareTo(new BigDecimal(1000)) >= 0){
            v1 = bAmount.setScale(4, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        }
        if(bAmount.compareTo(new BigDecimal(10000)) >= 0){
            v1 = bAmount.setScale(3, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        }
        if(bAmount.compareTo(new BigDecimal(100000)) >= 0){
            v1 = bAmount.setScale(2, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        }
        // 1100000 将以 1.1m显示（百万计数）
        if(bAmount.compareTo(new BigDecimal(1000000)) >= 0){
            v1 = bAmount.divide(new BigDecimal(1000000)).setScale(2, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString() + "m";
        }
        // 1100000000 将以 1.1b显示（十亿计数）
        if(bAmount.compareTo(new BigDecimal(1000000000)) >= 0){
            v1 = bAmount.divide(new BigDecimal(1000000000)).setScale(2, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString() + "b";
        }
        return v1;
    }

}