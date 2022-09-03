package com.bishang366.ui.entrust;

import com.bishang366.entity.EntrustHistory_constract;
import com.bishang366.entity.OptionDetailInfo;
import com.bishang366.entity.OptionInfo;

import java.util.List;

/**
 * author: wuzongjie
 * time  : 2018/4/18 0018 11:21
 * desc  :
 */

public class ITrustOption {
    interface View {

        void errorMes(int e, String meg);

        void getCurrentSuccess(List<OptionDetailInfo> entrusts);

        void getCancelSuccess(String success);

        void onDataNotAvailable(int code, String message);

        void getHistorySuccess(List<OptionDetailInfo> success);

    }

    interface Presenter {

        void getSecondOptionHistory(String symbol, String pageNo, String pageSize);

        void getSecondOptionCurrent(String symbol);
    }
}
