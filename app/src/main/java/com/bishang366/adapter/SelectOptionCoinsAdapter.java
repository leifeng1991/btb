package com.bishang366.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.bishang366.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5.
 */

public class SelectOptionCoinsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SelectOptionCoinsAdapter(@LayoutRes int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);

    }
    @Override
    protected void convert(final BaseViewHolder helper, String item) {

        helper.setText(R.id.tvCoin, item);

    }
}
