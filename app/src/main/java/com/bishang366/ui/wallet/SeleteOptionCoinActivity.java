package com.bishang366.ui.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.bishang366.R;
import com.bishang366.adapter.SelectOptionCoinsAdapter;
import com.bishang366.app.UrlFactory;
import com.bishang366.base.BaseActivity;
import com.bishang366.utils.WonderfulLogUtils;
import com.bishang366.utils.okhttp.StringCallback;
import com.bishang366.utils.okhttp.WonderfulOkhttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 期权合约账户-选择币种
 */
public class SeleteOptionCoinActivity extends BaseActivity {
    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    @BindView(R.id.rv_coins)
    RecyclerView rvCoins;


    private SelectOptionCoinsAdapter selectOptionCoinsAdapter;
    private List<String> coinList;


    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_select_option_coin;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        coinList = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvCoins.setLayoutManager(manager);
        selectOptionCoinsAdapter = new SelectOptionCoinsAdapter(R.layout.adapter_select_coins, coinList);
        selectOptionCoinsAdapter.isFirstOnly(true);
        selectOptionCoinsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("coinSymbol", coinList.get(position));
                setResult(301, intent);
                finish();
            }
        });
        rvCoins.setAdapter(selectOptionCoinsAdapter);
        getSecondOptionCoins();
    }


    private void getSecondOptionCoins() {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionCoins()).build()
                .execute(new StringCallback() {
                    @Override
                    public void onResponse(String response) {
                        WonderfulLogUtils.logi("@@@", "获取可交易的币种$response=="+response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            int code = jsonObject.optInt("code");
                            if (code==0){
                                coinList.clear();
                                JSONArray jsonArray = jsonObject.optJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    coinList.add(jsonArray.get(i).toString());
                                }
                            }

                            selectOptionCoinsAdapter.notifyDataSetChanged();
                            Log.e("@@@","list===="+coinList.size());
                            Log.e("@@@","listString===="+coinList.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        if (!isSetTitle) {
            ImmersionBar.setTitleBar(this, llTitle);
            isSetTitle = true;
        }
    }

    @OnClick({R.id.ibBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ibBack:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void WalletMessage(String coin) {

    }

}
