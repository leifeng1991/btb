package com.bishang366.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bishang366.R;
import com.bishang366.adapter.CurrentEntrustAdapter;
import com.bishang366.adapter.SellAdapter;
import com.bishang366.app.MyApplication;
import com.bishang366.app.UrlFactory;
import com.bishang366.base.BaseFragment;
import com.bishang366.base.BaseTransFragment;
import com.bishang366.entity.Currency;
import com.bishang366.entity.CurrentEntrust;
import com.bishang366.entity.Detail;
import com.bishang366.entity.Exchange;
import com.bishang366.entity.Favorite;
import com.bishang366.entity.SixInfo;
import com.bishang366.entity.TextItems;
import com.bishang366.entity.modifyleverage;
import com.bishang366.entity.switchpattern;
import com.bishang366.serivce.SocketMessage;
import com.bishang366.serivce.SocketResponse;
import com.bishang366.socket.ISocket;
import com.bishang366.ui.dialog.EntrustConstractDialogFragment;
import com.bishang366.ui.entrust.TrustListConstractActivity;
import com.bishang366.ui.home.presenter.SixImpl;
import com.bishang366.ui.kline.KlineActivity;
import com.bishang366.ui.login.LoginActivity;
import com.bishang366.ui.option.OptionActivityKt;
import com.bishang366.utils.IMyTextChange;
import com.bishang366.utils.LoadDialog;
import com.bishang366.utils.SharedPreferenceInstance;
import com.bishang366.utils.WonderfulCodeUtils;
import com.bishang366.utils.WonderfulLogUtils;
import com.bishang366.utils.WonderfulMathUtils;
import com.bishang366.utils.WonderfulStringUtils;
import com.bishang366.utils.WonderfulToastUtils;
import com.bishang366.utils.okhttp.StringCallback;
import com.bishang366.utils.okhttp.WonderfulOkhttpUtils;
import com.bishang366.widget.SixPopEntrustView;
import com.bishang366.widget.SixPopFlat;
import com.bishang366.widget.SixPopModelView;
import com.bishang366.widget.SixPopMultiplesView;
import com.bishang366.widget.SixPopMultiplesView2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.xw.repo.BubbleSeekBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Request;

/**
 * @author: wuzongjie
 * time  : 2018/4/17 0017 15:20
 */
public class SixFragment extends BaseTransFragment implements MainContract.SixView, RadioGroup.OnCheckedChangeListener, ISixContract.View, View.OnClickListener {
    public static final String TAG = SixFragment.class.getSimpleName();
    @BindView(R.id.ibOpen)
    ImageButton ibOpen;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvTitleOption)
    TextView tvTitleOption;
    @BindView(R.id.text_title_price)
    TextView text_title_price;
    @BindView(R.id.text_title_amount)
    TextView text_title_amount;
    @BindView(R.id.ibMessage)
    ImageView ibMessage;
    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    @BindView(R.id.mRadioGroup)
    RadioGroup mRadioGroup;
    @BindView(R.id.text_to_all)
    RelativeLayout mToAllLayout; // ??????
    @BindView(R.id.recyclerOne)
    RecyclerView mOneRecycler; // ?????????
    @BindView(R.id.recyclerTwo)
    RecyclerView mTwoRecycler; //??????
    @BindView(R.id.recyclersix)
    RecyclerView msixRecycler; // ????????????
    @BindView(R.id.mTvsix)
    TextView mTvsix;
    @BindView(R.id.mOneLayout)
    LinearLayout mOneLayout; // ??????
    @BindView(R.id.mTwoLayout)
    LinearLayout mTwoLayout; // ??????
    @BindView(R.id.mOneShi)
    TextView mOneShi;
    @BindView(R.id.mOneXian)
    LinearLayout mOneXian;
    @BindView(R.id.mTwoShi)
    TextView mTwoShi;
    @BindView(R.id.mTwoXian)
    LinearLayout mTwoXian;
    @BindView(R.id.mOnePrice)
    EditText mOnePriceEdit;
    @BindView(R.id.mOneAdd)
    TextView mOneAdd; // +
    @BindView(R.id.mOneSum)
    TextView mOneSub; // -
    @BindView(R.id.mTwoPrice)
    EditText mTwoPriceEdit;
    @BindView(R.id.mTwoAdd)
    TextView mTwoAdd; // +
    @BindView(R.id.mTwoSub)
    TextView mTwoSub; // -
    @BindView(R.id.mTvPanJia)
    TextView mPanJia;
    @BindView(R.id.mTvMoney)
    TextView mPanMoney;
    @BindView(R.id.mOneYuE)
    TextView mOneYuE;
    @BindView(R.id.mTwoYuE)
    TextView mTwoYuE;
    @BindView(R.id.mOneTCP)
    EditText mOneTcpEdit;
    @BindView(R.id.mTwoTCP)
    EditText mTwoTcpEdit;
    @BindView(R.id.btnOneBuy)
    Button btnBuy;
    @BindView(R.id.btnTwoPost)
    Button btnSale;
    @BindView(R.id.mOneDeal)
    TextView mOneDeal; // ???????????????
    @BindView(R.id.mTwoDeal)
    TextView mTwoDeal;
    @BindView(R.id.btn_toLogin)
    TextView btnLogin;
    @BindView(R.id.mOneJiaoYi)
    RelativeLayout mOneJiaoYi;
    @BindView(R.id.mTwoJiaoYi)
    RelativeLayout mTwoJiaoYi;
    @BindView(R.id.mOneSeekBar)
    BubbleSeekBar mOneSeekBar;
    @BindView(R.id.mTwoSeekBar)
    BubbleSeekBar mTwoSeekBar;
    Unbinder unbinder;
    @BindView(R.id.ivCollect)
    ImageView ivCollect;
    @BindView(R.id.mTabOne)
    RadioButton mTabOne;
    @BindView(R.id.mTabTwo)
    RadioButton mTabTwo;
    @BindView(R.id.ll_current_trust)
    LinearLayout llCurrentTrust;
    @BindView(R.id.ll_history_trust)
    LinearLayout llHistoryTrust;
    @BindView(R.id.tv_current_trust)
    TextView tvCurrentTrust;
    @BindView(R.id.tv_history_trust)
    TextView tvHistoryTrust;
    @BindView(R.id.current_trust_underline)
    View currentTrustUnderline;
    @BindView(R.id.history_trust_underline)
    View historyTrustUnderline;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindArray(R.array.home_six_top_tab)
    String[] tabs;
    @BindView(R.id.rl_model_spinner)
    RelativeLayout rlModelSpinner;


    Unbinder unbinder1;
    @BindView(R.id.tv_model)
    TextView tvModel;
    @BindView(R.id.tv_entrust)
    TextView tvEntrust;
    @BindView(R.id.rl_entrust_spinner)
    RelativeLayout rlEntrustSpinner;
    @BindView(R.id.tv_multiples)
    TextView tvMultiples;
    @BindView(R.id.rl_multiples_spinner)
    RelativeLayout rlMultiplesSpinner;
    @BindView(R.id.tv_zhang_color)
    TextView tvZhangColor;
    @BindView(R.id.Zhang)
    TextView Zhang;
    @BindView(R.id.tv_zhang_color2)
    TextView tvZhangColor2;
    @BindView(R.id.Zhang2)
    TextView Zhang2;
    @BindView(R.id.mOnetriggerPrice)
    EditText mOnetriggerPrice;
    @BindView(R.id.mOnetrigger)
    LinearLayout mOnetrigger;
    @BindView(R.id.mTwotriggerPrice2)
    EditText mTwotriggerPrice2;
    @BindView(R.id.mTwotrigger2)
    LinearLayout mTwotrigger2;
    @BindView(R.id.mOneSeekBarLin)
    LinearLayout mOneSeekBarLin;
    @BindView(R.id.mTwoSeekBarLin)
    LinearLayout mTwoSeekBarLin;
    @BindView(R.id.buy_earnings)
    TextView buyEarnings;
    @BindView(R.id.buy_rate)
    TextView buyRate;
    @BindView(R.id.buy_one)
    TextView buyOne;
    @BindView(R.id.buy_two)
    TextView buyTwo;
    @BindView(R.id.buy_three)
    TextView buyThree;
    @BindView(R.id.buy_four)
    TextView buyFour;
    @BindView(R.id.buy_five)
    TextView buyFive;
    @BindView(R.id.buy_six)
    TextView buySix;
    @BindView(R.id.ll_buy)
    LinearLayout llBuy;
    @BindView(R.id.sell_earnings)
    TextView sellEarnings;
    @BindView(R.id.sell_rate)
    TextView sellRate;
    @BindView(R.id.sell_one)
    TextView sellOne;
    @BindView(R.id.sell_two)
    TextView sellTwo;
    @BindView(R.id.sell_three)
    TextView sellThree;
    @BindView(R.id.sell_four)
    TextView sellFour;
    @BindView(R.id.sell_five)
    TextView sellFive;
    @BindView(R.id.sell_six)
    TextView sellSix;
    @BindView(R.id.ll_sell)
    LinearLayout llSell;
    @BindView(R.id.ll_deal)
    LinearLayout llDeal;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.tv_flat1)
    TextView tvFlat1;
    @BindView(R.id.tv_flat2)
    TextView tvFlat2;
    private String maichu;
    int pageSize = 5;
    int currentPage = 1;
    int historyPage = 1;
    int startPage = 1;
    private List<Currency> currencies = new ArrayList<>();
    private List<BaseFragment> menusFragments = new ArrayList<>();
    private List<Currency> currencyListAll = new ArrayList<>();
    private Currency currency;
    private List<Exchange> mOne = new ArrayList<>();
    private List<Exchange> mTow = new ArrayList<>();
    private SellAdapter mOneAdapter; // ???????????????
    private SellAdapter mTwoAdapter; // ???????????????
    private ISixContract.Presenter mPresenter;
    private int oneAccuracy = 2; // ??????
    private int twoAccuracy = 2; // ??????
    private String oldSymbol; // ?????????????????????
    private boolean isFace = false;
    private String buyprogres = "1"; //????????????
    private String sellprogres = "1"; //????????????

    String buttonTextBuy = "";
    String buttonTextSell = "";

    private MainContract.SixPresenter presenter;
    private SixPopModelView sixpopmodelView;
    private SixPopEntrustView sixPopEntrustView;
    private SixPopMultiplesView sixPopMultiplesView;
    private SixPopMultiplesView2 sixPopMultiplesView2;
    private ConstractFragment constractframent;
    private Gson gson = new Gson();
    private SixInfo sixinfo;
    private String targetPattern = "0"; //??????  0  ??????   1
    private int mtabtype = 0;//  ??????  ??????
    private Detail.DataBean data;
    private int isinput = 0;
    private int entrusttype;
    private String multiples;
    private int zhangs = 0;
    private int now = 0; // 0 ???????????????  1  ???????????????
    private SixPopFlat sixPopFlat;


    @Override
    public void getAccuracy(final int one, final int two, SixInfo info) {
        twoAccuracy = one; // ??????
        oneAccuracy = two; // ??????
        if (mOneAdapter == null || mTwoAdapter == null) {
            return;
        }
        mOneAdapter.setText(new SellAdapter.myText() {
            @Override
            public int one() {
                return one;
            }

            @Override
            public int two() {
                return two;
            }
        });
        mOneAdapter.notifyDataSetChanged();
        mTwoAdapter.setText(new SellAdapter.myText() {
            @Override
            public int one() {
                return one;
            }

            @Override
            public int two() {
                return two;
            }
        });
        mTwoAdapter.notifyDataSetChanged();

        if (info != null) {
            sixinfo = info;

            //???  ????????????usdt
            mOneYuE.setText((int) sixinfo.getShareNumber() + " USDT");
            mTwoYuE.setText((int) sixinfo.getShareNumber() + " USDT");

            //????????????????????????
            if (MyApplication.getApp().isLogin()) {
                System.out.println(sixinfo.getId() + "");
                System.out.println(SharedPreferenceInstance.getInstance().getTOKEN());
                mPresenter.getDetail(sixinfo.getId() + "", SharedPreferenceInstance.getInstance().getTOKEN());
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_six;
    }


    @Override
    protected void initViews(Bundle savedInstanceState) {
        tvCurrentTrust.setSelected(true);
        if (mPresenter == null) {
            mPresenter = new SixImpl(this);
        }
        if (constractframent == null) {
            int type = MarketBaseFragment.MarketOperateCallback.TYPE_SWITCH_SYMBOL;
            menusFragments.add(constractframent = ConstractFragment.getInstance(type));
        }
        // ?????????????????????
        ibOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).show_constract();
                ((MainActivity) getActivity()).getDlRoot().openDrawer(Gravity.LEFT);
            }
        });
        for (int i = 0; i < 5; i++) {
            mOne.add(new Exchange(5 - i, "--", "--"));
            mTow.add(new Exchange(i, "--", "--"));
        }
        mToAllLayout.setOnClickListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        mOneAdd.setOnClickListener(this);
        mOneSub.setOnClickListener(this);
        mTwoAdd.setOnClickListener(this);
        mTwoSub.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
        btnSale.setOnClickListener(this);
        ibMessage.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        llCurrentTrust.setOnClickListener(this);
        llHistoryTrust.setOnClickListener(this);
        rlModelSpinner.setOnClickListener(this);
        rlEntrustSpinner.setOnClickListener(this);
        rlMultiplesSpinner.setOnClickListener(this);
        tvFlat1.setOnClickListener(this);
        tvFlat2.setOnClickListener(this);
        tvTitleOption.setOnClickListener(this);
        // ?????????????????????
        mOnePriceEdit.addTextChangedListener(new IMyTextChange() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (currency == null) return;
                try {
                    mOneTextPrice = Double.valueOf(mOnePriceEdit.getText().toString());
                } catch (Exception e) {
                    mOneTextPrice = 0;
                }
                String temp = editable.toString();
                int posDot = temp.indexOf(".");
                if (posDot <= 0) return;
                if (temp.length() - (posDot + 1) > oneAccuracy) {
                    editable.delete(posDot + 1 + oneAccuracy, posDot + 2 + oneAccuracy);
                }
            }
        });

        // ?????????????????????
        mTwoPriceEdit.addTextChangedListener(new IMyTextChange() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (currency == null) return;
                try {
                    mTwoTextPrice = Double.valueOf(mTwoPriceEdit.getText().toString());

                } catch (Exception e) {
                    mTwoTextPrice = 0;
                }
                if (type.equals("LIMIT_PRICE")) {
                    if ("CNY".equals(currency.getSymbol().substring(currency.getSymbol().indexOf("/") + 1, currency.getSymbol().length()))) {
                        mTwoMyText = mTwoText * mTwoTextPrice;
                    } else {
                        mTwoMyText = mTwoText * mTwoTextPrice * MainActivity.rate;
                    }
                    if (!TextUtils.isEmpty(mTwoTcpEdit.getText())) {
                        mTwoDeal.setText(String.valueOf(WonderfulMathUtils.getRundNumber(mul(mTwoText * mTwoTextPrice, 1), 5, null) + " " +
                                currency.getSymbol().substring(currency.getSymbol().indexOf("/") + 1, currency.getSymbol().length())));
                    }
                }
                String temp = editable.toString();
                int posDot = temp.indexOf(".");
                if (posDot <= 0) return;
                if (temp.length() - (posDot + 1) > oneAccuracy) {
                    editable.delete(posDot + 1 + oneAccuracy, posDot + 2 + oneAccuracy);
                }
            }
        });
        // ?????????????????????
        mOneTcpEdit.addTextChangedListener(new IMyTextChange() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (currency == null) return;
            }
        });
        mOneTcpEdit.setOnFocusChangeListener(new View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // ???????????????????????????????????????
                    if (mOneTcpEdit.getText().toString().contains("%")) {
                        isinput = 1;
                        mOneTcpEdit.setText("");
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
                    mOneTcpEdit.setText(progress + "%");
                    mOneTcpEdit.clearFocus();
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
        // ?????????????????????
        mTwoTcpEdit.addTextChangedListener(new IMyTextChange() {
            @Override
            public void afterTextChanged(Editable editable) {
                super.afterTextChanged(editable);
                if (currency == null) return;
            }
        });
        mTwoTcpEdit.setOnFocusChangeListener(new View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // ???????????????????????????????????????
                    if (mTwoTcpEdit.getText().toString().contains("%")) {
                        isinput = 1;
                        mTwoTcpEdit.setText("");
                        mTwoSeekBar.setProgress(0);
                    }
                } else {
                    // ???????????????????????????????????????
//                    Toast.makeText(getActivity(), "shiqu", Toast.LENGTH_SHORT).show();
                    isinput = 0;
                }
            }
        });
        mTwoSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListenerAdapter() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                if (fromUser) {  //??????????????????progress
                    mTwoTcpEdit.setText(progress + "%");
                    mTwoTcpEdit.clearFocus();
                }
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
            }
        });
        mTwoSeekBar.setCustomSectionTextArray(new BubbleSeekBar.CustomSectionTextArray() {
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
        mPanJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check == 0) {
                    if (mtabtype == 0) {
                        mOnePriceEdit.setText(mPanJia.getText());
                    } else {
                        mTwoPriceEdit.setText(mPanJia.getText());
                    }
                } else {
                    if (mtabtype == 0) {
                        mTwoPriceEdit.setText(mPanJia.getText());
                    } else {
                        mOnePriceEdit.setText(mPanJia.getText());
                    }
                }
            }
        });

        ivCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.isAgain = true;
                if (isFace) { // ???????????? ?????????
                    delete(SharedPreferenceInstance.getInstance().getTOKEN(), currency.getSymbol());
                } else {
                    if (MyApplication.getApp().isConnect()) {
                        getCollect(SharedPreferenceInstance.getInstance().getTOKEN(), currency.getSymbol());
                    } else {

                    }

                }
            }
        });
        List<String> tabs = Arrays.asList(this.tabs);
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {  //??????
                    mtabtype = 0;
                    mTabOne.setText(R.string.text_open_many);
                    mTabTwo.setText(R.string.text_open_null);
                    btnBuy.setText(R.string.buyOpenmore);
                    btnSale.setText(R.string.sellOpennull);
                    tvZhangColor.setText(R.string.Openmore);
                    tvZhangColor2.setText(R.string.Opennull);
                    mOnetriggerPrice.setText("");
                    mTwotriggerPrice2.setText("");
                    if (check == 0) {
                        mOneLayout.setVisibility(View.VISIBLE);
                        mTwoLayout.setVisibility(View.GONE);
                        mTabOne.setTextColor(getActivity().getResources().getColor(R.color.white));
                        mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                    } else {
                        mOneLayout.setVisibility(View.GONE);
                        mTwoLayout.setVisibility(View.VISIBLE);
                        mTabOne.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                        mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.white));
                    }

                    mTabOne.setBackgroundResource(R.drawable.selector_left_buy_background);
                    mTabTwo.setBackgroundResource(R.drawable.selector_right_buy_background);
                    if (MyApplication.getApp().isLogin()) {
                        Zhang.setText(avaOpenBuy() + "" + getActivity().getResources().getText(R.string.zhang));
                        Zhang2.setText(avaOpenSell() + "" + getActivity().getResources().getText(R.string.zhang));
                        if (check == 0) {
                            zhangs = avaOpenBuy();
                        } else {
                            zhangs = avaOpenSell();
                        }
                    } else {
                        Zhang.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        Zhang2.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = 0;
                    }
                    Clear();
                } else if (tab.getPosition() == 1) {  //??????
                    mtabtype = 1;
                    mTabOne.setText(R.string.text_flatmore);
                    mTabTwo.setText(R.string.text_flatnull);
                    btnBuy.setText(R.string.buyflatnull);
                    btnSale.setText(R.string.sellflatmore);
                    tvZhangColor.setText(R.string.flatnull);
                    tvZhangColor2.setText(R.string.flatmore);
                    mOnetriggerPrice.setText("");
                    mTwotriggerPrice2.setText("");
                    if (check == 0) {
                        mTabOne.setTextColor(getActivity().getResources().getColor(R.color.white));
                        mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                        mOneLayout.setVisibility(View.GONE);
                        mTwoLayout.setVisibility(View.VISIBLE);
                    } else {
                        mTabOne.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                        mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.white));
                        mOneLayout.setVisibility(View.VISIBLE);
                        mTwoLayout.setVisibility(View.GONE);
                    }
                    mTabOne.setBackgroundResource(R.drawable.selector_left_sell_background);
                    mTabTwo.setBackgroundResource(R.drawable.selector_right_sell_background);
                    if (MyApplication.getApp().isLogin()) {
                        if (data != null) {
                            Zhang2.setText((int) data.getUsdtBuyPosition() + " " + getActivity().getResources().getText(R.string.zhang));
                            Zhang.setText((int) data.getUsdtSellPosition() + " " + getActivity().getResources().getText(R.string.zhang));
                            if (check == 0) {
                                zhangs = (int) data.getUsdtBuyPosition();
                            } else {
                                zhangs = (int) data.getUsdtSellPosition();
                            }
                        }
                    } else {
                        Zhang2.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        Zhang.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = 0;
                    }
                    Clear();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        mTabOne.setSelected(true);

        initRecyclerView();

        initPlate();

    }

    private void refresh() {
        if (MyApplication.getApp().isLogin()) {
            if (sixinfo != null) {
                if (now == 1) {
                    mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), sixinfo.getId(), startPage, pageSize);
                    // pageNo++;
                }
            }
            refreshLayout.setEnabled(true);
            refreshLayout.setRefreshing(false);
        } else {
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_xian_login) + "");
            refreshLayout.setEnabled(true);
            refreshLayout.setRefreshing(false);
        }
    }

    private List<CurrentEntrust.ContentBean> mcurrenentrust = new ArrayList<>();
    CurrentEntrustAdapter currentEntrustAdapter = new CurrentEntrustAdapter(mcurrenentrust);

    private void initRecyclerView() {
        msixRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        msixRecycler.setAdapter(currentEntrustAdapter);
        msixRecycler.setNestedScrollingEnabled(false);
        currentEntrustAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showBottomFragment((CurrentEntrust.ContentBean) adapter.getData().get(position));
            }
        });

    }

    private boolean addFace(String symbol) {
        for (Favorite favorite : MainActivity.mFavorte) {
            if (symbol.equals(favorite.getSymbol())) {
                return true;
            }
        }
        return false;
    }

    /**
     * ????????????
     *
     * @param token
     * @param symbol
     */
    private void delete(String token, String symbol) {
        if (!MyApplication.getApp().isLogin()) {
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_xian_login) + "");
            return;
        }
        showDialog();
        WonderfulOkhttpUtils.post().url(UrlFactory.getDeleteUrl()).addHeader("x-auth-token", token)
                .addParams("symbol", symbol).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                super.onError(request, e);
                hideDialog();
                WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_cancel_fail) + "");
            }

            @Override
            public void onResponse(String response) {
                hideDialog();
                try {
                    JSONObject object = new JSONObject(response);
                    if (object.optInt("code") == 0) {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_cancel_success) + "");
                        isFace = false;
                        ivCollect.setSelected(isFace);
                        ((MainActivity) getmActivity()).Find();
                    } else {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_cancel_fail) + "");
                    }
                } catch (JSONException e) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_cancel_fail) + "");
                }
            }
        });
    }

    /**
     * ????????????
     *
     * @param token
     * @param symbol
     */
    private void getCollect(String token, String symbol) {
        if (!MyApplication.getApp().isLogin()) {
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_xian_login) + "");
            return;
        }
        showDialog();
        WonderfulOkhttpUtils.post().url(UrlFactory.getAddUrl()).addHeader("x-auth-token", token)
                .addParams("symbol", symbol).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                super.onError(request, e);
                hideDialog();
                WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_add_fail) + "");
            }

            @Override
            public void onResponse(String response) {
                hideDialog();
                try {
                    JSONObject object = new JSONObject(response);
                    WonderfulLogUtils.logi("jiejie", "  getCollect  " + response);
                    if (object.optInt("code") == 0) {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_add_success) + "");
                        isFace = true;
                        ivCollect.setSelected(isFace);
                        ((MainActivity) getmActivity()).Find();
                    } else {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_add_fail) + "");
                    }
                } catch (JSONException e) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_add_fail) + "");
                }
            }
        });
    }


    private void setPriceNull() {
        mOnePriceEdit.setText(null);
        mTwoPriceEdit.setText(null);
        mOneTcpEdit.setText(null);
        mTwoTcpEdit.setText(null);
        mOnetriggerPrice.setText(null);
        mTwotriggerPrice2.setText(null);
        this.mOne.clear();
        this.mTow.clear();
        for (int i = 0; i < 5; i++) {
            mOne.add(new Exchange(5 - i, "--", "--"));
            mTow.add(new Exchange(i, "--", "--"));
        }
        mOneAdapter.setList(mOne);
        mOneAdapter.notifyDataSetChanged();

        mTwoAdapter.setList(mTow);
        mTwoAdapter.notifyDataSetChanged();
    }

    double mTwoText, mOneTextPrice, mTwoTextPrice, mTwoMyText;

    @Override
    protected void obtainData() {
        mOneRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTwoRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mOneAdapter = new SellAdapter(mOne, 0);
        mTwoAdapter = new SellAdapter(mTow, 1);
        mOneRecycler.setAdapter(mOneAdapter);
        mTwoRecycler.setAdapter(mTwoAdapter);
        mOneAdapter.setOnItemClickListener(listenerOne);
        mTwoAdapter.setOnItemClickListener(listenerTwo);
    }


    // ?????????Item???????????????
    BaseQuickAdapter.OnItemClickListener listenerOne = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Exchange e = (Exchange) adapter.getData().get(position);
            if (type.equals("LIMIT_PRICE") || type.equals("PLAN_PRICE")) {
                if (!"--".equals(e.getPrice())) {
                    if (check == 0) {
                        if (mtabtype == 0) {
                            mOnePriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        } else {
                            mTwoPriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        }
                    } else {
                        if (mtabtype == 0) {
                            mTwoPriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        } else {
                            mOnePriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        }
                    }
                }
            }
        }
    };
    // ?????????Item???????????????
    BaseQuickAdapter.OnItemClickListener listenerTwo = new BaseQuickAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Exchange e = (Exchange) adapter.getData().get(position);
            if (type.equals("LIMIT_PRICE") || type.equals("PLAN_PRICE")) {
                if (!"--".equals(e.getPrice())) {
                    if (check == 0) {
                        if (mtabtype == 0) {
                            mOnePriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        } else {
                            mTwoPriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        }
                    } else {
                        if (mtabtype == 0) {
                            mTwoPriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        } else {
                            mOnePriceEdit.setText(String.valueOf(WonderfulMathUtils.getRundNumber(Double.valueOf(e.getPrice()), oneAccuracy, null)));
                        }
                    }
                }
            }
        }
    };

    private void showBottomFragment(CurrentEntrust.ContentBean contentBean) {
        EntrustConstractDialogFragment entrustConstractDialogFragment =
                EntrustConstractDialogFragment.getInstance(contentBean);
        entrustConstractDialogFragment.show(getActivity().getSupportFragmentManager(), "bottom");
        entrustConstractDialogFragment.setCallback(new EntrustConstractDialogFragment.OperateCallback() {
            @Override
            public void cancleOrder(String entrustId) {
                // ??????
                if (mPresenter != null) {
                    displayLoadingPopup();
                    mPresenter.getCancelEntrust(SharedPreferenceInstance.getInstance().getTOKEN(), entrustId);
                }
            }
        });
    }

    @Override
    protected void fillWidget() {

    }

    @Override
    protected void loadData() {
        if (MyApplication.getApp().isLogin() && TextUtils.isEmpty(SharedPreferenceInstance.getInstance().getTOKEN())) {
            MyApplication.getApp().loginAgain(this);
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_login_disabled) + "");
            return;
        }
        // ?????????????????????
        if (this.currency != null && !TextUtils.isEmpty(SharedPreferenceInstance.getInstance().getTOKEN())) {
            mPresenter.getExchange(currency.getSymbol());
            Log.i("six", "????????????");
        }
        if (!MyApplication.getApp().isLogin()) {
            btnLogin.setVisibility(View.VISIBLE);
            //vpTrust.setVisibility(View.GONE);
            msixRecycler.setVisibility(View.GONE);
            mTvsix.setVisibility(View.GONE);
            llDeal.setVisibility(View.GONE);
            SharedPreferenceInstance.getInstance().saveaToken("");
            SharedPreferenceInstance.getInstance().saveTOKEN("");
        } else {

            if (MyApplication.getApp().isLogin() && this.currency != null) {
                currentPage = startPage;
                historyPage = startPage;
                setCurrentSelected();
            } else {
                SharedPreferenceInstance.getInstance().saveaToken("");
                SharedPreferenceInstance.getInstance().saveTOKEN("");
            }
        }
        if (currency != null) {
            isFace = addFace(this.currency.getSymbol());
            ivCollect.setSelected(isFace);
            String format = new DecimalFormat("#0.00000000").format(currency.getClose());
            BigDecimal bg = new BigDecimal(format);
            String v = bg.setScale(8, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
            mOnePriceEdit.setText(v);
            mTwoPriceEdit.setText(v);
            tvTitle.setText(this.currency.getSymbol() + " " + getActivity().getResources().getText(R.string.constract));
            text_title_amount.setText(getActivity().getResources().getText(R.string.number) + "\n" + "(" + this.currency.getSymbol().substring(0, currency.getSymbol().indexOf("/")) + ")");
            text_title_price.setText(getActivity().getResources().getText(R.string.price) + "\n" + "(" + this.currency.getSymbol().substring(currency.getSymbol().indexOf("/") + 1) + ")");
            buttonTextBuy = String.valueOf(getActivity().getResources().getText(R.string.text_buy) + this.currency.getSymbol().substring(0, currency.getSymbol().indexOf("/")));
            buttonTextSell = String.valueOf(getActivity().getResources().getText(R.string.text_sale) + this.currency.getSymbol().substring(0, currency.getSymbol().indexOf("/")));
//            btnBuy.setText(buttonTextBuy);
//            btnSale.setText(buttonTextSell);
        }
        if (currency != null) {
            String format = new DecimalFormat("#0.00000000").format(currency.getClose());

            BigDecimal bg = new BigDecimal(format);
            String v = bg.setScale(8, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();

            mPanJia.setText(String.valueOf(v));
        }
        if (currency != null) {
            mPanJia.setTextColor(currency.getChg() >= 0 ? ContextCompat.getColor(MyApplication.getApp(), R.color.typeGreen) :
                    ContextCompat.getColor(MyApplication.getApp(), R.color.typeRed));
        }
        if (currency != null) {
            if ("CNY".equals(currency.getSymbol().substring(currency.getSymbol().indexOf("/") + 1, currency.getSymbol().length()))) {
                mPanMoney.setText(String.valueOf("??? " + WonderfulMathUtils.getRundNumber(currency.getClose() * 1 * currency.getBaseUsdRate(),
                        2, null) + " CNY"));
            } else {
                mPanMoney.setText(String.valueOf("??? " + WonderfulMathUtils.getRundNumber(currency.getClose() * MainActivity.rate,
                        2, null) + " CNY"));
            }
        }
    }


    private double mul(double num1, double num2) {
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        return b1.multiply(b2).doubleValue();
    }

    private JSONObject buildGetBodyJson(String symbol) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("symbol", symbol);
            return obj;
        } catch (Exception ex) {
            return null;
        }
    }

    private JSONObject buildGetBodyJson(String symbol, int id) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("symbol", symbol);
            obj.put("uid", id);
            return obj;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * ??????????????????????????????????????????
     */
    private void startTCP(String symbol, int id) {
        if (id == 0) {
            // ?????????iD
            EventBus.getDefault().post(new SocketMessage(1, ISocket.CMD.SUBSCRIBE_EXCHANGE_TRADE_CONTRACT,
                    buildGetBodyJson(symbol).toString().getBytes()));
        } else {
            // ??????ID
            EventBus.getDefault().post(new SocketMessage(1, ISocket.CMD.SUBSCRIBE_EXCHANGE_TRADE_CONTRACT,
                    buildGetBodyJson(symbol, id).toString().getBytes()));
        }
        oldSymbol = symbol;
    }

    /**
     * ????????????????????????????????????
     */
    private void stop(String symbol, int id) {
        if (id == 0) {
            EventBus.getDefault().post(new SocketMessage(1, ISocket.CMD.UNSUBSCRIBE_EXCHANGE_TRADE_CONTRACT,
                    buildGetBodyJson(symbol).toString().getBytes()));
        } else {
            EventBus.getDefault().post(new SocketMessage(1, ISocket.CMD.UNSUBSCRIBE_EXCHANGE_TRADE_CONTRACT,
                    buildGetBodyJson(symbol, id).toString().getBytes()));
        }

    }

    @Override
    protected String getmTag() {
        return TAG;
    }


    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        if (!isSetTitle) {
            ImmersionBar.setTitleBar(getActivity(), llTitle);
            isSetTitle = true;
        }
    }

    /**
     * ?????????????????????(???????????????)????????????????????????????????????
     */
    public void resetSymbol(Currency currency) {
        this.currency = currency;
        Log.i("six", "???????????????resetSymbol" + this.currency.getSymbol());
        if (this.currency != null) {
            setCurrentSelected();
            mOneSeekBar.setProgress(0f);
            mTwoSeekBar.setProgress(0f);
            mTwoDeal.setText("--");


            setPriceNull();
            String format2 = new DecimalFormat("#0.00000000").format(currency.getClose());
            BigDecimal bg2 = new BigDecimal(format2);
            String v2 = bg2.setScale(8, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
            mOnePriceEdit.setText(v2);
            mTwoPriceEdit.setText(v2);
            // ??????????????????
            mPresenter.getExchange(this.currency.getSymbol());
            // ???????????????????????????
            mPresenter.getSymbolInfo(this.currency.getSymbol());
            // ?????????????????????
            if (!WonderfulStringUtils.isEmpty(SharedPreferenceInstance.getInstance().getTOKEN())) {
                // ???????????????????????????
                currentPage = startPage;
                historyPage = startPage;
            }
            // ????????????
            isFace = addFace(this.currency.getSymbol());
            ivCollect.setSelected(isFace);
            tvTitle.setText(this.currency.getSymbol() + " " + getActivity().getResources().getText(R.string.constract));
            text_title_amount.setText(getActivity().getResources().getText(R.string.number) + "\n" + "(" + this.currency.getSymbol().substring(0, currency.getSymbol().indexOf("/")) + ")");
            text_title_price.setText(getActivity().getResources().getText(R.string.price) + "\n" + "(" + this.currency.getSymbol().substring(currency.getSymbol().indexOf("/") + 1) + ")");
            buttonTextBuy = String.valueOf(getActivity().getResources().getText(R.string.text_buy) + this.currency.getSymbol().substring(0, currency.getSymbol().indexOf("/")));
            buttonTextSell = String.valueOf(getActivity().getResources().getText(R.string.text_sale) + this.currency.getSymbol().substring(0, currency.getSymbol().indexOf("/")));
//            btnBuy.setText(buttonTextBuy);
//            btnSale.setText(buttonTextSell);
            String format = new DecimalFormat("#0.00000000").format(currency.getClose());
            BigDecimal bg = new BigDecimal(format);
            String v = bg.setScale(8, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
            mPanJia.setText(String.valueOf(v));
//            mPanJia.setText(String.valueOf(currency.getClose()));
            mPanJia.setTextColor(currency.getChg() >= 0 ? ContextCompat.getColor(MyApplication.getApp(), R.color.typeGreen) :
                    ContextCompat.getColor(MyApplication.getApp(), R.color.typeRed));
            if ("CNY".equals(currency.getSymbol().substring(currency.getSymbol().indexOf("/") + 1, currency.getSymbol().length()))) {
                mPanMoney.setText(String.valueOf("???" + WonderfulMathUtils.getRundNumber(currency.getClose() * 1 * currency.getBaseUsdRate(),
                        2, null) + "CNY"));
            } else {
                mPanMoney.setText(String.valueOf("???" + WonderfulMathUtils.getRundNumber(currency.getClose() * MainActivity.rate,
                        2, null) + "CNY"));
            }
            // ???????????????????????????????????????????????? ??????????????????????????????????????????
            if (!TextUtils.isEmpty(oldSymbol)) {
                stop(oldSymbol, getmActivity().getId());
            }
            startTCP(currency.getSymbol(), getmActivity().getId());
        }
    }

    // K???????????????
    public void showPageFragment(String symbol, int pageNo) {
        if (this.currencies == null) {
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.find_error) + "");
            return;
        }

        // this.page = pageNo;
        for (Currency currency : currencies) {
            if (symbol.equals(currency.getSymbol())) {
                this.currency = currency;
                break;
            }
        }
        if (this.currency != null) {
            try {
                now = 0;
                tvTitle.setText(symbol + " " + getActivity().getResources().getText(R.string.constract));
                text_title_amount.setText(getActivity().getResources().getText(R.string.number) + "\n" + "(" + symbol.substring(0, symbol.indexOf("/")) + ")");
                text_title_price.setText(getActivity().getResources().getText(R.string.price) + "\n" + "(" + symbol.substring(symbol.indexOf("/") + 1) + ")");

                mOneTcpEdit.setText(null);
                mTwoTcpEdit.setText(null);
                mOneSeekBar.setProgress(0f);

                mTwoSeekBar.setProgress(0f);

                //btnBuy.setText(String.valueOf(getActivity().getResources().getText(R.string.text_buy) + symbol.substring(0, currency.getSymbol().indexOf("/"))));
                //btnSale.setText(String.valueOf(getActivity().getResources().getText(R.string.text_sale) + symbol.substring(0, currency.getSymbol().indexOf("/"))));
                // ????????????
                mPresenter.getExchange(this.currency.getSymbol());
                // ?????????????????????
                mPresenter.getSymbolInfo(this.currency.getSymbol());

                // ???????????????????????????????????????????????? ??????????????????????????????????????????
                if (!TextUtils.isEmpty(oldSymbol)) {
                    stop(oldSymbol, getmActivity().getId());
                }
                startTCP(this.currency.getSymbol(), getmActivity().getId());
                if (pageNo == 0) { // ??????
                    mRadioGroup.check(R.id.mTabOne);
                } else { //??????
                    mRadioGroup.check(R.id.mTabTwo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        Log.i("six", "???????????????showPageFragement:"+this.currency.getSymbol());
//        vpExchange.setCurrentItem(pageNo);
    }

    public void setCurrencyInfo(List<Currency> currencies) {

        this.currencies.clear();
        this.currencies.addAll(currencies);
        this.currency = currencies.get(0);

    }

    /**
     * ??????????????????
     */
    public void initPlate() {
        if (this.currency != null) {
            // ????????????
            mPresenter.getExchange(this.currency.getSymbol());
            // ?????????????????????
            mPresenter.getSymbolInfo(this.currency.getSymbol());
            if (!TextUtils.isEmpty(oldSymbol)) stop(oldSymbol, getmActivity().getId());
            startTCP(currency.getSymbol(), getmActivity().getId());
        }
    }

    public void tcpNotify() {
        if (currency != null) {
            String format = new DecimalFormat("#0.00000000").format(currency.getClose());
            BigDecimal bg = new BigDecimal(format);
            String v = bg.setScale(8, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
            if (mPanJia != null) {
                mPanJia.setText(String.valueOf(v));
//            mPanJia.setText(String.valueOf(currency.getClose()));
                mPanJia.setTextColor(currency.getChg() >= 0 ? ContextCompat.getColor(MyApplication.getApp(), R.color.typeGreen) :
                        ContextCompat.getColor(MyApplication.getApp(), R.color.typeRed));
            }
            if (mPanMoney != null) {
                if ("CNY".equals(currency.getSymbol().substring(currency.getSymbol().indexOf("/") + 1, currency.getSymbol().length()))) {
                    mPanMoney.setText(String.valueOf("??? " + WonderfulMathUtils.getRundNumber(currency.getClose() * 1 * currency.getBaseUsdRate(),
                            2, null) + " CNY"));
                } else {
                    mPanMoney.setText(String.valueOf("??? " + WonderfulMathUtils.getRundNumber(currency.getClose() * MainActivity.rate,
                            2, null) + " CNY"));
                }
            }
            if (now == 0) { //0 ????????????  1????????????
                refreshgranary(currency.getClose());
            }

        }
    }

    //??????????????????
    private void refreshgranary(Double close) {
        if (!MyApplication.getApp().isLogin()) {
            return;
        }
        if (data == null) return;
        if (data.getUsdtBuyPosition() > 0 || data.getUsdtFrozenBuyPosition() > 0) {
            if (now == 0) {
                llDeal.setVisibility(View.VISIBLE);
                mTvsix.setVisibility(View.GONE);
                //???????????????????????????????????????????????????
                llBuy.setVisibility(View.VISIBLE);
                llSell.setVisibility(View.VISIBLE);
            }
        } else if (data.getUsdtSellPosition() > 0 || data.getUsdtFrozenSellPosition() > 0) {
            if (now == 0) {
                llDeal.setVisibility(View.VISIBLE);
                mTvsix.setVisibility(View.GONE);
                //???????????????????????????????????????????????????
                llBuy.setVisibility(View.VISIBLE);
                llSell.setVisibility(View.VISIBLE);
            }
        } else {
            llDeal.setVisibility(View.GONE);
            mTvsix.setVisibility(View.VISIBLE);
            return;
        }
        //????????????
        // ??????????????????
        if (data.getUsdtBuyPosition() > 0 || data.getUsdtFrozenBuyPosition() > 0) {
            double buyPL = (close / data.getUsdtBuyPrice() - 1) * (data.getUsdtBuyPosition() + data.getUsdtFrozenBuyPosition()) * data.getUsdtShareNumber();
            //??????
            if (buyPL > 0) {
                buyEarnings.setText("+" + getpoint("#.0000", buyPL, 4) + " USDT");
                buyEarnings.setTextColor(getResources().getColor(R.color.typeGreen));
            } else {
                buyEarnings.setText(getpoint("#.0000", buyPL, 4) + " USDT");
                buyEarnings.setTextColor(getResources().getColor(R.color.typeRed));
            }
            //?????????
            double rate = (buyPL / data.getUsdtBuyPrincipalAmount()) * 100;
            if (rate > 0) {
                buyRate.setText("+" + getpoint("#.00", rate, 2) + " %");
                buyRate.setTextColor(getResources().getColor(R.color.typeGreen));
            } else {
                buyRate.setText(getpoint("#.00", rate, 2) + " %");
                buyRate.setTextColor(getResources().getColor(R.color.typeRed));
            }
            //????????????
            buyOne.setText(getActivity().getResources().getText(R.string.more_head) + " " + (int) data.getUsdtBuyLeverage() + "x");
            //?????????
            buyTwo.setText((int) (data.getUsdtBuyPosition() + data.getUsdtFrozenBuyPosition()) + "" + getActivity().getResources().getText(R.string.zhang));
            //?????????
            buyThree.setText((int) data.getUsdtBuyPosition() + "" + getActivity().getResources().getText(R.string.zhang));
            //????????????
            buyFour.setText(getpoint("#.0000", data.getUsdtBuyPrice(), 4) + "USDT");
            //?????????
            buyFive.setText(getpoint("#.00", data.getUsdtBuyPrincipalAmount(), 2) + "USDT");
            //????????????
            buySix.setText(getpoint("#.00", ((buyPL + data.getUsdtBuyPrincipalAmount()) / data.getUsdtBuyPrincipalAmount() / data.getUsdtBuyLeverage()) * 100, 2) + " %");
        } else {
            llBuy.setVisibility(View.GONE);
        }
        // ??????????????????
        if (data.getUsdtSellPosition() > 0 || data.getUsdtFrozenSellPosition() > 0) {
            double sellPL = (1 - close / data.getUsdtSellPrice()) * (data.getUsdtSellPosition() + data.getUsdtFrozenSellPosition()) * data.getUsdtShareNumber();
            //??????
            if (sellPL > 0) {
                sellEarnings.setText("+" + getpoint("#.0000", sellPL, 4) + " USDT");
                sellEarnings.setTextColor(getResources().getColor(R.color.typeGreen));
            } else {
                sellEarnings.setText(getpoint("#.0000", sellPL, 4) + " USDT");
                sellEarnings.setTextColor(getResources().getColor(R.color.typeRed));
            }
            //?????????
            double rate = (sellPL / data.getUsdtSellPrincipalAmount()) * 100;
            if (rate > 0) {
                sellRate.setText("+" + getpoint("#.00", rate, 2) + " %");
                sellRate.setTextColor(getResources().getColor(R.color.typeGreen));
            } else {
                sellRate.setText(getpoint("#.00", rate, 2) + " %");
                sellRate.setTextColor(getResources().getColor(R.color.typeRed));
            }
            //????????????
            sellOne.setText(getActivity().getResources().getText(R.string.null_head) + " " + (int) data.getUsdtSellLeverage() + "x");
            //?????????
            sellTwo.setText((int) (data.getUsdtSellPosition() + data.getUsdtFrozenSellPosition()) + "" + getActivity().getResources().getText(R.string.zhang));
            //?????????
            sellThree.setText((int) data.getUsdtSellPosition() + "" + getActivity().getResources().getText(R.string.zhang));
            //????????????
            sellFour.setText(getpoint("#.0000", data.getUsdtSellPrice(), 4) + "USDT");
            //?????????
            sellFive.setText(getpoint("#.00", data.getUsdtSellPrincipalAmount(), 2) + "USDT");
            //????????????
            sellSix.setText(getpoint("#.00", ((sellPL + data.getUsdtSellPrincipalAmount()) / data.getUsdtSellPrincipalAmount() / data.getUsdtSellLeverage()) * 100, 2) + " %");
        } else {
            llSell.setVisibility(View.GONE);
        }
    }

    private int check = 0;

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.mTabOne: // ?????????
                check = 0;
                if (mtabtype == 0) {
                    mOneLayout.setVisibility(View.VISIBLE);
                    mTwoLayout.setVisibility(View.GONE);
                    mTabOne.setTextColor(getActivity().getResources().getColor(R.color.white));
                    mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                    mTabOne.setBackgroundResource(R.drawable.selector_left_buy_background);
                    mTabTwo.setBackgroundResource(R.drawable.selector_right_buy_background);
                    tvZhangColor.setTextColor(getResources().getColor(R.color.typeGreen));
                    tvZhangColor.setText(R.string.Openmore);
                    if (MyApplication.getApp().isLogin()) {
                        Zhang.setText(avaOpenBuy() + " " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = avaOpenBuy();
                    } else {
                        Zhang2.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        Zhang.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = 0;
                    }
                } else if (mtabtype == 1) {
                    mOneLayout.setVisibility(View.GONE);
                    mTwoLayout.setVisibility(View.VISIBLE);
                    mTabOne.setTextColor(getActivity().getResources().getColor(R.color.white));
                    mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                    mTabOne.setBackgroundResource(R.drawable.selector_left_sell_background);
                    mTabTwo.setBackgroundResource(R.drawable.selector_right_sell_background);
                    tvZhangColor2.setTextColor(getResources().getColor(R.color.typeRed));
                    tvZhangColor2.setText(R.string.flatmore);
                    if (MyApplication.getApp().isLogin()) {
                        if (data != null) {
                            Zhang2.setText((int) data.getUsdtBuyPosition() + " " + getActivity().getResources().getText(R.string.zhang));
                            zhangs = (int) data.getUsdtBuyPosition();
                        }

                    } else {
                        Zhang2.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        Zhang.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = 0;
                    }
                }
                mTabOne.setSelected(true);
                mTabTwo.setSelected(false);
                tvMultiples.setText(buyprogres + "x");
                mOnetriggerPrice.setText("");
                mTwotriggerPrice2.setText("");
                Clear();
                break;
            case R.id.mTabTwo: // ?????????
                check = 1;
                if (mtabtype == 0) {
                    mOneLayout.setVisibility(View.GONE);
                    mTwoLayout.setVisibility(View.VISIBLE);
                    mTabOne.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                    mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.white));
                    mTabOne.setBackgroundResource(R.drawable.selector_left_buy_background);
                    mTabTwo.setBackgroundResource(R.drawable.selector_right_buy_background);
                    tvZhangColor2.setTextColor(getResources().getColor(R.color.typeRed));
                    tvZhangColor2.setText(R.string.Opennull);

                    if (MyApplication.getApp().isLogin()) {
                        Zhang2.setText(avaOpenSell() + " " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = avaOpenSell();
                    } else {
                        Zhang2.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        Zhang.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = 0;
                    }
                } else if (mtabtype == 1) {
                    mOneLayout.setVisibility(View.VISIBLE);
                    mTwoLayout.setVisibility(View.GONE);
                    mTabOne.setTextColor(getActivity().getResources().getColor(R.color.typeDefault));
                    mTabTwo.setTextColor(getActivity().getResources().getColor(R.color.white));
                    mTabOne.setBackgroundResource(R.drawable.selector_left_sell_background);
                    mTabTwo.setBackgroundResource(R.drawable.selector_right_sell_background);
                    tvZhangColor.setTextColor(getResources().getColor(R.color.typeGreen));
                    tvZhangColor.setText(R.string.flatnull);
                    if (MyApplication.getApp().isLogin()) {
                        if (data != null) {
                            Zhang.setText((int) data.getUsdtSellPosition() + " " + getActivity().getResources().getText(R.string.zhang));
                            zhangs = (int) data.getUsdtSellPosition();
                        }
                    } else {
                        Zhang2.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        Zhang.setText("0 " + getActivity().getResources().getText(R.string.zhang));
                        zhangs = 0;
                    }
                }

                mTabOne.setSelected(false);
                mTabTwo.setSelected(true);
                mOnetriggerPrice.setText("");
                mTwotriggerPrice2.setText("");
                tvMultiples.setText(sellprogres + "x");
                Clear();
                break;
            default:
        }
    }

    //?????????:xx ???
    private int avaOpenSell() {
        try {
            if (!MyApplication.getApp().isLogin()) return 0;
            if (data == null) return 0;
            // ???????????????/???
            if (data.getUsdtPattern() == "FIXED") { // ???????????????usdt????????????
                return (int) (data.getUsdtSellLeverage() * data.getUsdtBalance() / data.getUsdtShareNumber());
            } else {
                // ????????????
                int buyPL = 0;
                if (data.getUsdtBuyPrice() > 0) {
                    buyPL = (int) ((currency.getClose() / data.getUsdtBuyPrice() - 1) * (data.getUsdtBuyPosition() + data.getUsdtFrozenBuyPosition()) * data.getUsdtShareNumber());
                }
                int sellPL = 0;
                if (data.getUsdtSellPrice() > 0) {
                    buyPL = (int) ((1 - currency.getClose() / data.getUsdtSellPrice()) * (data.getUsdtSellPosition() + data.getUsdtFrozenSellPosition()) * data.getUsdtShareNumber());
                }
                double lossandp = buyPL + sellPL + data.getUsdtBuyPrincipalAmount() + data.getUsdtSellPrincipalAmount();
                if (lossandp >= 0) {
                    return (int) (data.getUsdtSellLeverage() * data.getUsdtBalance() / data.getUsdtShareNumber());
                } else {
                    return (int) (data.getUsdtSellLeverage() * (data.getUsdtBalance() - lossandp) / data.getUsdtShareNumber());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //?????????:xx ???
    private int avaOpenBuy() {
        try {
            if (!MyApplication.getApp().isLogin()) return 0;
            if (data == null) return 0;
            // ???????????????/???
            if (data.getUsdtPattern().equals("FIXED")) { // ???????????????usdt????????????
                return (int) (data.getUsdtBuyLeverage() * data.getUsdtBalance() / data.getUsdtShareNumber());
            } else {
                // ????????????
                int buyPL = 0;
                if (data.getUsdtBuyPrice() > 0) {
                    buyPL = (int) ((currency.getClose() / data.getUsdtBuyPrice() - 1) * (data.getUsdtBuyPosition() + data.getUsdtFrozenBuyPosition()) * data.getUsdtShareNumber());
                }
                int sellPL = 0;
                if (data.getUsdtSellPrice() > 0) {
                    buyPL = (int) ((1 - currency.getClose() / data.getUsdtSellPrice()) * (data.getUsdtSellPosition() + data.getUsdtFrozenSellPosition()) * data.getUsdtShareNumber());
                }
                double lossandp = buyPL + sellPL + data.getUsdtBuyPrincipalAmount() + data.getUsdtSellPrincipalAmount();
                if (lossandp >= 0) {
                    return (int) (data.getUsdtBuyLeverage() * data.getUsdtBalance() / data.getUsdtShareNumber());
                } else {
                    return (int) (data.getUsdtBuyLeverage() * (data.getUsdtBalance() - lossandp) / data.getUsdtShareNumber());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void errorMes(int e, String msg) {

        //mTvsix.setVisibility(View.INVISIBLE);
        if (e == 4000) {
            MyApplication.getApp().setCurrentUser(null);
            if (!MyApplication.getApp().isLogin()) {
                btnLogin.setVisibility(View.VISIBLE);
                //vpTrust.setVisibility(View.GONE);
                msixRecycler.setVisibility(View.GONE);
                mTvsix.setVisibility(View.GONE);
                llDeal.setVisibility(View.GONE);
                SharedPreferenceInstance.getInstance().saveaToken("");
                SharedPreferenceInstance.getInstance().saveTOKEN("");

            } else {
                if (MyApplication.getApp().isLogin() && this.currency != null) {
                    currentPage = startPage;
                    historyPage = startPage;
                    mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), sixinfo.getId(), startPage, pageSize);
//                mPresenter.getOrderHistory(SharedPreferenceInstance.getInstance().getTOKEN(), startPage, pageSize, this.currency.getSymbol(), "", "", "", "");
                }
            }
        } else {
            WonderfulCodeUtils.checkedErrorCode(getmActivity(), e, msg);
        }
        refreshLayout.setEnabled(true);
        refreshLayout.setRefreshing(false);
        //mTvsix.setVisibility(this.mHistoryData.size() == 0 ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * ??????????????????????????????(????????????????????????)
     */
    @Override
    public void getDataLoad(int code, String message) {
        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.put_list_ok) + "");
        if (code == 0) {
            mOneTcpEdit.setText(null);
            mTwoTcpEdit.setText(null);
            mOneSeekBar.setProgress(0f);

            mTwoSeekBar.setProgress(0f);
            // ??????????????????
            if (MyApplication.getApp().isLogin() && this.currency != null) {
                // ????????????????????????
                currentPage = startPage;
                historyPage = startPage;
                mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), sixinfo.getId(), currentPage, pageSize);
                //????????????????????????????????????
                mPresenter.getDetail(sixinfo.getId() + "", SharedPreferenceInstance.getInstance().getTOKEN());

                // ???????????????????????????  ??????????????????
                mPresenter.getExchange(currency.getSymbol());
            }
        }
        if (sixPopFlat != null){
            if (sixPopFlat.isShowing()){
                sixPopFlat.dismiss();
            }
        }
    }

    private LoadDialog mDialog;

    @Override
    public void showDialog() {
        if (mDialog == null) {
            mDialog = new LoadDialog(getmActivity());
        }
        mDialog.show();
    }

    @Override
    public void hideDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void getCancelFail() {
        hideLoadingPopup();
    }

    @Override
    public void getswitch(switchpattern switchpattern) {
        if (switchpattern.getCode() == 0) {
            mPresenter.getDetail(sixinfo.getId() + "", SharedPreferenceInstance.getInstance().getTOKEN());
            WonderfulToastUtils.showToast("" + switchpattern.getMessage());
        } else {
            WonderfulToastUtils.showToast("" + switchpattern.getMessage());
        }
    }

    @Override
    public void getdetail(Detail detail) {
        if (detail.getCode() == 0) {
            data = detail.getData();
            //??? ??????
            if (detail.getData().getUsdtPattern().equals("FIXED")) {
                targetPattern = "1";
                tvModel.setText(getActivity().getResources().getText(R.string.text_chase_model));
            } else {
                targetPattern = "0";
                tvModel.setText(getActivity().getResources().getText(R.string.text_all_model));
            }

            //???  ??????
            String buy = (int) detail.getData().getUsdtBuyLeverage() + "";
            String sell = (int) detail.getData().getUsdtSellLeverage() + "";
            buyprogres = buy;
            sellprogres = sell;
            String[] split = sixinfo.getLeverage().split(",");
            if (Integer.parseInt(buy) < Integer.parseInt(split[0])) {
                buyprogres = split[0];
            }
            if (Integer.parseInt(sell) < Integer.parseInt(split[0])) {
                sellprogres = split[0];
            }
            if (Integer.parseInt(buy) > Integer.parseInt(split[split.length - 1])) {
                buyprogres = split[split.length - 1];
            }
            if (Integer.parseInt(sell) > Integer.parseInt(split[split.length - 1])) {
                sellprogres = split[split.length - 1];
            }



            mOneDeal.setText(formatYuetwo(BigDecimal.valueOf(detail.getData().getUsdtBalance())) + "");
            mTwoDeal.setText(formatYuetwo(BigDecimal.valueOf(detail.getData().getUsdtBalance())) + "");
            //??????  ??????
            if (mtabtype == 0) {
                if (check == 0) {
                    Zhang.setText(avaOpenBuy() + " " + getActivity().getResources().getText(R.string.zhang));
                    zhangs = avaOpenBuy();
                    tvMultiples.setText(buyprogres + "x");
                } else {
                    Zhang2.setText(avaOpenSell() + " " + getActivity().getResources().getText(R.string.zhang));
                    zhangs = avaOpenSell();
                    tvMultiples.setText(sellprogres + "x");
                }
            } else {
                if (check == 0) {
                    Zhang2.setText((int) data.getUsdtBuyPosition() + " " + getActivity().getResources().getText(R.string.zhang));
                    zhangs = (int) data.getUsdtSellPosition();
                    tvMultiples.setText(sellprogres + "x");
                } else {
                    Zhang.setText((int) data.getUsdtSellPosition() + " " + getActivity().getResources().getText(R.string.zhang));
                    zhangs = (int) data.getUsdtBuyPosition();
                    tvMultiples.setText(buyprogres + "x");
                }
            }
            refreshgranary(currency.getClose());
        } else {
            WonderfulToastUtils.showToast("" + detail.getMessage());
        }

    }

    public String getpoint(String s, double data, int i) {
        String format = new DecimalFormat(s).format(data);
        BigDecimal bg = new BigDecimal(format);
        String string = bg.setScale(i, BigDecimal.ROUND_DOWN).toPlainString();
        return string;
    }

    @Override
    public void GetModifyLeverage(modifyleverage modifyleverage) {
        if (modifyleverage.getCode() == 0) {
            WonderfulToastUtils.showToast(R.string.submit_ok);
            if (sixinfo.getLeverageType() == 1) {
                if (sixPopMultiplesView2.isShowing()) {
                    sixPopMultiplesView2.dismiss();
                }
            } else if (sixinfo.getLeverageType() == 2) {
                if (sixPopMultiplesView.isShowing()) {
                    sixPopMultiplesView.dismiss();
                }
            }
            mPresenter.getDetail(sixinfo.getId() + "", SharedPreferenceInstance.getInstance().getTOKEN());
        } else {
            WonderfulToastUtils.showToast("" + modifyleverage.getMessage());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideDialog();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }


    /**
     * ???????????????
     */
    @Override
    public void getSuccess(List<Exchange> ask, List<Exchange> bid) {
        this.mOne.clear();
        this.mTow.clear();
        for (int i = 0; i < 5; i++) {
            mOne.add(new Exchange(5 - i, "--", "--"));
            mTow.add(new Exchange(i, "--", "--"));
        }
        if (ask.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                mOne.set(4 - i, new Exchange(i + 1, ask.get(i).getPrice(), ask.get(i).getAmount()));
            }
        } else {
            for (int i = 0; i < ask.size(); i++) {
                mOne.set(4 - i, new Exchange(i + 1, ask.get(i).getPrice(), ask.get(i).getAmount()));
            }
        }

        mOneAdapter.setList(mOne);
        mOneAdapter.notifyDataSetChanged();
        if (bid.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                mTow.set(i, new Exchange(i, bid.get(i).getPrice(), bid.get(i).getAmount()));
            }
        } else {
            for (int i = 0; i < bid.size(); i++) {
                mTow.set(i, new Exchange(i, bid.get(i).getPrice(), bid.get(i).getAmount()));
            }
        }
        mTwoAdapter.setList(mTow);
        mTwoAdapter.notifyDataSetChanged();
    }

    static int TYPE_CURRENT = 1;
    static int TYPE_HISTORY = 2;

    /**
     * ????????????
     */
    @Override
    public void getDataLoaded(CurrentEntrust entrusts) {
        btnLogin.setVisibility(View.GONE);
        if (entrusts == null) {
            return;
        }
        setListData(entrusts);
        WonderfulLogUtils.logd("jiejie", "--???????????????--" + entrusts);
//        trustFragments.get(0).setListData(TrustFragment.TRUST_TYPE_CURRENT, entrusts);
    }

    public void setListData(CurrentEntrust list) {
        if (list != null && list.getContent().size() > 0) {
            if (now == 1) {
                msixRecycler.setVisibility(View.VISIBLE);
                msixRecycler.setAdapter(currentEntrustAdapter);
            } else {
                msixRecycler.setVisibility(View.GONE);
            }

            mTvsix.setVisibility(View.GONE);
            mcurrenentrust.clear();
            mcurrenentrust.addAll(list.getContent());

            currentEntrustAdapter.notifyDataSetChanged();
        } else {
            msixRecycler.setVisibility(View.GONE);
            mTvsix.setVisibility(View.VISIBLE);
        }
        refreshLayout.setEnabled(true);
        refreshLayout.setRefreshing(false);
    }

    /**
     * ????????????????????????
     */
    @Override
    public void getCancelSuccess(String success) {
        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.remove_entrust) + "");
        hideLoadingPopup();
        if (MyApplication.getApp().isLogin() && this.currency != null) {
            // ????????????????????????
            currentPage = startPage;
            historyPage = startPage;
            mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), sixinfo.getId(), currentPage, pageSize);
//            } else {
//                mPresenter.getOrderHistory(SharedPreferenceInstance.getInstance().getTOKEN(), historyPage, pageSize, this.currency.getSymbol(), "", "", "", "");
//            }
            // mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), currentPage, pageSize, this.currency.getSymbol(), "", "", "", "");
            // mPresenter.getOrderHistory(SharedPreferenceInstance.getInstance().getTOKEN(), historyPage, pageSize, this.currency.getSymbol(), "", "", "", "");
            // ???????????????????????????  ??????????????????
            // mPresenter.getExchange(currency.getSymbol());
        }
    }


    // ????????????????????????????????????
    private String formatYue(BigDecimal bYuE) {
        String tem = bYuE.toPlainString();
        if (tem.length() > 8) {
            if (bYuE.compareTo(BigDecimal.valueOf(1000000)) >= 0) {
                return bYuE.setScale(0, BigDecimal.ROUND_DOWN).toPlainString();
            }
            if (bYuE.compareTo(BigDecimal.valueOf(100000)) >= 0) {
                return bYuE.setScale(1, BigDecimal.ROUND_DOWN).toPlainString();
            }
            if (bYuE.compareTo(BigDecimal.valueOf(10000)) >= 0) {
                return bYuE.setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
            }
            if (bYuE.compareTo(BigDecimal.valueOf(1000)) >= 0) {
                return bYuE.setScale(3, BigDecimal.ROUND_DOWN).toPlainString();
            }
            if (bYuE.compareTo(BigDecimal.valueOf(100)) >= 0) {
                return bYuE.setScale(4, BigDecimal.ROUND_DOWN).toPlainString();
            }
            if (bYuE.compareTo(BigDecimal.valueOf(10)) >= 0) {
                return bYuE.setScale(5, BigDecimal.ROUND_DOWN).toPlainString();
            }
            if (bYuE.compareTo(BigDecimal.valueOf(1)) >= 0) {
                return bYuE.setScale(6, BigDecimal.ROUND_DOWN).toPlainString();
            }
            return bYuE.setScale(7, BigDecimal.ROUND_DOWN).toPlainString();
        } else {
            return tem;
        }
    }

    // ????????????????????????????????????
    private String formatYuetwo(BigDecimal bYuE) {
        return bYuE.setScale(2, BigDecimal.ROUND_DOWN).toPlainString();

    }

    private double usdeBalance = -1;
    private double usdeBalance2 = -1;

    private void toLoginOrCenter() {
        startActivityForResult(new Intent(getActivity(), LoginActivity.class), LoginActivity.RETURN_LOGIN);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_current_trust:
                setCurrentSelected();
                if (MyApplication.getApp().isLogin()) {
                    btnLogin.setVisibility(View.GONE);
                    msixRecycler.setVisibility(View.GONE);
                    llDeal.setVisibility(View.GONE);
                } else {
                    msixRecycler.setVisibility(View.GONE);
                    llDeal.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.VISIBLE);
                    SharedPreferenceInstance.getInstance().saveaToken("");
                    SharedPreferenceInstance.getInstance().saveTOKEN("");
                }
                break;
            case R.id.ll_history_trust:
                setHistorySelected();
                if (MyApplication.getApp().isLogin()) {
                    btnLogin.setVisibility(View.GONE);
                    msixRecycler.setVisibility(View.VISIBLE);
                    llDeal.setVisibility(View.GONE);
                    historyPage = startPage;
                    mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), sixinfo.getId(), currentPage, pageSize);
                } else {
                    msixRecycler.setVisibility(View.GONE);
                    llDeal.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.VISIBLE);
                    SharedPreferenceInstance.getInstance().saveaToken("");
                    SharedPreferenceInstance.getInstance().saveTOKEN("");
                }
                break;
            case R.id.ibMessage:
                if (this.currency != null)
                    KlineActivity.actionStart(getActivity(), this.currency.getSymbol(), "2");
                break;
            case R.id.btn_toLogin: // ????????????
                toLoginOrCenter();
                break;
            case R.id.mOneAdd: // +
                try {
                    double num = Double.valueOf(mOnePriceEdit.getText().toString());
                    mOnePriceEdit.setText(String.valueOf(new DecimalFormat("#0.000").format(num + 0.01)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.mOneSum: // -
                try {
                    double num1 = Double.valueOf(mOnePriceEdit.getText().toString());
                    if ((num1 - 0.01) > 0) {
                        mOnePriceEdit.setText(String.valueOf(new DecimalFormat("#0.000").format(num1 - 0.01)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.mTwoAdd: // +
                try {
                    double num1 = Double.valueOf(mTwoPriceEdit.getText().toString());
                    mTwoPriceEdit.setText(String.valueOf(new DecimalFormat("#0.000").format(num1 + 0.01)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.mTwoSub: // _
                try {
                    double num1 = Double.valueOf(mTwoPriceEdit.getText().toString());
                    if ((num1 - 0.01) > 0) {
                        mTwoPriceEdit.setText(String.valueOf(new DecimalFormat("#0.000").format(num1 - 0.01)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.text_to_all: // ??????????????????
                if (MyApplication.getApp().isLogin()) {
                    TrustListConstractActivity.show(getActivity(), sixinfo.getId());
                } else {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_xian_login) + "");
                }
                break;
            case R.id.btnOneBuy: // ??????
                Buy();
                break;
            case R.id.btnTwoPost: // ??????
                Sale();
                break;
            case R.id.rl_model_spinner:
                //??????popupwindow ???????????????????????????
                if (MyApplication.getApp().isLogin()) {
                    ShowModelPopupWindow();
                }
                break;
            case R.id.ll_all_model:
                //????????????
                if (targetPattern.equals("1")) {
                    mPresenter.getSwitchPattern(sixinfo.getId() + "", "0");
                }

                sixpopmodelView.dismiss();
                break;
            case R.id.ll_chase_model:
                //????????????
                if (targetPattern.equals("0")) {
                    mPresenter.getSwitchPattern(sixinfo.getId() + "", "1");
                }
                sixpopmodelView.dismiss();
                break;
            case R.id.rl_entrust_spinner:
                //??????popupwindow ?????????????????????????????????
                ShowEntrustPopupWindow();
                break;
            case R.id.ll_limit_entrust:
                //??????????????????
                tvEntrust.setText(getActivity().getResources().getText(R.string.text_limit));
                mOnePriceEdit.setHint(getActivity().getResources().getText(R.string.text_enter_price_constract));
                mOnePriceEdit.setText("");
                mTwoPriceEdit.setHint(getActivity().getResources().getText(R.string.text_enter_price_constract));
                mTwoPriceEdit.setText("");
                mOnetriggerPrice.setText("");
                mTwotriggerPrice2.setText("");
                type = "LIMIT_PRICE";
                mOneXian.setVisibility(View.VISIBLE);
                mTwoXian.setVisibility(View.VISIBLE);
                mTwoShi.setVisibility(View.GONE);
                mOneShi.setVisibility(View.GONE);
                mOneJiaoYi.setVisibility(View.VISIBLE);
                mTwoJiaoYi.setVisibility(View.VISIBLE);
                mTwoTcpEdit.setHint(getActivity().getResources().getText(R.string.text_number));
                mOneTcpEdit.setHint(getActivity().getResources().getText(R.string.text_number));
                mOneSeekBarLin.setVisibility(View.VISIBLE);
                mTwoSeekBarLin.setVisibility(View.VISIBLE);
                mOnetrigger.setVisibility(View.GONE);
                mTwotrigger2.setVisibility(View.GONE);
                sixPopEntrustView.dismiss();
                break;
            case R.id.ll_Market_entrust:
                //??????????????????
                tvEntrust.setText(getActivity().getResources().getText(R.string.text_Market));
                mOnePriceEdit.setHint(getActivity().getResources().getText(R.string.text_enter_price_constract));
                mOnePriceEdit.setText("");
                mTwoPriceEdit.setHint(getActivity().getResources().getText(R.string.text_enter_price_constract));
                mTwoPriceEdit.setText("");
                mOnetriggerPrice.setText("");
                mTwotriggerPrice2.setText("");
                type = "MARKET_PRICE";
                mOneXian.setVisibility(View.GONE);
                mTwoXian.setVisibility(View.GONE);
                mTwoShi.setVisibility(View.VISIBLE);
                mOneShi.setVisibility(View.VISIBLE);
                mOneJiaoYi.setVisibility(View.VISIBLE);
                mTwoJiaoYi.setVisibility(View.VISIBLE);
                mTwoTcpEdit.setHint(getActivity().getResources().getText(R.string.text_number));
                mOneTcpEdit.setHint(getActivity().getResources().getText(R.string.text_number));
                mOneSeekBarLin.setVisibility(View.VISIBLE);
                mTwoSeekBarLin.setVisibility(View.VISIBLE);
                mOnetrigger.setVisibility(View.GONE);
                mTwotrigger2.setVisibility(View.GONE);
                sixPopEntrustView.dismiss();
                break;
            case R.id.ll_plan_entrust:
                tvEntrust.setText(getActivity().getResources().getText(R.string.text_plan_entrust));
                mOnePriceEdit.setHint(getActivity().getResources().getText(R.string.default_market));
                mOnePriceEdit.setText("");
                mTwoPriceEdit.setHint(getActivity().getResources().getText(R.string.default_market));
                mTwoPriceEdit.setText("");
                mOnetriggerPrice.setText("");
                mTwotriggerPrice2.setText("");
                type = "PLAN_PRICE";
                mOneXian.setVisibility(View.VISIBLE);
                mTwoXian.setVisibility(View.VISIBLE);
                mTwoShi.setVisibility(View.GONE);
                mOneShi.setVisibility(View.GONE);
                mOneJiaoYi.setVisibility(View.VISIBLE);
                mTwoJiaoYi.setVisibility(View.VISIBLE);
                mOnetrigger.setVisibility(View.VISIBLE);
                mTwotrigger2.setVisibility(View.VISIBLE);
                mOneSeekBarLin.setVisibility(View.GONE);
                mTwoSeekBarLin.setVisibility(View.GONE);
                sixPopEntrustView.dismiss();
                break;
            case R.id.rl_multiples_spinner:
                //??????popupwindow ????????????
                if (MyApplication.getApp().isLogin()) {
                    ShowMultiplesPopupWindow();
                }
                break;
            case R.id.bu_true:
                // ????????????
                if (mtabtype == 0) {

                    mPresenter.getModifyLeverage(sixinfo.getId() + "", sixPopMultiplesView.getprogress(), "0");
                } else if (mtabtype == 1) {

                    mPresenter.getModifyLeverage(sixinfo.getId() + "", sixPopMultiplesView.getprogress(), "1");
                }
                break;
            case R.id.bu_close:
                //??????????????????popuwindow
                sixPopMultiplesView.dismiss();
                break;
            case R.id.bu_true2:
                // ????????????
                if (mtabtype == 0) {

                    mPresenter.getModifyLeverage(sixinfo.getId() + "", sixPopMultiplesView2.getnumber(), "0");
                } else if (mtabtype == 1) {

                    mPresenter.getModifyLeverage(sixinfo.getId() + "", sixPopMultiplesView2.getnumber(), "1");
                }
                break;
            case R.id.bu_close2:
                //??????????????????popuwindow
                sixPopMultiplesView2.dismiss();
                break;
            case R.id.tv_flat1:
                if (TextUtils.isEmpty((int) data.getUsdtBuyPosition()+"")){
                    return;
                }
                sixPopFlat = new SixPopFlat(getActivity(),(int) data.getUsdtBuyPosition()+"",1,sixinfo.getId(), mPresenter,this);
                sixPopFlat.showAtLocation(getActivity().findViewById(R.id.llRoot), Gravity.BOTTOM, 0, 0);
//                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_flat2:
                if (TextUtils.isEmpty((int) data.getUsdtSellPosition()+"")){
                    return;
                }
                sixPopFlat = new SixPopFlat(getActivity(),(int) data.getUsdtSellPosition()+"",2,sixinfo.getId(), mPresenter,this);
                sixPopFlat.showAtLocation(getActivity().findViewById(R.id.llRoot), Gravity.BOTTOM, 0, 0);
//                sixPopFlat = new SixPopFlat(getActivity(), this);
//                sixPopFlat.showAtLocation(getActivity().findViewById(R.id.llRoot), Gravity.BOTTOM, 0, 0);
//                Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvTitleOption:
                if (!MyApplication.getApp().isLogin()) {
                    LoginActivity.actionStart(getmActivity());
                    return;
                }
                OptionActivityKt.goOptionActivity(getmActivity());
                break;
            default:
        }
    }


    private void setHistorySelected() {
        now = 1;
        if (MyApplication.getApp().isLogin()) {
            mTvsix.setVisibility(View.GONE);
            tvCurrentTrust.setSelected(false);
            tvHistoryTrust.setSelected(true);
            currentTrustUnderline.setVisibility(View.GONE);
            historyTrustUnderline.setVisibility(View.VISIBLE);
            historyPage = startPage;
            llDeal.setVisibility(View.GONE);
            msixRecycler.setVisibility(View.VISIBLE);
            mcurrenentrust.clear();
            msixRecycler.setAdapter(currentEntrustAdapter);
            currentEntrustAdapter.notifyDataSetChanged();
            if (sixinfo != null) {
                mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), sixinfo.getId(), currentPage, pageSize);
            }
//            mPresenter.getOrderHistory(SharedPreferenceInstance.getInstance().getTOKEN(), historyPage, pageSize, this.currency.getSymbol(), "", "", "", "");
        } else {
//            WonderfulToastUtils.showToast("????????????");
//            MyApplication.getApp().loginAgain(getmActivity());
            SharedPreferenceInstance.getInstance().saveaToken("");
            SharedPreferenceInstance.getInstance().saveTOKEN("");
        }
    }

    private void setCurrentSelected() {
        if (MyApplication.getApp().isLogin()) {
            now = 0;
            btnLogin.setVisibility(View.GONE);
            mTvsix.setVisibility(View.GONE);
            tvCurrentTrust.setSelected(true);
            tvHistoryTrust.setSelected(false);
            currentTrustUnderline.setVisibility(View.VISIBLE);
            historyTrustUnderline.setVisibility(View.GONE);
            llDeal.setVisibility(View.GONE);
            msixRecycler.setVisibility(View.GONE);
            if (sixinfo != null) {
                mPresenter.getDetail(sixinfo.getId() + "", SharedPreferenceInstance.getInstance().getTOKEN());
            }
        } else {
            SharedPreferenceInstance.getInstance().saveaToken("");
            SharedPreferenceInstance.getInstance().saveTOKEN("");
        }

    }

    private String price; // ???????????????
    private String amout; // ???????????????
    private String type = "LIMIT_PRICE";


    private void Buy() {
        if (currency == null) {
            return;
        }
        if (!MyApplication.getApp().isLogin()) {
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_xian_login) + "");
            return;
        }

        switch (type) {
            case "LIMIT_PRICE":
                price = mOnePriceEdit.getText().toString();
                amout = mOneTcpEdit.getText().toString();
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (amout.contains("%")) {
                    String substring = amout.substring(0, amout.length() - 1);
                    if (substring.equals("0")) {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                        return;
                    }
                    double su = (Double.parseDouble(substring) / 100) * zhangs;
                    if (su < 1) {
                        amout = 1 + "";
                    } else {
                        amout = (int) su + "";
                    }
                }
                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                    return;
                }
                if (new BigDecimal(price).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }

                entrusttype = 1;
                multiples = tvMultiples.getText().toString().trim();
                if (mPresenter != null) {
                    if (mtabtype == 0) {
                        //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                        mPresenter.getAddOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "0", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    } else if (mtabtype == 1) {
                        mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "0", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                }
                break;
            case "MARKET_PRICE":
                price = "0.0";
                amout = mOneTcpEdit.getText().toString();
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_number) + "");
                    return;
                }
                if (amout.contains("%")) {
                    String substring = amout.substring(0, amout.length() - 1);
                    if (substring.equals("0")) {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                        return;
                    }
                    double su = (Double.parseDouble(substring) / 100) * zhangs;
                    if (su < 1) {
                        amout = 1 + "";
                    } else {
                        amout = (int) su + "";
                    }
                }
                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                    return;
                }
                entrusttype = 0;
                multiples = tvMultiples.getText().toString().trim();
                if (mPresenter != null) {
                    if (mtabtype == 0) {
                        //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                        mPresenter.getAddOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "0", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    } else if (mtabtype == 1) {
                        mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "0", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                }
                break;
            case "PLAN_PRICE":
                String plan = "";
                price = mOnePriceEdit.getText().toString();
                amout = mOneTcpEdit.getText().toString();
                plan = mOnetriggerPrice.getText().toString();
                if (price.equals("")) {
                    price = "0";
                }
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                    return;
                }
                if (new BigDecimal(price).compareTo(BigDecimal.ZERO) < 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }
                entrusttype = 2;
                multiples = tvMultiples.getText().toString().trim();
                if (mPresenter != null) {
                    if (mtabtype == 0) {
                        //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                        mPresenter.getAddOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "0", sixinfo.getId() + "", plan, price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    } else if (mtabtype == 1) {
                        mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "0", sixinfo.getId() + "", plan, price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                }
                break;
            default:
        }
    }

    private void Sale() {
        if (currency == null) return;
        if (!MyApplication.getApp().isLogin()) {
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_xian_login) + "");
            return;
        }
        switch (type) {
            case "LIMIT_PRICE":
                price = mTwoPriceEdit.getText().toString();
                amout = mTwoTcpEdit.getText().toString();
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (amout.contains("%")) {
                    String substring = amout.substring(0, amout.length() - 1);
                    if (substring.equals("0")) {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                        return;
                    }
                    double su = (Double.parseDouble(substring) / 100) * zhangs;
                    if (su < 1) {
                        amout = 1 + "";
                    } else {
                        amout = (int) su + "";
                    }
                }
                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                    return;
                }
                if (new BigDecimal(price).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }

                entrusttype = 1;
                multiples = tvMultiples.getText().toString().trim();
                if (mPresenter != null) {
                    if (mtabtype == 0) {
                        //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                        mPresenter.getAddOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "1", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                    if (mtabtype == 1) {
                        mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "1", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                }
                break;
            case "MARKET_PRICE":
                price = "0.0";
                amout = mTwoTcpEdit.getText().toString();
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_number) + "");
                    return;
                }
                if (amout.contains("%")) {
                    String substring = amout.substring(0, amout.length() - 1);
                    if (substring.equals("0")) {
                        WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                        return;
                    }
                    double su = (Double.parseDouble(substring) / 100) * zhangs;
                    if (su < 1) {
                        amout = 1 + "";
                    } else {
                        amout = (int) su + "";
                    }
                }
                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }
                entrusttype = 0;
                multiples = tvMultiples.getText().toString().trim();
                if (mPresenter != null) {
                    if (mtabtype == 0) {
                        //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                        mPresenter.getAddOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "1", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                    if (mtabtype == 1) {

                        mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "1", sixinfo.getId() + "", "0", price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                }
                break;
            case "PLAN_PRICE":
                String plan = "";
                price = mTwoPriceEdit.getText().toString();
                amout = mTwoTcpEdit.getText().toString();
                plan = mTwotriggerPrice2.getText().toString();
                if (price.equals("")) {
                    price = "0";
                }
                if (WonderfulStringUtils.isEmpty(price, amout)) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_entrust_price_number) + "");
                    return;
                }
                if (new BigDecimal(amout).compareTo(BigDecimal.ZERO) <= 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.number_big_zero) + "");
                    return;
                }
                if (new BigDecimal(price).compareTo(BigDecimal.ZERO) < 0) {
                    WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.input_ok_entrust_price) + "");
                    return;
                }
                entrusttype = 2;
                multiples = tvMultiples.getText().toString().trim();
                if (mPresenter != null) {
                    if (mtabtype == 0) {
                        //  1:token 2:??????????????????????????????   3??????  0  ???  1 4???id  5???????????????????????????   6?????????  7?????????  8  ??????
                        mPresenter.getAddOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "1", sixinfo.getId() + "", plan, price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                    if (mtabtype == 1) {

                        mPresenter.getcloseOrder(SharedPreferenceInstance.getInstance().getTOKEN(),
                                entrusttype + "", "1", sixinfo.getId() + "", plan, price,
                                multiples.contains("x") ? multiples.substring(0, multiples.length() - 1) : multiples,
                                amout);
                    }
                }
                break;
            default:
        }
    }

    private void ShowModelPopupWindow() {
        sixpopmodelView = new SixPopModelView(getActivity(), this);
        sixpopmodelView.showAsDropDown(getActivity().findViewById(R.id.rl_model_spinner), 0, 0, Gravity.BOTTOM);
    }

    private void ShowEntrustPopupWindow() {
        sixPopEntrustView = new SixPopEntrustView(getActivity(), this);
        sixPopEntrustView.showAsDropDown(getActivity().findViewById(R.id.rl_entrust_spinner), 0, 0, Gravity.BOTTOM);
    }

    private void ShowMultiplesPopupWindow() {
        String progres = "1";
        if (mtabtype == 0) {
            progres = buyprogres;
        } else if (mtabtype == 1) {
            progres = sellprogres;
        }

        if (sixinfo.getLeverageType() == 1) {
            sixPopMultiplesView2 = new SixPopMultiplesView2(getActivity(), progres, sixinfo.getLeverage(), this);
            sixPopMultiplesView2.showAtLocation(getActivity().findViewById(R.id.llRoot), Gravity.BOTTOM, 0, 0);
        } else if (sixinfo.getLeverageType() == 2) {
            sixPopMultiplesView = new SixPopMultiplesView(getActivity(), progres, sixinfo.getLeverage(), this);
            sixPopMultiplesView.showAtLocation(getActivity().findViewById(R.id.llRoot), Gravity.BOTTOM, 0, 0);
        }
    }

    /**
     * ????????????????????? ??? ?????????????????????
     *
     * @param response SocketResponse
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(SocketResponse response) {
        if (response.getCmd() == null) return;
        switch (response.getCmd()) {
            case CONTRACT_PUSH_EXCHANGE_PLATE:
                WonderfulLogUtils.logd("jiejie", " ???????????????" + response.getResponse());
                try {
                    setResponse(response.getResponse());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case CONTRACT_PUSH_EXCHANGE_ORDER_CANCELED:
            case CONTRACT_PUSH_EXCHANGE_ORDER_COMPLETED:
            case CONTRACT_PUSH_EXCHANGE_ORDER_TRADE:
                if (MyApplication.getApp().isLogin() && this.currency != null) {
                    currentPage = startPage;
                    historyPage = startPage;
                    mPresenter.getCurrentOrder(SharedPreferenceInstance.getInstance().getTOKEN(), sixinfo.getId(), currentPage, pageSize);
                }
                break;
            default:
                break;
        }
    }

    /**
     * ??????????????????????????????
     */
    private void setResponse(String response) {
        if (TextUtils.isEmpty(response)) return;
        TextItems items = new Gson().fromJson(response, TextItems.class);
        if (currency.getSymbol().equals(items.getSymbol())) {

        } else {
            return;
        }
        if ("SELL".equals(items.getDirection())) { // ???
            this.mOne.clear();
            for (int i = 0; i < 5; i++) {
                mOne.add(new Exchange(5 - i, "--", "--"));
            }
            List<Exchange> ask = items.getItems();
            if (ask.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    mOne.set(4 - i, new Exchange(i + 1, ask.get(i).getPrice(), ask.get(i).getAmount()));
                }
            } else {
                for (int i = 0; i < ask.size(); i++) {
                    mOne.set(4 - i, new Exchange(i + 1, ask.get(i).getPrice(), ask.get(i).getAmount()));
                }
            }
            mOneAdapter.setList(mOne);
            mOneAdapter.notifyDataSetChanged();
        } else { // ???
            this.mTow.clear();
            for (int i = 0; i < 5; i++) {
                mTow.add(new Exchange(5 - i, "--", "--"));
            }
            List<Exchange> bid = items.getItems();
            if (bid.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    mTow.set(i, new Exchange(i, bid.get(i).getPrice(), bid.get(i).getAmount()));
                }
            } else {
                for (int i = 0; i < bid.size(); i++) {
                    mTow.set(i, new Exchange(i, bid.get(i).getPrice(), bid.get(i).getAmount()));
                }
            }
            mTwoAdapter.setList(mTow);
            mTwoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setPresenter(MainContract.SixPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    public void Clear() { //???????????? ???progress
        mOneTcpEdit.setText("");
        mTwoTcpEdit.setText("");
        mOneSeekBar.setProgress(0);
        mTwoSeekBar.setProgress(0);
        mOnePriceEdit.setText("");
        mTwoPriceEdit.setText("");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //???k?????????????????????????????????
        now = 0;
        if (currency != null) {
            mPresenter.getSymbolInfo(currency.getSymbol());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}