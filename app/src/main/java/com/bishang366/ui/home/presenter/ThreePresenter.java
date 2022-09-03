package com.bishang366.ui.home.presenter;

import com.bishang366.ui.home.MainContract;
import com.bishang366.data.DataSource;

/**
 * Created by Administrator on 2018/2/24.
 */

public class ThreePresenter implements MainContract.ThreePresenter {
    private MainContract.ThreeView view;
    private DataSource dataRepository;

    public ThreePresenter(DataSource dataRepository, MainContract.ThreeView view) {
        this.view = view;
        this.dataRepository = dataRepository;
        this.view.setPresenter(this);
    }

}
