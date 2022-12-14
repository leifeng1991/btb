package com.bishang366.widget;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bishang366.R;
import com.bishang366.ui.home.ISixContract;
import com.bishang366.utils.SharedPreferenceInstance;
import com.bishang366.utils.WonderfulStringUtils;
import com.bishang366.utils.WonderfulToastUtils;
import com.xw.repo.BubbleSeekBar;

import java.math.BigDecimal;


/**
 * Created by Haocxx
 * on 2019/8/12
 */
public class SixPopFlat extends PopupWindow {

    private View view;
    private TabLayout tab;
    private final Button btnOneBuy;
    private final LinearLayout mOneXian;
    private final LinearLayout mOnetrigger;
    private final LinearLayout mOneSeekBarLin;
    private final EditText mOneTCP;
    private final EditText mOnePrice;
    private final EditText mOnetriggerPrice;
    private final TextView mOneShi;

    private int Position = 0;
    private int isinput = 0;
    private String price;
    private String amout;
    private final BubbleSeekBar mOneSeekBar;


    public SixPopFlat(final Activity activity, final String number, final int sendtype, final int id, final ISixContract.Presenter mPresenter, View.OnClickListener itemsOnClick) {
        this.view = LayoutInflater.from(activity).inflate(R.layout.pop_six_flat, null);
        tab = view.findViewById(R.id.tab);
        btnOneBuy = view.findViewById(R.id.btnOneBuy);
        mOneXian = view.findViewById(R.id.mOneXian);
        mOnetrigger = view.findViewById(R.id.mOnetrigger);
        mOneSeekBarLin = view.findViewById(R.id.mOneSeekBarLin);
        mOneTCP = view.findViewById(R.id.mOneTCP);
        mOnePrice = view.findViewById(R.id.mOnePrice);
        mOnetriggerPrice = view.findViewById(R.id.mOnetriggerPrice);
        mOneShi = view.findViewById(R.id.mOneShi);
        mOneSeekBar = view.findViewById(R.id.mOneSeekBar);

        mOneTCP.setText(number);

        mOneTCP.setOnFocusChangeListener(new View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // ???????????????????????????????????????
                    if (mOneTCP.getText().toString().contains("%")) {
                        isinput = 1;
                        mOneTCP.setText("");
                        mOneSeekBar.setProgress(0);
                    }
                } else {
                    // ???????????????????????????????????????
                    isinput = 0;
                }
            }
        });
        mOneSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListenerAdapter() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                if (fromUser) {  //??????????????????progress
                    mOneTCP.setText(progress + "%");
                    mOneTCP.clearFocus();
                }
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
            }
        });

        mOneSeekBar.setCustomSectionTextArray(new BubbleSeekBar.CustomSectionTextArray() {
            @NonNull
            @Override
            public SparseArray<String> onCustomize(int sectionCount, @NonNull SparseArray<String> array) {
                array.clear();
                array.put(0, "0%");
                array.put(1, "25%");
                array.put(2, "50%");
                array.put(3, "75%");
                array.put(4, "100%");
                return array;
            }
        });

        tab.addTab(tab.newTab().setText(activity.getResources().getText(R.string.text_limit_entrust)));
        tab.addTab(tab.newTab().setText(activity.getResources().getText(R.string.text_Market_entrust)));
        tab.addTab(tab.newTab().setText(activity.getResources().getText(R.string.text_plan_entrust)));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    //??????????????????
                    Position = 0;
                    mOnePrice.setHint(activity.getResources().getText(R.string.text_enter_price_constract));
                    mOnePrice.setText("");
                    mOnetriggerPrice.setText("");
                    mOneXian.setVisibility(View.VISIBLE);
                    mOneShi.setVisibility(View.GONE);
                    mOneTCP.setHint(activity.getResources().getText(R.string.text_number));
                    mOneSeekBarLin.setVisibility(View.VISIBLE);
                    mOnetrigger.setVisibility(View.GONE);
                } else if (tab.getPosition() == 1) {
                    //??????????????????
                    Position = 1;
                    mOnePrice.setHint(activity.getResources().getText(R.string.text_enter_price_constract));
                    mOnePrice.setText("");
                    mOnetriggerPrice.setText("");
                    mOneXian.setVisibility(View.GONE);
                    mOneShi.setVisibility(View.VISIBLE);
                    mOneTCP.setHint(activity.getResources().getText(R.string.text_number));
                    mOneSeekBarLin.setVisibility(View.VISIBLE);
                    mOnetrigger.setVisibility(View.GONE);
                } else if (tab.getPosition() == 2) {
                    Position = 2;
                    mOnePrice.setHint(activity.getResources().getText(R.string.default_market));
                    mOnePrice.setText("");
                    mOnetriggerPrice.setText("");
                    mOneXian.setVisibility(View.VISIBLE);
                    mOneShi.setVisibility(View.GONE);
                    mOnetrigger.setVisibility(View.VISIBLE);
                    mOneSeekBarLin.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        if (sendtype == 1){
            btnOneBuy.setText(activity.getResources().getText(R.string.sellflatmore));
            btnOneBuy.setBackgroundResource(R.color.typeRed);
        }else if (sendtype == 2){
            btnOneBuy.setText(activity.getResources().getText(R.string.buyflatnull));
            btnOneBuy.setBackgroundResource(R.color.typeGreen);
        }


        btnOneBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sale(Position, mOneTCP, mOnePrice, mOnetriggerPrice, number, sendtype, activity,mPresenter,id);
            }
        });


        // ??????????????????
//        bu_true2.setOnClickListener(itemsOnClick);
//        bu_close2.setOnClickListener(itemsOnClick);

        // ?????????????????????
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.alpha = (float) 1.0; //0.0-1.0
                activity.getWindow().setAttributes(lp);
            }
        });
        this.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        /* ???????????????????????? */
        // ????????????
        this.setContentView(this.view);
        // ??????????????????????????????
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = (float) 0.6; //0.0-1.0
        activity.getWindow().setAttributes(lp);

        // ???????????????????????????
        this.setFocusable(true);

        // ???????????????????????????
        this.setBackgroundDrawable(Drawable.createFromPath("#00000000"));

        this.setAnimationStyle(R.style.bottomDialog);
    }



    /**
     * @param type             ??????
     * @param mOneTCP          ??????
     * @param mOnePrice        ??????
     * @param mOnetriggerPrice ?????????
     * @param number
     * @param sendtype
     * @param activity
     * @param mPresenter
     * @param id
     */
    private void Sale(int type, EditText mOneTCP, EditText mOnePrice, EditText mOnetriggerPrice, String number, int sendtype, Activity activity, ISixContract.Presenter mPresenter, int id) {
        switch (type) {
            case 0:
                price = mOnePrice.getText().toString();
                amout = mOneTCP.getText().toString();
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (amout.contains("%")) {
                    String substring = amout.substring(0, amout.length() - 1);
                    if (substring.equals("0")) {
                        WonderfulToastUtils.showToast(activity.getResources().getText(R.string.number_big_zero) + "");
                        return;
                    }
                    double su = (Double.parseDouble(substring) / 100) * Integer.parseInt(number);
                    if (su < 1) {
                        amout = 1 + "";
                    } else {
                        amout = (int) su + "";
                    }
                }

                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.number_big_zero) + "");
                    return;
                }
                if (new BigDecimal(price).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }
                if (Integer.parseInt(amout) > Integer.parseInt(number)) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (sendtype == 1) {
                    //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                    mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                            "1" + "", "1", id + "", "0", price,
                            "0",
                            amout);
                } else if (sendtype == 2) {
                    mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                            "1" + "", "0", id + "", "0", price,
                            "0",
                            amout);
                }

                break;
            case 1:
                price = "0.0";
                amout = mOneTCP.getText().toString();
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_number) + "");
                    return;
                }
                if (amout.contains("%")) {
                    String substring = amout.substring(0, amout.length() - 1);
                    if (substring.equals("0")) {
                        WonderfulToastUtils.showToast(activity.getResources().getText(R.string.number_big_zero) + "");
                        return;
                    }
                    double su = (Double.parseDouble(substring) / 100) * Integer.parseInt(number);
                    if (su < 1) {
                        amout = 1 + "";
                    } else {
                        amout = (int) su + "";
                    }
                }

                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }
                if (Integer.parseInt(amout) > Integer.parseInt(number)) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (sendtype == 1) {
                    //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                    mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                            "0" + "", "1", id + "", "0", price,
                            "0",
                            amout);
                } else if (sendtype == 2) {
                    mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                            "0" + "", "0", id + "", "0", price,
                            "0",
                            amout);
                }
                break;
            case 2:
                String plan = "";
                price = mOnePrice.getText().toString();
                amout = mOneTCP.getText().toString();
                plan = mOnetriggerPrice.getText().toString();
                if (price.equals("")) {
                    price = "0";
                }
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.number_big_zero) + "");
                    return;
                }
                if (new BigDecimal(price).compareTo(BigDecimal.ZERO) < 0) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }
                if (Integer.parseInt(amout) > Integer.parseInt(number)) {
                    WonderfulToastUtils.showToast(activity.getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (sendtype == 1) {
                    //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                    mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                            "2" + "", "1", id + "", plan, price,
                            "0",
                            amout);
                } else if (sendtype == 2) {
                    mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                            "2" + "", "0", id + "", plan, price,
                            "0",
                            amout);
                }
                break;
            default:
        }
    }

}
