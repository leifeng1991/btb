package com.bishang366.ui.myEntrust;

import com.bishang366.base.Contract;
import com.bishang366.entity.EntrustHistory;
import com.bishang366.entity.MarketSymbol;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public interface MyEntrustContract {

    interface View extends Contract.BaseView<Present>{

        void getEntrustHistoryFail(Integer code, String toastMessage);

        void getEntrustHistorySuccess(List<EntrustHistory> obj);

        void getSymbolSucccess(List<MarketSymbol> objs);

        void getSymbolFailed(Integer code, String toastMessage);

    }

    interface Present extends Contract.BasePresenter{

        void getEntrustHistory(String token,String symbol,int pageNo,int pageSize);

        void getSymbol();

    }
}
