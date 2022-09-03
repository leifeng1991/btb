package com.bishang366.ui.dialog;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import com.bishang366.R;
import com.bishang366.base.BaseDialogFragment;
import com.bishang366.entity.CurrentEntrust;

/**
 * Created by Administrator on 2018/1/31.
 */

public class EntrustConstractDialogFragment extends BaseDialogFragment {

    @BindView(R.id.llContent)
    LinearLayout llContent;
    @BindView(R.id.tvCancle)
    TextView tvCancle;
    @BindView(R.id.tvCancleOrder)
    TextView tvCancleOrder;

    private CurrentEntrust.ContentBean entrust;

    public static EntrustConstractDialogFragment getInstance(CurrentEntrust.ContentBean entrust) {
        EntrustConstractDialogFragment bottomCustomFragment = new EntrustConstractDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("entrust", entrust);
        bottomCustomFragment.setArguments(bundle);
        return bottomCustomFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_fragment_entrust_constract;
    }

    @Override
    protected void initLayout() {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.windowAnimations = R.style.bottomDialog;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
        window.setBackgroundDrawableResource(android.R.color.transparent);
//        window.setGravity(Gravity.BOTTOM);
//        window.setWindowAnimations(R.style.bottomDialog);
//        window.setLayout(MyApplication.getApp().getmWidth(), WonderfulDpPxUtils.dip2px(getActivity(), 290));
//        int height = 0;
//        if (ImmersionBar.hasNavigationBar(getActivity()))
//            height = WonderfulCommonUtils.getStatusBarHeight(getActivity());
//        window.setLayout(llContent.getWidth(), llContent.getHeight() + WonderfulDpPxUtils.dip2px(getActivity(), height));
    }

    @Override
    protected void initView() {
        tvCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tvCancleOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((OperateCallback) getTargetFragment()).cancleOrder(entrust.getId()+"");
                } catch (Exception e) {
                    if (callback != null) callback.cancleOrder(entrust.getId()+"");
                }

                dismiss();
            }
        });
    }

    private OperateCallback callback;

    public void setCallback(OperateCallback callback) {
        this.callback = callback;
    }

    @Override
    protected void fillWidget() {
        Bundle bundle = getArguments();
        entrust = (CurrentEntrust.ContentBean) bundle.getSerializable("entrust");
        if (entrust == null) {
            dismiss();
            return;
        }
    }
    @Override
    protected void loadData() {

    }

    public interface OperateCallback {
        void cancleOrder(String orderId);
    }

}
