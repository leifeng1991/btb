package com.bishang366.ui.entrust;

import android.util.Log;

import com.bishang366.app.GlobalConstant;
import com.bishang366.app.UrlFactory;
import com.bishang366.entity.OptionCurrentInfo;
import com.bishang366.entity.OptionInfo;
import com.bishang366.utils.okhttp.StringCallback;
import com.bishang366.utils.okhttp.WonderfulOkhttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import okhttp3.Request;

public class TrustOptionPresentImpl implements ITrustOption.Presenter {

    private ITrustOption.View view;

    public TrustOptionPresentImpl(ITrustOption.View mView) {
        this.view = mView;
    }

    @Override
    public void getSecondOptionHistory(String symbol, String pageNo, String pageSize) {

        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionHistory())
                .addParams("symbol", symbol)//交易对 例如 BTC/USDT
                .addParams("pageNo", pageNo)// 当前页数
                .addParams("pageSize", pageSize)//每页条数
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject data = new JSONObject(response);
                            Log.e("===", "======getSecondOptionHistory======"+data.toString());

                            if (data.optInt("code") == 0) {
                                OptionInfo obj = new Gson().fromJson(response,new TypeToken<OptionInfo>() {
                                }.getType());
                                view.getHistorySuccess(obj.getContent());
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                            view.errorMes(GlobalConstant.JSON_ERROR, null);
                        }
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        super.onError(request, e);
                        view.errorMes(GlobalConstant.OKHTTP_ERROR, null);
                    }
                });
    }

    @Override
    public void getSecondOptionCurrent(String symbol) {
        WonderfulOkhttpUtils.post().url(UrlFactory.getSecondOptionCurrent())
                .addParams("symbol", symbol)//交易对 例如 BTC/USDT
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject data = new JSONObject(response);
                            Log.e("===", "======getSecondOptionHistory======"+data.toString());
                            if (data.optInt("code") == 0) {
                                OptionCurrentInfo obj = new Gson().fromJson(response, new TypeToken<OptionCurrentInfo>() {
                                }.getType());
                                view.getCurrentSuccess(obj.getContent());
                            }else {
                                view.errorMes(GlobalConstant.OKHTTP_ERROR, null);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            view.errorMes(GlobalConstant.OKHTTP_ERROR, null);
                        }
                    }

                    @Override
                    public void onError(Request request, Exception e) {
                        super.onError(request, e);
                        view.errorMes(GlobalConstant.OKHTTP_ERROR, null);
                    }
                });


    }
}
