package com.bishang366.ui.home.presenter;

import com.bishang366.ui.home.MainContract;
import com.bishang366.data.DataSource;

/**
 * Created by Administrator on 2018/2/24.
 */

public class TwoPresenter implements MainContract.TwoPresenter {
    private MainContract.TwoView view;
    private DataSource dataRepository;

    public TwoPresenter(DataSource dataRepository, MainContract.TwoView view) {
        this.view = view;
        this.dataRepository = dataRepository;
        this.view.setPresenter(this);
    }


}
