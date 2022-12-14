package com.bishang366.ui.wallet;


import com.bishang366.base.Contract;
import com.bishang366.entity.Coin;
import com.bishang366.entity.GccMatch;
import com.bishang366.entity.WalletConstract;

import java.util.List;

/**
 * Created by Administrator on 2017/9/25.
 */

public interface WalletContract {
    interface View extends Contract.BaseView<Presenter> {

        void myWalletSuccess(List<Coin> obj);

        void myWalletFail(Integer code, String toastMessage);

        void getCheckMatchSuccess(GccMatch obj);

        void getCheckMatchFail(Integer code, String toastMessage);

        void getStartMatchSuccess(String obj);

        void getStartMatchFail(Integer code, String toastMessage);

        void myWalletSuccess_Constract(List<WalletConstract> obj);
    }

    interface Presenter extends Contract.BasePresenter {

        void myWallet(String token);

        void getCheckMatch(String token);

        void getStartMatch(String token, String amount);

        void myWallet_Constract(String token);
    }
}
