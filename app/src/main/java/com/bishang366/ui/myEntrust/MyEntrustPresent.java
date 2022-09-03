package com.bishang366.ui.myEntrust;

import com.bishang366.data.DataSource;
import com.bishang366.entity.EntrustHistory;
import com.bishang366.entity.MarketSymbol;
import com.bishang366.utils.WonderfulLogUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class MyEntrustPresent implements MyEntrustContract.Present {

    private final DataSource dataRepository;
    private final MyEntrustContract.View view;

    public MyEntrustPresent(DataSource dataRepository, MyEntrustContract.View view) {
        this.dataRepository = dataRepository;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void getEntrustHistory(String token, String symbol,int pageNo, int pageSize) {
        view.displayLoadingPopup();
        dataRepository.getEntrustHistory(token,symbol, pageNo,pageSize,new DataSource.DataCallback() {
            @Override
            public void onDataLoaded(Object obj) {
                view.hideLoadingPopup();
                view.getEntrustHistorySuccess((List<EntrustHistory>) obj);
                WonderfulLogUtils.logi("getEntrustHistory","obj     "+obj.toString());
            }

            @Override
            public void onDataNotAvailable(Integer code, String toastMessage) {
                view.hideLoadingPopup();
                view.getEntrustHistoryFail(code, toastMessage);
            }
        });
    }

    @Override
    public void getSymbol() {
        view.displayLoadingPopup();
        dataRepository.getSymbol(new DataSource.DataCallback() {
            @Override
            public void onDataLoaded(Object obj) {
                view.hideLoadingPopup();
                view.getSymbolSucccess((List<MarketSymbol>) obj);
                WonderfulLogUtils.logi("getMarketSymbol","obj     "+obj);
            }

            @Override
            public void onDataNotAvailable(Integer code, String toastMessage) {
                view.hideLoadingPopup();
                view.getSymbolFailed(code, toastMessage);
            }
        });
    }
}
