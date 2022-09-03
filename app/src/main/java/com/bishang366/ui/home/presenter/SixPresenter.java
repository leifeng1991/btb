package com.bishang366.ui.home.presenter;

import com.bishang366.data.DataSource;
import com.bishang366.ui.home.MainContract;

/**
 * Created by Administrator on 2018/2/24.
 */

public class SixPresenter implements MainContract.SixPresenter {
    private MainContract.SixView view;
    private DataSource dataRepository;

    public SixPresenter(DataSource dataRepository, MainContract.SixView view) {
        this.view = view;
        this.dataRepository = dataRepository;
        this.view.setPresenter(this);
    }

}
