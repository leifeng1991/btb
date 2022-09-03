package com.bishang366.ui.option;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bishang366.R;
import com.bishang366.adapter.AddAmount;
import com.bishang366.app.GlobalConstant;
import com.bishang366.app.Injection;
import com.bishang366.app.MyApplication;
import com.bishang366.base.BaseFragment;
import com.bishang366.base.BaseTransFragment;
import com.bishang366.entity.Currency;
import com.bishang366.entity.Money;
import com.bishang366.entity.OptionDetailInfo;
import com.bishang366.entity.OptionIconBean;
import com.bishang366.entity.OptionOrderHistoryBean;
import com.bishang366.serivce.SocketResponse;
import com.bishang366.socket.ISocket;
import com.bishang366.ui.home.ConstractFragment;
import com.bishang366.ui.home.MarketBaseFragment;
import com.bishang366.ui.kline.KlineContract;
import com.bishang366.ui.kline.KlinePresenter;
import com.bishang366.ui.kline.kline.KData;
import com.bishang366.ui.kline.kline.KLineView;
import com.bishang366.ui.login.LoginActivity;
import com.bishang366.ui.mychart.DataParse;
import com.bishang366.ui.mychart.KLineBean;
import com.bishang366.utils.LoadDialog;
import com.bishang366.utils.SharedPreferenceInstance;
import com.bishang366.utils.WonderfulDateUtils;
import com.bishang366.utils.WonderfulLogUtils;
import com.bishang366.utils.WonderfulToastUtils;
import com.bishang366.widget.SevenPopIconView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OptionRealFragment extends BaseTransFragment implements KlineContract.View, View.OnClickListener {
    public static final String TAG = OptionRealFragment.class.getSimpleName();

    @BindView(R.id.ibBack)
    ImageButton ibBack;
    @BindArray(R.array.k_line_tab_option)
    String[] titles;
    @BindView(R.id.ibOpen)
    ImageButton ibOpen;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.ibMessage)
    ImageView ibMessage;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    @BindView(R.id.tv_current_trust)
    TextView tvCurrentTrust;
    @BindView(R.id.current_trust_underline)
    View currentTrustUnderline;
    @BindView(R.id.ll_current_trust)
    LinearLayout llCurrentTrust;
    @BindView(R.id.tv_history_trust)
    TextView tvHistoryTrust;
    @BindView(R.id.history_trust_underline)
    View historyTrustUnderline;
    @BindView(R.id.ll_history_trust)
    LinearLayout llHistoryTrust;
    @BindView(R.id.text_to_all)
    RelativeLayout textToAll;
    @BindView(R.id.mTvseven)
    TextView mTvseven;
    @BindView(R.id.btn_toLogin)
    TextView btnToLogin;
    @BindView(R.id.smartrefreshLayout)
    SmartRefreshLayout smartrefreshLayout;
    @BindView(R.id.llRoot)
    RelativeLayout llRoot;
    @BindView(R.id.tab_time)
    LinearLayout tabTime;
    @BindView(R.id.kline_view)
    KLineView klineView;
    @BindView(R.id.ll_k)
    LinearLayout llK;
    @BindView(R.id.tv_open_price)
    TextView tvOpenPrice;
    @BindView(R.id.tv_now_price)
    TextView tvNowPrice;
    @BindView(R.id.tv_expect)
    TextView tvExpect;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.tv_sell)
    TextView tvSell;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.rv_amount)
    RecyclerView rvAmount;
    @BindView(R.id.tv_use_money)
    TextView tvUseMoney;
    @BindView(R.id.bu_rise)
    Button buRise;
    @BindView(R.id.bu_fall)
    Button buFall;
    @BindView(R.id.ll_history)
    LinearLayout llHistory;
    @BindView(R.id.ll_current)
    LinearLayout llCurrent;
    @BindView(R.id.tv_expect2)
    TextView tvExpect2;
    @BindView(R.id.tv_buy2)
    TextView tvBuy2;
    @BindView(R.id.tv_sell2)
    TextView tvSell2;
    @BindView(R.id.tv_amount2)
    TextView tvAmount2;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.tv_percent)
    TextView tvPercent;
    @BindView(R.id.rv_history)
    RecyclerView rvHistory;
    @BindView(R.id.rv_current)
    RecyclerView rvCurrent;
    @BindView(R.id.installments)
    TextView installments;
    @BindView(R.id.tv_time2)
    TextView tvTime2;
    @BindView(R.id.now_one)
    TextView nowOne;
    @BindView(R.id.now_two)
    TextView nowTwo;
    @BindView(R.id.now_three)
    TextView nowThree;
    @BindView(R.id.now_four)
    TextView nowFour;
    @BindView(R.id.now_five)
    TextView nowFive;
    @BindView(R.id.now_six)
    TextView nowSix;
    @BindView(R.id.ll_one_current)
    LinearLayout llOneCurrent;
    @BindView(R.id.tv_time_current)
    TextView tvTimeCurrent;
    @BindView(R.id.tv_compensation)
    TextView tvCompensation;

    private ArrayList<TextView> textViews;
    private List<BaseFragment> menusFragments = new ArrayList<>();
    private Currency optionBean;
    private List<Currency> optionBeans = new ArrayList<>();
    private List<OptionIconBean.DataBean.ContentBean> contentBean = new ArrayList<>();
    private KlinePresenter mPresenter;

    private KData lastKline = new KData();
    private ConstractFragment constractframent;
    private Gson gson = new Gson();
    private Unbinder unbinder1;
    private long to;
    private Date endDate;
    private long from;
    private Date startDate;
    private String resolution;
    private int type = GlobalConstant.TAG_THIRTY_MINUTE;
    private TextView selectedTextView;
    private ArrayList<KLineBean> kLineDatas;
    private ArrayList<KData> kLineEntities;
    private SevenPopIconView sevenPopIconView;
    private AddAmount adapter;
    private OptionOrderAdapter currentAdapter;
    private OptionOrderAdapter historyAdapter;
    private List<String> amountlist;
    private List<OptionOrderHistoryBean.DataBean.ContentBean> historybean;
    private int currentPosition = -1;
    private long nowtime;
    private Money.DataBean data;
    private int historySize = 10;
    private int historyPage = 0;
    private Timer timer;
    private OptionOrderHistoryBean.DataBean OrderHistory;
    private int history = 0;
    private Timer timer2;
    private OptionViewModel viewModel;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_option_real;
    }


    @Override
    protected void initViews(Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getViewModelStore(), ViewModelProvider.AndroidViewModelFactory.getInstance(getmActivity().getApplication())).get(OptionViewModel.class);
        tvUseMoney.setText(getActivity().getResources().getText(R.string.text_use_balance) + "：0.00 USDT");
        if (mPresenter == null) {
            mPresenter = new KlinePresenter(Injection.provideTasksRepository(getmActivity().getApplication()), this);
        }
        if (constractframent == null) {
            int type = MarketBaseFragment.MarketOperateCallback.TYPE_SWITCH_SYMBOL;
            menusFragments.add(constractframent = ConstractFragment.getInstance(type));
        }
        // 打开左侧的滑动
        ibOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((OptionActivity) getActivity()).show_option();
                ((OptionActivity) getActivity()).getDlRoot().openDrawer(Gravity.LEFT);
            }
        });
        smartrefreshLayout.setEnableRefresh(false);//禁用下拉刷新
        smartrefreshLayout.setEnableLoadMore(true);
        smartrefreshLayout.setRefreshFooter(new ClassicsFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
        smartrefreshLayout.setEnableAutoLoadMore(true);//是否启用列表惯性滑动到底部时自动加载更多
        smartrefreshLayout.setEnablePureScrollMode(false);//是否启用纯滚动模式
        smartrefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadMore();
                smartrefreshLayout.finishLoadMore(true);
            }
        });
        amountlist = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvAmount.setLayoutManager(manager);
        adapter = new AddAmount(R.layout.adapter_addmultiples, amountlist);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //这里赋值s
                currentPosition = position;
                //每点击一次item就刷新适配器
                adapter.notifyDataSetChanged();
            }
        });
        adapter.setItemSelectedCallBack(new AddAmount.ItemSelectedCallBack() {
            @Override
            public void convert(BaseViewHolder holder, int position) {
                //初始化组件
                TextView tv = holder.getView(R.id.tv_add);
                //判断传入的position是否和当前一致
                if (position == currentPosition) {
                    tv.setBackgroundResource(R.drawable.shape_six_multiples_item_color_orange);
                } else {
                    tv.setBackgroundResource(R.color.transparent);
                }
            }
        });
        rvAmount.setAdapter(adapter);
        historybean = new ArrayList<>();
        rvHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
        historyAdapter = new OptionOrderAdapter(R.layout.adapter_option_history, viewModel.getHistorySortInfo().getValue(), true);
        rvHistory.setAdapter(historyAdapter);
        rvCurrent.setLayoutManager(new LinearLayoutManager(getActivity()));
        currentAdapter = new OptionOrderAdapter(R.layout.adapter_option_history, viewModel.getCurrentSortInfo().getValue(), false);
        rvCurrent.setAdapter(currentAdapter);
        currentAdapter.setItemSelectedCallBack(new OptionOrderAdapter.ItemSelectedCallBack() {
            @Override
            public void convert(@NotNull BaseViewHolder holder, int position) {

            }

            @Override
            public void notifyData(@Nullable List<OptionDetailInfo> data) {
                ibBack.post(new Runnable() {
                    @Override
                    public void run() {
                        for (OptionDetailInfo info : data
                        ) {
                            int time = info.getCountDownTime();
                            info.setCountDownTime(time--);
                        }
                        currentAdapter.replaceData(data);
                        currentAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
        initPlate();
        llCurrentTrust.setOnClickListener(this);
        llHistoryTrust.setOnClickListener(this);
        buRise.setOnClickListener(this);
        buFall.setOnClickListener(this);
        ibBack.setOnClickListener(this);
        tvCompensation.setOnClickListener(this);
        viewModel.getCurrentSortInfo().observe(this, it -> {
            if (!it.isEmpty()) {
                currentAdapter.replaceData(it);
                currentAdapter.notifyDataSetChanged();
                countDown();
            } else {
                cancelCountDown();
            }
        });
        viewModel.getHistorySortInfo().observe(this, it -> {
            historyAdapter.replaceData(it);
            historyAdapter.notifyDataSetChanged();
        });
    }

    void cancelCountDown() {
        if (timer != null) {
            timer.cancel();
        }
    }

    void countDown() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                ibBack.post(new Runnable() {
                    @Override
                    public void run() {
                        List<OptionDetailInfo> list = currentAdapter.getData();
                        List<OptionDetailInfo> list1 = new ArrayList<>();
                        for (int i = 0; i < list.size(); i++) {
                            OptionDetailInfo it = list.get(i);
                            int time = it.getCountDownTime();
                            --time;
                            if (time >= 0) {
                                it.setCountDownTime(time);
                                list1.add(it);
                            }
                        }
                        if (list1.size() == 0) {
                            cancelCountDown();
                        }
                        currentAdapter.replaceData(list1);
                        currentAdapter.notifyDataSetChanged();
                        viewModel.getLast().clear();
                        viewModel.getLast().addAll(list1);
                    }
                });
            }
        }, 0, 1000);
    }

    @Override
    protected void obtainData() {
        textViews = new ArrayList<>();
        loadData2();
        initTextView();


        selectedTextView = textViews.get(3);
        Drawable home_zhang_no = getResources().getDrawable(
                R.drawable.tab);
        selectedTextView.setCompoundDrawablesWithIntrinsicBounds(null,
                null, null, home_zhang_no);
        this.type = (int) selectedTextView.getTag();
        loadData();
        viewModel.getSecondOptionCurrent(optionBean.getSymbol());
        viewModel.getSecondOptionHistory(optionBean.getSymbol(), "0", "40000");
    }

    //点击往期结果里icon弹出当前的数据
    private void showIconData(int position) {
        sevenPopIconView = new SevenPopIconView(getActivity(), contentBean.get(position), this);
        sevenPopIconView.showAtLocation(getActivity().findViewById(R.id.llRoot), Gravity.BOTTOM, 0, 0);
    }


    @Override
    protected void fillWidget() {

    }

    public void setCurrencyInfo(List<Currency> dataBeans) {

        this.optionBeans.clear();
        this.optionBeans.addAll(dataBeans);
        for (int i = 0; i < optionBeans.size(); i++) {
            if ("BTC/USDT".equals(optionBeans.get(i).getSymbol())) {
                this.optionBean = optionBeans.get(i);
            }
        }
    }

    /**
     * 这个是从主界面(左滑动栏目)来的，表示选择了某个币种
     */
    public void resetSymbol(Currency optionBean) {
        this.optionBean = optionBean;
        Log.i("six", "执行函数：resetSymbol" + this.optionBean.getSymbol());
        if (this.optionBean != null) {
            tvTitle.setText(this.optionBean.getSymbol() + " " + getActivity().getResources().getText(R.string.second_contract));

            loadData2();

            viewModel.getSecondOptionCurrent(optionBean.getSymbol());
            viewModel.getSecondOptionHistory(optionBean.getSymbol(), "0", "40000");
        }
    }

    @Override
    protected void loadData() {
        if (MyApplication.getApp().isLogin() && TextUtils.isEmpty(SharedPreferenceInstance.getInstance().getTOKEN())) {
            MyApplication.getApp().loginAgain(this);
            WonderfulToastUtils.showToast(getActivity().getResources().getText(R.string.text_login_disabled) + "");
            return;
        }
        tvTitle.setText(optionBean.getSymbol() + getActivity().getResources().getText(R.string.second_contract));
        llCurrent.setVisibility(View.VISIBLE);
        llHistory.setVisibility(View.GONE);
        tvCurrentTrust.setSelected(true);
        tvHistoryTrust.setSelected(false);
        currentTrustUnderline.setVisibility(View.VISIBLE);
        historyTrustUnderline.setVisibility(View.GONE);
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
     * 这个是刚开始
     */
    public void initPlate() {
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }


    private void toLoginOrCenter() {
        startActivityForResult(new Intent(getActivity(), LoginActivity.class), LoginActivity.RETURN_LOGIN);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toLogin: // 点击登录
                toLoginOrCenter();
                break;
            case R.id.ll_current_trust: // 点击当前委托
                if (MyApplication.getApp().isLogin()) {
                    llCurrent.setVisibility(View.VISIBLE);
                    llHistory.setVisibility(View.GONE);
                    tvCurrentTrust.setSelected(true);
                    tvHistoryTrust.setSelected(false);
                    currentTrustUnderline.setVisibility(View.VISIBLE);
                    historyTrustUnderline.setVisibility(View.GONE);
                }
                break;
            case R.id.ll_history_trust: // 点击历史委托
                if (MyApplication.getApp().isLogin()) {
                    llCurrent.setVisibility(View.GONE);
                    llHistory.setVisibility(View.VISIBLE);
                    tvCurrentTrust.setSelected(false);
                    tvHistoryTrust.setSelected(true);
                    currentTrustUnderline.setVisibility(View.GONE);
                    historyTrustUnderline.setVisibility(View.VISIBLE);
                    viewModel.getSecondOptionHistory(optionBean.getSymbol(), "0", "40000");
                }
                break;
            case R.id.bu_rise:
                look(0);
                break;
            case R.id.bu_fall:
                look(1);
                break;
            case R.id.ibBack:
                finish();
                break;
            case R.id.tv_compensation:
                CompensationDialogFragment orderConfirmDialogFragment = new CompensationDialogFragment();
                orderConfirmDialogFragment.show(getActivity().getSupportFragmentManager(), "CompensationDialogFragment");
                break;
            default:
        }
    }

    //点击  0看涨  1看跌
    private void look(int type) {
        if (optionBean != null) {
            OrderConfirmActivityKt.goOrderConfirmActivity(getmActivity(), type, optionBean.getClose().toString(), optionBean.getSymbol());
        }
    }


    /**
     * socket 推送过来的信息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSocketMessage(SocketResponse response) {
        if (response.getCmd() == ISocket.CMD.CONTRACT_PUSH_SYMBOL_THUMB) {
            // 如果是合约盘口返回的信息
            try {
                Currency temp = new Gson().fromJson(response.getResponse(), Currency.class);
                for (Currency bean : optionBeans) {
                    if (temp.getSymbol().equals(bean.getSymbol())) {
                        Currency currency = temp;
//                        Currency.shallowClone(currency, temp);
                        if (currency.getSymbol().equals(optionBean.getSymbol())) {
                            if (currency.getClose() > this.lastKline.getMaxPrice()) {
                                this.lastKline.setMaxPrice(currency.getClose().floatValue());
                            }
                            if (currency.getClose() < this.lastKline.getMinPrice()) {
                                this.lastKline.setMinPrice(currency.getClose().floatValue());
                            }

                            this.lastKline.setClosePrice(currency.getClose().floatValue());
                            System.out.println("lase:" + this.lastKline.getClosePrice());
                            klineView.addSingleData(lastKline);
                            tvNowPrice.setText(temp.getClose() + " USDT");
                        }
                        Activity op = getmActivity();
                        if (op instanceof OptionActivity) {

                            for (Currency currency1 : ((OptionActivity) op).getCurrencyListAll()) {
                                if (temp.getSymbol().equals(currency1.getSymbol())) {
                                    Currency.shallowClone(currency1, temp);
                                    break;
                                }
                            }
                            ((OptionActivity) op).tcpNotify();
                        }
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        cancelCountDown();
        unbinder1.unbind();
    }

    /**
     * 设置tab栏显示内容
     */
    private void initTextView() {
        List<String> titles = Arrays.asList(this.titles);
        for (int i = 0; i < titles.size(); i++) {
            TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.textview_pop, null);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            textView.setLayoutParams(layoutParams);
            textView.setText(titles.get(i));
            if (titles.get(i).equals("30分钟")) {
                textView.setTag(5);
            } else if (titles.get(i).equals("1小时")) {
                textView.setTag(3);
            } else if (titles.get(i).equals("1天")) {
                textView.setTag(4);
            } else {
                textView.setTag(i);
            }
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedTextView = (TextView) view;
                    int selectedTag = (int) selectedTextView.getTag();
                    type = selectedTag;
                    setPagerView();
                }
            });
            textViews.add(textView);
            tabTime.addView(textView);
        }
    }

    /**
     * viewpager和textview的点击事件
     */
    private void setPagerView() {
        for (int j = 0; j < textViews.size(); j++) {
            textViews.get(j).setSelected(false);
            textViews.get(j).setCompoundDrawablesWithIntrinsicBounds(null,
                    null, null, null);
            int tag = (int) textViews.get(j).getTag();
            if (tag == type) {
                textViews.get(j).setSelected(true);
                Drawable home_zhang_no1 = getResources().getDrawable(
                        R.drawable.tab);
                textViews.get(j).setCompoundDrawablesWithIntrinsicBounds(null,
                        null, null, home_zhang_no1);

                if (type != GlobalConstant.TAG_DIVIDE_TIME) {
                    if (klineView.isShowInstant()) {
                        klineView.setShowInstant(!klineView.isShowInstant());
                    } else {

                    }

                    loadData2();
                } else {
                    if (klineView.isShowInstant()) {
                    } else {
                        klineView.setShowInstant(!klineView.isShowInstant());
                    }
                    loadData2();
                }
            }
        }
    }

    private void loadData2() {
        to = System.currentTimeMillis();
        endDate = WonderfulDateUtils.getDate("HH:mm", to);
        from = to;
        WonderfulLogUtils.logi(TAG, "type==" + type);

        switch (type) {
            case GlobalConstant.TAG_DIVIDE_TIME:
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY) - 1;
                c.set(Calendar.HOUR_OF_DAY, hour);
                String strDate = WonderfulDateUtils.getFormatTime("HH:mm", c.getTime());
                startDate = WonderfulDateUtils.getDateTransformString(strDate, "HH:mm");
                resolution = 1 + "";
                String str = WonderfulDateUtils.getFormatTime(null, c.getTime());
                from = WonderfulDateUtils.getTimeMillis(null, str);
                klineView.setTime_Type(GlobalConstant.TAG_DIVIDE_TIME);
                break;
            case GlobalConstant.TAG_ONE_MINUTE:
                from = to - 24L * 60 * 60 * 1000;//前一天数据
                resolution = 1 + "";
                klineView.setTime_Type(GlobalConstant.TAG_ONE_MINUTE);
                break;
            case GlobalConstant.TAG_FIVE_MINUTE:
                from = to - 2 * 24L * 60 * 60 * 1000;//前两天数据
                resolution = 5 + "";
                klineView.setTime_Type(GlobalConstant.TAG_FIVE_MINUTE);
                break;
            case GlobalConstant.TAG_THIRTY_MINUTE:
                from = to - 12 * 24L * 60 * 60 * 1000; //前12天数据
                resolution = 30 + "";
                klineView.setTime_Type(GlobalConstant.TAG_THIRTY_MINUTE);
                break;
            case GlobalConstant.TAG_AN_HOUR:
                from = to - 24 * 24L * 60 * 60 * 1000;//前 24天数据
                resolution = 60 + "";
                klineView.setTime_Type(GlobalConstant.TAG_AN_HOUR);
                break;
            case GlobalConstant.TAG_DAY:
                from = to - 60 * 24L * 60 * 60 * 1000 * 3; //前60天数据*3
                resolution = 1 + "D";
                klineView.setTime_Type(GlobalConstant.TAG_DAY);
                break;
            case GlobalConstant.TAG_WEEK:
                from = to - 730 * 24L * 60 * 60 * 1000 * 3; //前两年数据*3
                resolution = 1 + "W";
                klineView.setTime_Type(GlobalConstant.TAG_WEEK);
                break;
            case GlobalConstant.TAG_MONTH:
                from = to - 1095 * 24L * 60 * 60 * 1000 * 3; //前三年数据*3
                resolution = 1 + "M";
                klineView.setTime_Type(GlobalConstant.TAG_MONTH);
                break;
            default:
        }
        if (optionBean != null) {
            mPresenter.KData_Constract(optionBean.getSymbol(), from, to, resolution, "1");
        }
        if (timer2 != null) {
            timer2.cancel();
        }
        timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                if (lastKline.getTime() != 0) {
                    switch (type) {
                        case GlobalConstant.TAG_DIVIDE_TIME:
                            if (time >= (lastKline.getTime() + (1000 * 60 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        case GlobalConstant.TAG_ONE_MINUTE:
                            if (time >= (lastKline.getTime() + (1000 * 60 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        case GlobalConstant.TAG_FIVE_MINUTE:
                            if (time >= (lastKline.getTime() + (1000 * 60 * 5 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        case GlobalConstant.TAG_THIRTY_MINUTE:
                            if (time >= (lastKline.getTime() + (1000 * 60 * 30 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        case GlobalConstant.TAG_AN_HOUR:
                            if (time >= (lastKline.getTime() + (1000 * 60 * 60 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        case GlobalConstant.TAG_DAY:
                            if (time >= (lastKline.getTime() + (1000 * 60 * 60 * 24 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        case GlobalConstant.TAG_WEEK:
                            if (time >= (lastKline.getTime() + (1000 * 60 * 60 * 24 * 7 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        case GlobalConstant.TAG_MONTH:
                            if (time >= (lastKline.getTime() + (1000 * 60 * 60 * 24 * 30 + 1000))) {
                                mPresenter.KData_Constract(optionBean.getSymbol(), from, time, resolution, "1");
                            }
                            break;
                        default:
                    }
                }
            }
        }, 1000, 1000);
    }

    public void setListData(OptionOrderHistoryBean.DataBean list) {
        if (historyPage == 0) {
            historybean.clear();
//            historyAdapter = new OptionHistoryAdapter(historybean);
//            rvHistory.setLayoutManager(new LinearLayoutManager(getActivity()));
//            rvHistory.setAdapter(historyAdapter);
            historyAdapter.setEnableLoadMore(true);
            historyAdapter.loadMoreEnd(false);
        }
        for (int i = 0; i < list.getContent().size(); i++) {
            if (!list.getContent().get(i).getResult().equals("WAIT")) {
                historybean.add(list.getContent().get(i));
            }
        }
//        historybean.addAll(list.getContent());
        historyAdapter.notifyDataSetChanged();

        if (list.getContent().size() < historyPage) {
            smartrefreshLayout.setEnableLoadMore(false);
        } else {
            smartrefreshLayout.setEnableLoadMore(true);
        }
    }

    private void loadMore() {
        historyPage = historyPage + 1;
        if (MyApplication.getApp().isLogin()) {
        }
    }

    private LoadDialog mDialog;

    public void showDialog() {
        if (mDialog == null) {
            mDialog = new LoadDialog(getmActivity());
        }
        mDialog.show();
    }

    public void hideDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void KDataSuccess(JSONArray obj) {
        WonderfulLogUtils.logi(TAG, "KDataSuccess type==" + type);
        DataParse kData = new DataParse();
        try {
            kData.parseKLine(obj, type);
            kLineDatas = kData.getKLineDatas();
            if (kLineDatas != null && kLineDatas.size() > 0) {
                klineView.setVisibility(View.VISIBLE);
                kLineEntities = new ArrayList<>();
                kLineEntities.clear();
                for (int i = 0; i < kLineDatas.size(); i++) {
                    KData lineEntity = new KData();
                    KLineBean kLineBean = kLineDatas.get(i);
                    lineEntity.setTime(Long.parseLong(kLineBean.getDate()));
                    lineEntity.setOpenPrice(kLineBean.getOpen());
                    lineEntity.setClosePrice(kLineBean.getClose());
                    lineEntity.setMaxPrice(kLineBean.getHigh());
                    lineEntity.setMinPrice(kLineBean.getLow());
                    lineEntity.setVolume(kLineBean.getVol());
                    kLineEntities.add(lineEntity);
                    if (i == kLineDatas.size() - 1) {
                        this.lastKline.setTime(Long.parseLong(kLineBean.getDate()));
                        this.lastKline.setOpenPrice(kLineBean.getOpen());
                        this.lastKline.setClosePrice(kLineBean.getClose());
                        this.lastKline.setMaxPrice(kLineBean.getHigh());
                        this.lastKline.setMinPrice(kLineBean.getLow());
                        this.lastKline.setVolume(kLineBean.getVol());
                    }
                }

                WonderfulLogUtils.logi("miao", kLineDatas.get(0).getClose() + "--" + kLineDatas.get(0).getHigh() + "--" + kLineDatas.get(0).getLow() + "--" + kLineDatas.get(0).getOpen() + "--" + kLineDatas.get(0).getVol());
                WonderfulLogUtils.logi("miao", kLineEntities.size() + "--");
                if (klineView.getTotalDataList().size() != 0) {
                    klineView.resetDataList(kLineEntities);
                } else {
                    klineView.initKDataList(kLineEntities);
                }
            } else {
                klineView.setVisibility(View.INVISIBLE);
            }

            klineView.setOnRequestDataListListener(new KLineView.OnRequestDataListListener() {
                @Override
                public void requestData() {
                    to = from;
                    switch (type) {
                        case GlobalConstant.TAG_DIVIDE_TIME:
                            Calendar c = Calendar.getInstance();
                            int hour = c.get(Calendar.HOUR_OF_DAY) - 1;
                            c.set(Calendar.HOUR_OF_DAY, hour);
                            String strDate = WonderfulDateUtils.getFormatTime("HH:mm", c.getTime());
                            startDate = WonderfulDateUtils.getDateTransformString(strDate, "HH:mm");
                            resolution = 1 + "";
                            String str = WonderfulDateUtils.getFormatTime(null, c.getTime());
                            from = WonderfulDateUtils.getTimeMillis(null, str);
                            klineView.setTime_Type(GlobalConstant.TAG_DIVIDE_TIME);
                            break;
                        case GlobalConstant.TAG_ONE_MINUTE:
                            from = to - 24L * 60 * 60 * 1000;//前一天数据
                            resolution = 1 + "";
                            klineView.setTime_Type(GlobalConstant.TAG_ONE_MINUTE);
                            break;
                        case GlobalConstant.TAG_FIVE_MINUTE:
                            from = to - 2 * 24L * 60 * 60 * 1000;//前两天数据
                            resolution = 5 + "";
                            klineView.setTime_Type(GlobalConstant.TAG_FIVE_MINUTE);
                            break;
                        case GlobalConstant.TAG_THIRTY_MINUTE:
                            from = to - 12 * 24L * 60 * 60 * 1000; //前12天数据
                            resolution = 30 + "";
                            klineView.setTime_Type(GlobalConstant.TAG_THIRTY_MINUTE);
                            break;
                        case GlobalConstant.TAG_AN_HOUR:
                            from = to - 24 * 24L * 60 * 60 * 1000;//前 24天数据
                            resolution = 60 + "";
                            klineView.setTime_Type(GlobalConstant.TAG_AN_HOUR);
                            break;
                        case GlobalConstant.TAG_DAY:
                            from = to - 60 * 24L * 60 * 60 * 1000; //前60天数据
                            resolution = 1 + "D";
                            klineView.setTime_Type(GlobalConstant.TAG_DAY);
                            break;
                        case GlobalConstant.TAG_WEEK:
                            from = to - 730 * 24L * 60 * 60 * 1000; //前两年数据
                            resolution = 1 + "W";
                            klineView.setTime_Type(GlobalConstant.TAG_WEEK);
                            break;
                        case GlobalConstant.TAG_MONTH:
                            from = to - 1095 * 24L * 60 * 60 * 1000; //前三年数据
                            resolution = 1 + "M";
                            klineView.setTime_Type(GlobalConstant.TAG_MONTH);
                            break;
                        default:
                    }
                    mPresenter.KData_Constract(optionBean.getSymbol(), from, to, resolution, "2");
                }
            });
        } catch (Exception e) {
//            WonderfulToastUtils.showToast(getString(R.string.parse_error));
        }
    }

    @Override
    public void KDataSuccess2(JSONArray obj) {
        WonderfulLogUtils.logi(TAG, "KDataSuccess2 type==" + type);
        DataParse kData = new DataParse();
        try {
            kData.parseKLine(obj, type);
            kLineDatas = kData.getKLineDatas();
            if (kLineDatas != null && kLineDatas.size() > 0) {
                kLineEntities = new ArrayList<>();
                kLineEntities.clear();
                for (int i = 0; i < kLineDatas.size(); i++) {
                    KData lineEntity = new KData();
                    KLineBean kLineBean = kLineDatas.get(i);
                    lineEntity.setTime(Long.parseLong(kLineBean.getDate()));
                    lineEntity.setOpenPrice(kLineBean.getOpen());
                    lineEntity.setClosePrice(kLineBean.getClose());
                    lineEntity.setMaxPrice(kLineBean.getHigh());
                    lineEntity.setMinPrice(kLineBean.getLow());
                    lineEntity.setVolume(kLineBean.getVol());
                    kLineEntities.add(lineEntity);
                }
                WonderfulLogUtils.logi("miao", kLineDatas.get(0).getClose() + "--" + kLineDatas.get(0).getHigh() + "--" + kLineDatas.get(0).getLow() + "--" + kLineDatas.get(0).getOpen() + "--" + kLineDatas.get(0).getVol());
                WonderfulLogUtils.logi("miao", kLineEntities.size() + "--");
                klineView.addPreDataList(kLineEntities, true);
            } else {
            }
        } catch (Exception e) {
            WonderfulToastUtils.showToast(getString(R.string.parse_error));
        }
    }

    @Override
    public void KDataFail(Integer code, String toastMessage) {

    }

    @Override
    public void allCurrencyFail(Integer code, String toastMessage) {

    }

    @Override
    public void allCurrencySuccess(List<Currency> obj) {

    }

    private String processAmount(Double d, String s) {
        BigDecimal bg = new BigDecimal(d);
        String v1 = "0.00";
        if (s.equals("2")) {
            v1 = bg.setScale(2, BigDecimal.ROUND_DOWN).stripTrailingZeros().toPlainString();
        }
        return v1;
    }

    public String getPoint(double data) {
        String format = new DecimalFormat("#").format(data);
        BigDecimal bg = new BigDecimal(format);
        String s = bg.setScale(0, BigDecimal.ROUND_DOWN).toPlainString();
        return s;
    }

    @Override
    public void setPresenter(KlineContract.Presenter presenter) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        WonderfulLogUtils.logi(OptionViewModel.Companion.getTAG(), "onActivityResult RESULT_CODE=" + resultCode);
        if (resultCode == OrderConfirmActivityKt.RESULT_CODE) {
            viewModel.getSecondOptionCurrent(optionBean.getSymbol());
            viewModel.getSecondOptionHistory(optionBean.getSymbol(), "0", "40000");
        }
    }
}