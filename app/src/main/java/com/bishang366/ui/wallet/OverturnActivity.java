package com.bishang366.ui.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bishang366.R;
import com.bishang366.app.Injection;
import com.bishang366.app.MyApplication;
import com.bishang366.app.UrlFactory;
import com.bishang366.base.BaseActivity;
import com.bishang366.entity.WalletConstract;
import com.bishang366.entity.Wallet_Coin;
import com.bishang366.utils.SharedPreferenceInstance;
import com.bishang366.utils.WonderfulCodeUtils;
import com.bishang366.utils.WonderfulLogUtils;
import com.bishang366.utils.WonderfulToastUtils;
import com.bishang366.utils.okhttp.StringCallback;
import com.bishang366.utils.okhttp.WonderfulOkhttpUtils;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Request;

//划转
public class OverturnActivity extends BaseActivity implements OverturnContract.View {

    @BindView(R.id.ibBack)
    ImageButton ibBack;
    @BindView(R.id.view_back)
    View viewBack;
    @BindView(R.id.ibDetail)
    TextView ibDetail;
    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    @BindView(R.id.tvc)
    TextView tvc;
    @BindView(R.id.tvd)
    TextView tvd;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.ll_switch)
    LinearLayout llSwitch;
    @BindView(R.id.tv_coins)
    TextView tvCoins;
    @BindView(R.id.iv_arrow)
    ImageView ivArrow;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_coin)
    TextView tvCoin;
    @BindView(R.id.edit_number)
    EditText editNumber;
    @BindView(R.id.tv_top1)
    TextView tvTop1;
    @BindView(R.id.tv_top2)
    TextView tvTop2;
    @BindView(R.id.tv_bottom1)
    TextView tvBottom1;
    @BindView(R.id.tv_bottom2)
    TextView tvBottom2;
    @BindView(R.id.iv_top)
    ImageView ivTop;
    @BindView(R.id.iv_bottom)
    ImageView ivBottom;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.rl_boottom)
    RelativeLayout rlBoottom;
    @BindView(R.id.rl_coin)
    RelativeLayout rlCoin;
    @BindView(R.id.tv_coin_account)
    TextView tvCoinAccount;

    private int switch_type = 1;//表示币币在上面  2表示币币现在在下面
    private int coin_type = 0;//获取现在显示的币种是列表的第几个
    private OverturnContract.Presenter presenter;
    private List<WalletConstract> constracts = new ArrayList<>();
    private Wallet_Coin coin;

    /**
     * 账户类型
     * 1 永续合约
     * 2 期权合约
     */
    private int accountType = 1;

    private String seleCoinName = "";


    private String qiQuanHeYueBalance = "";
    private String qiQuanBiBiBalance = "";

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, OverturnActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_overturn;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new OverturnPresenter(Injection.provideTasksRepository(getApplicationContext()), this);
        rlTop.setEnabled(false);
        tvTop2.setText(getResources().getText(R.string.tv_balance) + ": 0.0000 USDT");
        tvBottom2.setText(getResources().getText(R.string.tv_balance) + ": 0.0000 USDT");
        tvCoinAccount.setText(getResources().getText(R.string.constract) + "" + getResources().getText(R.string.contract) + "" + getResources().getText(R.string.tv_currency));
    }

    @Override
    protected void obtainData() {

    }

    @Override
    protected void fillWidget() {

    }

    @Override
    protected void loadData() {
        presenter.myWalletUsdt(getToken());
        presenter.myWalletList(getToken());
    }

    @Override
    public void setPresenter(OverturnContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        if (!isSetTitle) {
            ImmersionBar.setTitleBar(this, llTitle);
            isSetTitle = true;
        }
    }

    //点击事件
    @OnClick({R.id.ibBack, R.id.ll_switch, R.id.rl_top, R.id.rl_boottom, R.id.tv_all, R.id.rl_coin, R.id.tvOverturn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibBack:
                finish();
                break;
            case R.id.ll_switch://上下切换账户
                if (switch_type == 1) {//币币切换到下面
//                    tvTop1.setText(WonderfulToastUtils.getString(this, R.string.tv_constract_account));
//                    tvBottom1.setText(WonderfulToastUtils.getString(this, R.string.tv_coins) + "(USDT)");
                    switch_type = 2;
                    setAccountType();
                    ivTop.setVisibility(View.VISIBLE);
                    ivBottom.setVisibility(View.GONE);
                    rlTop.setEnabled(true);
                    rlBoottom.setEnabled(false);
                    editNumber.setText("");
                    switch (accountType){
                        case 1:
                            getCoin(coin);
                            getConstract(constracts);
                            break;
                        case 2:
                            tvTop2.setText(getResources().getText(R.string.tv_balance)+qiQuanHeYueBalance+seleCoinName);
                            tvBottom2.setText(getResources().getText(R.string.tv_balance)+qiQuanBiBiBalance+seleCoinName);
                            break;
                    }

                } else if (switch_type == 2) {//币币切换到上面
//                    tvTop1.setText(WonderfulToastUtils.getString(this, R.string.tv_coins) + "(USDT)");
//                    tvBottom1.setText(WonderfulToastUtils.getString(this, R.string.tv_constract_account));
                    switch_type = 1;
                    setAccountType();
                    ivTop.setVisibility(View.GONE);
                    ivBottom.setVisibility(View.VISIBLE);
                    rlTop.setEnabled(false);
                    rlBoottom.setEnabled(true);
                    editNumber.setText("");
                    switch (accountType){
                        case 1:
                            getCoin(coin);
                            getConstract(constracts);
                            break;
                        case 2:
                            tvTop2.setText(getResources().getText(R.string.tv_balance)+qiQuanBiBiBalance+seleCoinName);
                            tvBottom2.setText(getResources().getText(R.string.tv_balance)+qiQuanHeYueBalance+seleCoinName);
                            break;
                    }
                }
                break;
            case R.id.rl_top:
            case R.id.rl_boottom:
//                SelectAccountActivity.actionStart(this, constracts);
                Intent intent = new Intent(OverturnActivity.this, SelectAccountActivity.class);
                intent.putExtra("constract", (Serializable) constracts);
                startActivityForResult(intent, 100);
                break;
            case R.id.tv_all:
                //点击全部
                switch (accountType){
                    case 1:
                        if (switch_type == 1) {
                            editNumber.setText(coin.getBalance() + "");
                        } else if (switch_type == 2) {
                            for (int i = 0; i < constracts.size(); i++) {
                                if (constracts.get(i).getContractCoin().getCoinSymbol().equals(tvCoins.getText().toString().trim())) {
                                    editNumber.setText(constracts.get(i).getUsdtBalance() + "");
                                    return;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (switch_type==1){
                            editNumber.setText(qiQuanBiBiBalance);
                        }else if (switch_type==2){
                            editNumber.setText(qiQuanHeYueBalance);
                        }
                        break;
                }
                break;
            case R.id.rl_coin:
//                SelectCoinActivity.actionStart(this, constracts);
                if (accountType == 1) {
                    Intent intent2 = new Intent(this, SelectCoinActivity.class);
                    intent2.putExtra("constract", (Serializable) constracts);
                    startActivityForResult(intent2, 200);
                } else {
                    Intent intent3 = new Intent(this, SeleteOptionCoinActivity.class);
                    startActivityForResult(intent3, 300);
                }

                break;
            case R.id.tvOverturn:
                String trim = editNumber.getText().toString().trim();
                String coinName = tvCoins.getText().toString().trim();
                if (!trim.equals("")) {
                    switch (accountType) {
                        case 1:
                            Log.e("@@@","111111");
                            if (switch_type == 1) {
                                presenter.RequesTrans(getToken(), "USDT", "0", "1", coin.getId() + "", constracts.get(coin_type).getId() + "", trim);
                            } else if (switch_type == 2) {
                                presenter.RequesTrans(getToken(), "USDT", "1", "0", constracts.get(coin_type).getId() + "", coin.getId() + "", trim);
                            }
                            break;
                        case 2:
                            Log.e("@@@","22222222");
//
                            if (switch_type == 1) {
                                Log.e("@@@","3333333");
                                walletTrans(coinName, "0", "2", trim);
                            } else if (switch_type == 2) {
                                Log.e("@@@","444444444");
                                walletTrans(coinName, "2", "0", trim);
                            }
                            break;
                    }

                } else {
                    WonderfulToastUtils.showToast(getResources().getText(R.string.tv_input_overturn_number) + "");
                }
                break;
        }
    }

//    unit:USDT
//    from:0
//    to:1
//    fromWalletId:9113
//    toWalletId:504
//    amount:1

    @Override
    public void myWalletUsdtSuccess(Wallet_Coin obj) {
        coin = obj;
        getCoin(coin);
    }

    @Override
    public void myWalletListSuccess(List<WalletConstract> obj) {
        constracts.addAll(obj);
        seleCoinName = constracts.get(0).getContractCoin().getCoinSymbol();
        tvCoins.setText(seleCoinName);
        getConstract(constracts);
    }

    @Override
    public void myTransSuccess(String obj) {
        Toast.makeText(this, "" + obj, Toast.LENGTH_SHORT).show();
        editNumber.setText("");
        presenter.myWalletUsdt(getToken());
        presenter.myWalletList(getToken());
    }

    @Override
    public void myWalletFail(Integer code, String toastMessage) {
        WonderfulCodeUtils.checkedErrorCode(this, code, toastMessage);
    }

    //刷新币币资产
    private void getCoin(Wallet_Coin coin) {
        if (switch_type == 1) {
            tvTop2.setText(getResources().getText(R.string.tv_balance) + ": " + ProcessPrice(coin.getBalance()) + " USDT");
        } else if (switch_type == 2) {
            tvBottom2.setText(getResources().getText(R.string.tv_balance) + ": " + ProcessPrice(coin.getBalance()) + " USDT");
        }
    }

    //刷新其他账户资产
    private void getConstract(List<WalletConstract> constracts) {
        boolean isNoHavaCoin = true;
        for (int i = 0; i < constracts.size(); i++) {
            if (constracts.get(i).getContractCoin().getCoinSymbol().equals(tvCoins.getText().toString().trim())) {
                isNoHavaCoin = false;
                if (switch_type == 1) {
                    tvBottom2.setText(getResources().getText(R.string.tv_balance) + ": " + ProcessPrice(constracts.get(i).getUsdtBalance())+ " " + constracts.get(i).getContractCoin().getBaseSymbol());
                    coin_type = i;
                } else if (switch_type == 2) {
                    tvTop2.setText(getResources().getText(R.string.tv_balance) + ": " + ProcessPrice(constracts.get(i).getUsdtBalance())+ " " + constracts.get(i).getContractCoin().getBaseSymbol());
                    coin_type = i;
                }
            }
        }

        if (isNoHavaCoin){
            presenter.myWalletUsdt(getToken());
            presenter.myWalletList(getToken());
        }
    }

    private String ProcessPrice(double Price) {
        BigDecimal bigDecimal = new BigDecimal(Price);
        return bigDecimal.setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 101) {
            //选择永续账户or期权账户
            if (data != null) {
                accountType = data.getIntExtra("accountType", 1);
                switch (accountType) {
                    case 1:
                        tvCoin.setText("USDT");
                        getConstract(constracts);
                        break;
                    case 2:
                        seleCoinName="USDT";
                        tvCoins.setText(seleCoinName);
                        switch (switch_type) {
                            case 1:
                                tvBottom2.setText("");
                                break;
                            case 2:
                                tvTop2.setText("");
                                break;
                        }
                        if (!TextUtils.isEmpty(seleCoinName)) {
                            tvCoin.setText(seleCoinName);
                            getSecondWalletBalance(seleCoinName);
                            getWallet(SharedPreferenceInstance.getInstance().getTOKEN(),seleCoinName);
                        } else {
                            tvCoin.setText(tvCoins.getText().toString().trim());
                            getSecondWalletBalance(tvCoins.getText().toString().trim());
                            getWallet(SharedPreferenceInstance.getInstance().getTOKEN(),tvCoins.getText().toString().trim());
                        }

                        break;
                }
                setAccountType();
            }
        } else if (requestCode == 200 && resultCode == 201) {
            //永续合约--选择币种
            if (data != null) {
                seleCoinName = data.getStringExtra("coinSymbol");
                tvCoins.setText(seleCoinName);
                editNumber.setText("");
                getConstract(constracts);
            }
        } else if (requestCode == 300 && resultCode == 301) {
            //期权合约---选择币种
            if (data != null) {
                seleCoinName = data.getStringExtra("coinSymbol");
                tvCoins.setText(seleCoinName);
                editNumber.setText("");
                tvCoin.setText(seleCoinName);
                Log.e("@@@", "期权合约---选择币种");
                switch (switch_type) {
                    case 1:
                        tvBottom2.setText("");
                        break;
                    case 2:
                        tvTop2.setText("");
                        break;
                }
                getSecondWalletBalance(seleCoinName);
                getWallet(SharedPreferenceInstance.getInstance().getTOKEN(),seleCoinName);
            }
        }
    }


    /**
     * 传过来的币种
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void WalletMessage(WalletMessage coin) {
//        tvCoins.setText(coin.getCoin());
//        getConstract(constracts);
//        editNumber.setText("");
    }


    private void setAccountType() {
        switch (accountType) {
            case 1:
                if (switch_type == 1) {
                    tvTop1.setText(getResources().getText(R.string.tv_coins));
                    tvBottom1.setText(getResources().getText(R.string.tv_constract_account));
                } else {
                    tvTop1.setText(getResources().getText(R.string.tv_constract_account));
                    tvBottom1.setText(getResources().getText(R.string.tv_coins));
                }
                //tvCoinAccount.setText(getResources().getText(R.string.second_contract) + ""  + getResources().getText(R.string.tv_currency));
                tvCoinAccount.setText(getResources().getText(R.string.perpetual_contract_currency));
                break;
            case 2:
                if (switch_type == 1) {
                    tvTop1.setText(getResources().getText(R.string.tv_coins));
                    tvBottom1.setText(getResources().getText(R.string.option_contract_account));
                } else {
                    tvTop1.setText(getResources().getText(R.string.option_contract_account));
                    tvBottom1.setText(getResources().getText(R.string.tv_coins));
                }
                tvCoinAccount.setText(getResources().getText(R.string.option_contract_currency));
                break;
        }
    }


    /**
     * 查询期权账户币种可用余额
     *
     * @param coinSymbol
     */
    private void getSecondWalletBalance(String coinSymbol) {
        WonderfulLogUtils.logi("@@@", "查询期权账户可用余额 req:coinSymbol=$coinSymbol");
        WonderfulLogUtils.logi("@@@", "url===" + UrlFactory.getSecondWalletBalance(coinSymbol));
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondWalletBalance(coinSymbol))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onResponse(String response) {
                        WonderfulLogUtils.logi("@@@", "查询期权账户可用余额$response" + response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            int code = jsonObject.optInt("code");
                            if (code == 0) {
                                String data = new BigDecimal(jsonObject.optString("data")).toPlainString();
                                qiQuanHeYueBalance = data;
                                switch (switch_type) {
                                    case 1:
                                        tvBottom2.setText(getResources().getText(R.string.tv_balance)+ data + coinSymbol);
                                        break;
                                    case 2:
                                        tvTop2.setText(getResources().getText(R.string.tv_balance) + data + coinSymbol);
                                        break;
                                }
                            }else if (code==4000){
                                MyApplication.getApp().loginAgain(OverturnActivity.this);
                                SharedPreferenceInstance.getInstance().saveaToken("");
                                SharedPreferenceInstance.getInstance().saveTOKEN("");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        super.onError(request, e);
                        WonderfulLogUtils.logi("@@@", "查询期权账户可用余额 onError" + e.getMessage());
                    }
                });
    }


    public void getWallet(String token, String coinName) {
        WonderfulOkhttpUtils.post().url(UrlFactory.getWalletUrl() + coinName)
                .addParams("x-auth-token", token)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                super.onError(request, e);
            }

            @Override
            public void onResponse(String response) {
                WonderfulLogUtils.logi("@@@:", "getWallet:" + response.toString());
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int code = jsonObject.optInt("code");
                    if (code==0){
                        JSONObject data = jsonObject.optJSONObject("data");
                        String balance = new BigDecimal(data.optString("balance")).toPlainString();
                        qiQuanBiBiBalance = balance;
                        switch (switch_type){
                            case 1:
                                tvTop2.setText(getResources().getText(R.string.tv_balance)+balance+coinName);
                                break;
                            case 2:
                                tvBottom2.setText(getResources().getText(R.string.tv_balance)+balance+coinName);
                                break;
                        }
                    }else if (code==4000){
                        MyApplication.getApp().loginAgain(OverturnActivity.this);
                        SharedPreferenceInstance.getInstance().saveaToken("");
                        SharedPreferenceInstance.getInstance().saveTOKEN("");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * 期权账户币种资金划转
     *
     * @param unit
     * @param from
     * @param to
     * @param amount
     */
    private void walletTrans(String unit, String from, String to, String amount) {
        Log.e("@@@","unit==="+unit);
        Log.e("@@@","from==="+from);
        Log.e("@@@","to==="+to);
        Log.e("@@@","amount==="+amount);
        displayLoadingPopup();
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondWalletTrans())
                .addParams("unit", unit)//划转币种单位 例如 BTC
                .addParams("from", from)//转出钱包类型 0币币 2期权
                .addParams("to", to)//转入钱包类型 0币币 2期权
                .addParams("amount", amount)//划转数量
                .build().execute(new StringCallback() {
            @Override
            public void onResponse(String response) {
                hideLoadingPopup();
                WonderfulLogUtils.logi("@@@", "资金划转:$response" + response.toString());
                editNumber.setText("");
                WonderfulToastUtils.showToast(getResources().getString(R.string.success));
                getSecondWalletBalance(unit);
                getWallet(SharedPreferenceInstance.getInstance().getTOKEN(),unit);
            }

            @Override
            public void onError(Request request, Exception e) {
                super.onError(request, e);
                hideLoadingPopup();
                WonderfulLogUtils.logi("@@@", "资金划转 onError" + e.getMessage());
            }
        });
    }
}