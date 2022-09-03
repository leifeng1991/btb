package com.bishang366.ui.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import com.bishang366.R;
import com.bishang366.base.BaseActivity;
import com.bishang366.entity.WalletConstract;

public class SelectAccountActivity extends BaseActivity {

    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    private List<WalletConstract> constracts;

//    public static void actionStart(Context context, List<WalletConstract> constracts) {
//        Intent intent = new Intent(context, SelectAccountActivity.class);
//        intent.putExtra("constract", (Serializable) constracts);
//        context.startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_select_account;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        constracts = (List<WalletConstract>)getIntent().getSerializableExtra("constract");
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void fillWidget() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        if (!isSetTitle) {
            ImmersionBar.setTitleBar(this, llTitle);
            isSetTitle = true;
        }
    }

    @OnClick({R.id.ibBack, R.id.ll_constract,R.id.ll_wealth_management})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibBack:
                finish();
                break;
            case R.id.ll_constract://永续合约
//                SelectCoinActivity.actionStart(this,constracts);
                Intent intent = new Intent();
                intent.putExtra("accountType",1);
                setResult(101,intent);
                finish();
                break;
            case R.id.ll_wealth_management:
                Intent intent1 = new Intent();
                intent1.putExtra("accountType",2);
                setResult(101,intent1);
                finish();
                break;
        }
    }
}