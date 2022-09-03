package com.bishang366.ui.login;


import com.bishang366.base.Contract;
import com.bishang366.entity.User;

import org.json.JSONObject;

/**
 * Created by Administrator on 2017/9/25.
 */

public interface LoginContract {
    interface View extends Contract.BaseView<Presenter> {

        void loginFail(Integer code, String toastMessage);

        void loginSuccess(User obj);

        void captchSuccess(JSONObject obj);

        void captchFail(Integer code, String toastMessage);
    }
        
    interface Presenter extends Contract.BasePresenter {
        //void login(String token,String username, String password, String challenge, String validate, String seccode);
        void login(String username, String password, String challenge, String validate, String seccode);

        void captch();
    }
}
