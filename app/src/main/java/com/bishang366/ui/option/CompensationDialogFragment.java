package com.bishang366.ui.option;


import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.TextView;

import com.bishang366.R;
import com.bishang366.base.BaseDialogFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/31.
 */

public class CompensationDialogFragment extends BaseDialogFragment {

    @BindView(R.id.btnCancel)
    TextView btnCancel;
    @BindView(R.id.rv_current)
    RecyclerView rvCurrent;
    private OptionViewModel optionViewModel;
    private CompensationAdapter adapterCurrent;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_fragment_compensation;
    }

    @Override
    protected void initLayout() {
        window.setGravity(Gravity.CENTER);
    }

    @Override
    protected void initView() {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        optionViewModel = new ViewModelProvider(getViewModelStore(), ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(OptionViewModel.class);

        btnCancel.setOnClickListener(v -> dismiss());
        rvCurrent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapterCurrent = new CompensationAdapter(R.layout.adapter_compensation, optionViewModel.getCompensationBeanS().getValue());
        rvCurrent.setAdapter(adapterCurrent);
        optionViewModel.getCompensationBeanS().observe(this, it -> {
            if (it != null) {
                adapterCurrent.addData(it);
                adapterCurrent.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void fillWidget() {

    }

    @Override
    protected void loadData() {
        optionViewModel.getSecondOptionAllSets();
    }

}
