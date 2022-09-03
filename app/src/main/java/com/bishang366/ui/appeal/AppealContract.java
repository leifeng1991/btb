package com.bishang366.ui.appeal;


import com.bishang366.base.Contract;

/**
 * Created by Administrator on 2017/9/25.
 */

public interface AppealContract {
    interface View extends Contract.BaseView<Presenter> {

        void appealSuccess(String obj);

        void appealFail(Integer code, String toastMessage);
    }

    interface Presenter extends Contract.BasePresenter {

        void appeal(String token, String remark, String orderSn);
    }
}
