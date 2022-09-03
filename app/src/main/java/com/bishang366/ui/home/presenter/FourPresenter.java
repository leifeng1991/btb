package com.bishang366.ui.home.presenter;

import com.bishang366.ui.home.MainContract;
import com.bishang366.data.DataSource;
import com.bishang366.entity.CoinInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/2/24.
 */

public class FourPresenter implements MainContract.FourPresenter {
    private MainContract.FourView view;
    private DataSource dataRepository;

    public FourPresenter(DataSource dataRepository, MainContract.FourView view) {
        this.view = view;
        this.dataRepository = dataRepository;
        this.view.setPresenter(this);
    }

    @Override
    public void all() {
        dataRepository.all(new DataSource.DataCallback() {
            @Override
            public void onDataLoaded(Object obj) {
                view.allSuccess((List<CoinInfo>) obj);
            }

            @Override
            public void onDataNotAvailable(Integer code, String toastMessage) {
                view.allFail(code, toastMessage);
            }
        });
    }
}
