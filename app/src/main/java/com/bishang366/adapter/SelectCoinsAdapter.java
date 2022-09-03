package com.bishang366.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import com.bishang366.R;
import com.bishang366.entity.WalletConstract;

/**
 * Created by Administrator on 2018/2/5.
 */

public class SelectCoinsAdapter extends BaseQuickAdapter<WalletConstract, BaseViewHolder> {
    public SelectCoinsAdapter(@LayoutRes int layoutResId, @Nullable List<WalletConstract> data) {
        super(layoutResId, data);

    }
    @Override
    protected void convert(final BaseViewHolder helper, WalletConstract item) {

        helper.setText(R.id.tvCoin, item.getContractCoin().getCoinSymbol());

    }
}
