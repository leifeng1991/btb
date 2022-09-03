package com.bishang366.ui.aboutus;


import com.bishang366.base.Contract;
import com.bishang366.entity.AppInfo;

/**
 * Created by Administrator on 2017/9/25.
 */

public interface AboutUsContract {

    interface View extends Contract.BaseView<Presenter> {

        void appInfoFail(Integer code, String toastMessage);

        void appInfoSuccess(AppInfo obj);
    }

    interface Presenter extends Contract.BasePresenter {
        void appInfo();
    }
}
