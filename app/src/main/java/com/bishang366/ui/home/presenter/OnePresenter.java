package com.bishang366.ui.home.presenter;

import com.bishang366.entity.Coin;
import com.bishang366.entity.WalletConstract;
import com.bishang366.ui.home.MainContract;
import com.bishang366.data.DataSource;
import com.bishang366.entity.BannerEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/2/24.
 */

public class OnePresenter implements MainContract.OnePresenter {
    private MainContract.OneView view;
    private DataSource dataRepository;

    public OnePresenter(DataSource dataRepository, MainContract.OneView view) {
        this.view = view;
        this.dataRepository = dataRepository;
        this.view.setPresenter(this);
    }

    @Override
    public void banners(String sysAdvertiseLocation) {
        dataRepository.banners(sysAdvertiseLocation, new DataSource.DataCallback() {
            @Override
            public void onDataLoaded(Object obj) {
                view.hideLoadingPopup();
                view.bannersSuccess((List<BannerEntity>) obj);
            }

            @Override
            public void onDataNotAvailable(Integer code, String toastMessage) {
                view.hideLoadingPopup();
                view.bannersFail(code, toastMessage);
            }
        });
    }

    @Override
    public void myWallet(String token) {
        dataRepository.myWallet(token, new DataSource.DataCallback() {
            @Override
            public void onDataLoaded(Object obj) {
                view.myWalletSuccess((List<Coin>) obj);
            }

            @Override
            public void onDataNotAvailable(Integer code, String toastMessage) {
                view.myWalletFail(code, toastMessage);
            }
        });
    }

    @Override
    public void myWallet_Constract(String token) {
        dataRepository.myWallet_Constract(token, new DataSource.DataCallback() {
            @Override
            public void onDataLoaded(Object obj) {
                view.myWalletSuccess_Constract((List<WalletConstract>) obj);
            }

            @Override
            public void onDataNotAvailable(Integer code, String toastMessage) {
                view.myWalletFail(code, toastMessage);
            }
        });
    }
}
