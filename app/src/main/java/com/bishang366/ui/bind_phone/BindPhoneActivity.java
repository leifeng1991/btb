package com.bishang366.ui.bind_phone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.bishang366.R;
import com.bishang366.ui.country.CountryActivity;
import com.bishang366.base.BaseActivity;
import com.bishang366.entity.Country;
import com.bishang366.utils.SharedPreferenceInstance;
import com.bishang366.utils.WonderfulCodeUtils;
import com.bishang366.utils.WonderfulStringUtils;
import com.bishang366.utils.WonderfulToastUtils;

import butterknife.BindView;
import com.bishang366.app.Injection;

public class BindPhoneActivity extends BaseActivity implements BindPhoneContract.View {
    @BindView(R.id.ibBack)
    ImageButton ibBack;

    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    @BindView(R.id.tvCountry)
    TextView tvCountry;
    @BindView(R.id.tvAreaCode)
    TextView tvAreaCode;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etCode)
    EditText etCode;
    @BindView(R.id.tvSend)
    TextView tvSend;
    @BindView(R.id.etPwd)
    EditText etPwd;
    @BindView(R.id.tvBind)
    TextView tvBind;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    private int type = -1;
    private Country country = new Country();
    private BindPhoneContract.Presenter presenter;
    private CountDownTimer timer;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, BindPhoneActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        country.setAreaCode("86");
        new BindPhonePresenter(Injection.provideTasksRepository(getApplicationContext()), this);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountryActivity.actionStart(BindPhoneActivity.this);
            }
        });
        tvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCode();
            }
        });
        tvBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindPhone();
            }
        });
    }

    private void sendCode() {
        String phone = etPhone.getText().toString();
        if (WonderfulStringUtils.isEmpty(phone)) return;
        presenter.sendCode(getToken(), /*tvAreaCode.getText().toString() +*/ phone,country.getAreaCode());
        tvSend.setEnabled(false);
    }

    private void bindPhone() {
        String password = etPwd.getText().toString();
        String phone = etPhone.getText().toString();
        String code = etCode.getText().toString();
        if (WonderfulStringUtils.isEmpty(password, phone, code)) return;
        presenter.bindPhone(getToken(), /*tvAreaCode.getText().toString() + "" + */phone, code, password);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CountryActivity.RETURN_COUNTRY:
                if (data == null) return;
                country = (Country) data.getSerializableExtra("country");
                if (SharedPreferenceInstance.getInstance().getLanguageCode() == 1) {
                    tvCountry.setText(country.getZhName());
                }else tvCountry.setText(country.getEnName());
                tvAreaCode.setText("+" + country.getAreaCode());
                break;
        }
    }

    @Override
    public void setPresenter(BindPhoneContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindPhoneSuccess(String obj) {
        WonderfulToastUtils.showToast(obj);
        finish();
    }

    @Override
    public void bindPhoneFail(Integer code, String toastMessage) {
        WonderfulCodeUtils.checkedErrorCode(this, code, toastMessage);
    }

    @Override
    public void sendCodeSuccess(String obj) {
        fillCodeView(90L * 1000);
    }

    private void fillCodeView(long time) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        timer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvSend.setText(WonderfulToastUtils.getString(BindPhoneActivity.this,R.string.re_send)+"(" + millisUntilFinished / 1000 + "s)");
            }

            @Override
            public void onFinish() {
                tvSend.setText(WonderfulToastUtils.getString(BindPhoneActivity.this,R.string.send_code));
                tvSend.setEnabled(true);
                timer.cancel();
                timer = null;
            }
        };
        timer.start();
    }

    @Override
    public void sendCodeFail(Integer code, String toastMessage) {
        tvSend.setEnabled(true);
        WonderfulCodeUtils.checkedErrorCode(this, code, toastMessage);
    }
}
