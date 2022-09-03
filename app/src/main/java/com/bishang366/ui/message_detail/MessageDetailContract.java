package com.bishang366.ui.message_detail;


import com.bishang366.base.Contract;
import com.bishang366.entity.Message;

/**
 * Created by Administrator on 2017/9/25.
 */

public interface MessageDetailContract {
    interface View extends Contract.BaseView<Presenter> {

        void messageDetailSuccess(Message obj);

        void messageDetailFail(Integer code, String toastMessage);
    }

    interface Presenter extends Contract.BasePresenter {

        void messageDetail(String id);
    }
}
