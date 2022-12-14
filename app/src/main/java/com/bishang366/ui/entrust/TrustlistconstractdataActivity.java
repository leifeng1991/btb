package com.bishang366.ui.entrust;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.bishang366.R;
import com.bishang366.base.BaseActivity;
import com.bishang366.entity.EntrustHistory_constract;
import com.bishang366.utils.WonderfulDateUtils;
import com.bishang366.utils.WonderfulToastUtils;

public class TrustlistconstractdataActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.ibBack)
    ImageView ibBack;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_open_flat)
    TextView tvOpenFlat;
    @BindView(R.id.tv_fangxiang)
    TextView tvFangxiang;
    @BindView(R.id.tv_entrust_type)
    TextView tvEntrustType;
    @BindView(R.id.tv_trigger_prince)
    TextView tvTriggerPrince;
    @BindView(R.id.tv_enter_price)
    TextView tvEnterPrice;
    @BindView(R.id.tv_transaction_price)
    TextView tvTransactionPrice;
    @BindView(R.id.tv_guarantee_money)
    TextView tvGuaranteeMoney;
    @BindView(R.id.tv_entrust_number)
    TextView tvEntrustNumber;
    @BindView(R.id.tv_poundage)
    TextView tvPoundage;
    @BindView(R.id.tv_compute)
    TextView tvCompute;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    private EntrustHistory_constract.ContentBean constract;

    public static void show(Activity activity, EntrustHistory_constract.ContentBean constract) {
        Intent intent = new Intent(activity, TrustlistconstractdataActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("constract", constract);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_trustlistconstractdata;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        constract = (EntrustHistory_constract.ContentBean) bundle.get("constract");
        //????????????
        if (constract.getIsBlast() == 1) {
            tvType.setText(R.string.ent_statusblast);
        } else {
            if (constract.getStatus().equals("ENTRUST_ING")) {
                tvType.setText(R.string.ent_status1);
            } else if (constract.getStatus().equals("ENTRUST_CANCEL")) {
                tvType.setText(R.string.ent_status2);
            } else if (constract.getStatus().equals("ENTRUST_FAILURE")) {
                tvType.setText(R.string.ent_status3);
            } else if (constract.getStatus().equals("ENTRUST_SUCCESS")) {
                tvType.setText(R.string.ent_status4);
            } else {
            }
        }
        //??????
        String[] times = WonderfulDateUtils.getFormatTime(null, new Date(constract.getCreateTime())).split(" ");
        tvTime.setText(times[0] + " " + times[1]);
        //??????/??????
        if ("OPEN".equals(constract.getEntrustType())) {
            tvOpenFlat.setText(R.string.text_open);
        } else {
            tvOpenFlat.setText(R.string.text_flat);
        }
        //??????
        if ("OPEN".equals(constract.getEntrustType())) {
            if ("BUY".equals(constract.getDirection())) {
                tvFangxiang.setText(R.string.buyOpenmore);
                tvFangxiang.setTextColor(getResources().getColor(R.color.typeGreen));
            } else {
                tvFangxiang.setText(R.string.sellOpennull);
                tvFangxiang.setTextColor(getResources().getColor(R.color.typeRed));
            }
        } else {
            if ("BUY".equals(constract.getDirection())) {
                tvFangxiang.setText(R.string.buyflatnull);
                tvFangxiang.setTextColor(getResources().getColor(R.color.typeGreen));
            } else {
                tvFangxiang.setText(R.string.sellflatmore);
                tvFangxiang.setTextColor(getResources().getColor(R.color.typeRed));
            }
        }
        //????????????    ?????????
        if (constract.getIsFromSpot() == 1) {
            tvEntrustType.setText(R.string.text_plan_entrust);
            tvTriggerPrince.setText(getpoint(constract.getTriggerPrice()));
        } else {
            if (constract.getType().equals("LIMIT_PRICE")) {
                tvEntrustType.setText(R.string.text_limit_entrust);
                tvTriggerPrince.setText("--");
            } else if (constract.getType().equals("MARKET_PRICE")) {
                tvEntrustType.setText(R.string.text_Market_entrust);
                tvTriggerPrince.setText("--");
            }
//            else {
//                tvEntrustType.setText(R.string.text_plan_entrust);
//            }
        }
        //?????????
        tvEnterPrice.setText(getpoint(constract.getEntrustPrice()));
        //?????????
        tvTransactionPrice.setText(getpoint(constract.getTradedPrice()));
        //?????????
        tvGuaranteeMoney.setText(getpoint(constract.getPrincipalAmount()) + "USDT");
        //????????????
        tvEntrustNumber.setText((int) constract.getVolume() + WonderfulToastUtils.getString(this,R.string.zhang));
        //?????????
        if (constract.getStatus() != "ENTRUST_CANCEL") {
            if (constract.getEntrustType().equals("OPEN")) {
                tvPoundage.setText(constract.getOpenFee() + "");
            }
            if (constract.getEntrustType().equals("CLOSE")) {
                tvPoundage.setText(constract.getCloseFee() + "");
            }
        } else {
            tvPoundage.setText("--");
        }

        //????????????
        if (constract.getProfitAndLoss() == 0) {
            tvCompute.setText("--");
        } else {
            if (constract.getProfitAndLoss() > 0) {
                tvCompute.setText(getpoint(constract.getProfitAndLoss()));
                tvCompute.setTextColor(getResources().getColor(R.color.typeGreen));
            } else {
                tvCompute.setText(getpoint(constract.getProfitAndLoss()));
                tvCompute.setTextColor(getResources().getColor(R.color.typeRed));
            }
        }
    }

    @Override
    protected void obtainData() {
        ibBack.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibBack:
                finish();
                break;
        }
    }

    public String getpoint(double data) {
        String format = new DecimalFormat("#.00").format(data);
        BigDecimal bg = new BigDecimal(format);
        String s = bg.setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
        return s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}