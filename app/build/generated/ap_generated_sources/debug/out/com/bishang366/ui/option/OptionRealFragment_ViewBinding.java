// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.option;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bishang366.R;
import com.bishang366.ui.kline.kline.KLineView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OptionRealFragment_ViewBinding implements Unbinder {
  private OptionRealFragment target;

  @UiThread
  public OptionRealFragment_ViewBinding(OptionRealFragment target, View source) {
    this.target = target;

    target.ibBack = Utils.findRequiredViewAsType(source, R.id.ibBack, "field 'ibBack'", ImageButton.class);
    target.ibOpen = Utils.findRequiredViewAsType(source, R.id.ibOpen, "field 'ibOpen'", ImageButton.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    target.ibMessage = Utils.findRequiredViewAsType(source, R.id.ibMessage, "field 'ibMessage'", ImageView.class);
    target.viewLine = Utils.findRequiredView(source, R.id.view_line, "field 'viewLine'");
    target.llTitle = Utils.findRequiredViewAsType(source, R.id.llTitle, "field 'llTitle'", LinearLayout.class);
    target.tvCurrentTrust = Utils.findRequiredViewAsType(source, R.id.tv_current_trust, "field 'tvCurrentTrust'", TextView.class);
    target.currentTrustUnderline = Utils.findRequiredView(source, R.id.current_trust_underline, "field 'currentTrustUnderline'");
    target.llCurrentTrust = Utils.findRequiredViewAsType(source, R.id.ll_current_trust, "field 'llCurrentTrust'", LinearLayout.class);
    target.tvHistoryTrust = Utils.findRequiredViewAsType(source, R.id.tv_history_trust, "field 'tvHistoryTrust'", TextView.class);
    target.historyTrustUnderline = Utils.findRequiredView(source, R.id.history_trust_underline, "field 'historyTrustUnderline'");
    target.llHistoryTrust = Utils.findRequiredViewAsType(source, R.id.ll_history_trust, "field 'llHistoryTrust'", LinearLayout.class);
    target.textToAll = Utils.findRequiredViewAsType(source, R.id.text_to_all, "field 'textToAll'", RelativeLayout.class);
    target.mTvseven = Utils.findRequiredViewAsType(source, R.id.mTvseven, "field 'mTvseven'", TextView.class);
    target.btnToLogin = Utils.findRequiredViewAsType(source, R.id.btn_toLogin, "field 'btnToLogin'", TextView.class);
    target.smartrefreshLayout = Utils.findRequiredViewAsType(source, R.id.smartrefreshLayout, "field 'smartrefreshLayout'", SmartRefreshLayout.class);
    target.llRoot = Utils.findRequiredViewAsType(source, R.id.llRoot, "field 'llRoot'", RelativeLayout.class);
    target.tabTime = Utils.findRequiredViewAsType(source, R.id.tab_time, "field 'tabTime'", LinearLayout.class);
    target.klineView = Utils.findRequiredViewAsType(source, R.id.kline_view, "field 'klineView'", KLineView.class);
    target.llK = Utils.findRequiredViewAsType(source, R.id.ll_k, "field 'llK'", LinearLayout.class);
    target.tvOpenPrice = Utils.findRequiredViewAsType(source, R.id.tv_open_price, "field 'tvOpenPrice'", TextView.class);
    target.tvNowPrice = Utils.findRequiredViewAsType(source, R.id.tv_now_price, "field 'tvNowPrice'", TextView.class);
    target.tvExpect = Utils.findRequiredViewAsType(source, R.id.tv_expect, "field 'tvExpect'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.tvBuy = Utils.findRequiredViewAsType(source, R.id.tv_buy, "field 'tvBuy'", TextView.class);
    target.tvSell = Utils.findRequiredViewAsType(source, R.id.tv_sell, "field 'tvSell'", TextView.class);
    target.tvAmount = Utils.findRequiredViewAsType(source, R.id.tv_amount, "field 'tvAmount'", TextView.class);
    target.rvAmount = Utils.findRequiredViewAsType(source, R.id.rv_amount, "field 'rvAmount'", RecyclerView.class);
    target.tvUseMoney = Utils.findRequiredViewAsType(source, R.id.tv_use_money, "field 'tvUseMoney'", TextView.class);
    target.buRise = Utils.findRequiredViewAsType(source, R.id.bu_rise, "field 'buRise'", Button.class);
    target.buFall = Utils.findRequiredViewAsType(source, R.id.bu_fall, "field 'buFall'", Button.class);
    target.llHistory = Utils.findRequiredViewAsType(source, R.id.ll_history, "field 'llHistory'", LinearLayout.class);
    target.llCurrent = Utils.findRequiredViewAsType(source, R.id.ll_current, "field 'llCurrent'", LinearLayout.class);
    target.tvExpect2 = Utils.findRequiredViewAsType(source, R.id.tv_expect2, "field 'tvExpect2'", TextView.class);
    target.tvBuy2 = Utils.findRequiredViewAsType(source, R.id.tv_buy2, "field 'tvBuy2'", TextView.class);
    target.tvSell2 = Utils.findRequiredViewAsType(source, R.id.tv_sell2, "field 'tvSell2'", TextView.class);
    target.tvAmount2 = Utils.findRequiredViewAsType(source, R.id.tv_amount2, "field 'tvAmount2'", TextView.class);
    target.seekbar = Utils.findRequiredViewAsType(source, R.id.seekbar, "field 'seekbar'", SeekBar.class);
    target.tvPercent = Utils.findRequiredViewAsType(source, R.id.tv_percent, "field 'tvPercent'", TextView.class);
    target.rvHistory = Utils.findRequiredViewAsType(source, R.id.rv_history, "field 'rvHistory'", RecyclerView.class);
    target.rvCurrent = Utils.findRequiredViewAsType(source, R.id.rv_current, "field 'rvCurrent'", RecyclerView.class);
    target.installments = Utils.findRequiredViewAsType(source, R.id.installments, "field 'installments'", TextView.class);
    target.tvTime2 = Utils.findRequiredViewAsType(source, R.id.tv_time2, "field 'tvTime2'", TextView.class);
    target.nowOne = Utils.findRequiredViewAsType(source, R.id.now_one, "field 'nowOne'", TextView.class);
    target.nowTwo = Utils.findRequiredViewAsType(source, R.id.now_two, "field 'nowTwo'", TextView.class);
    target.nowThree = Utils.findRequiredViewAsType(source, R.id.now_three, "field 'nowThree'", TextView.class);
    target.nowFour = Utils.findRequiredViewAsType(source, R.id.now_four, "field 'nowFour'", TextView.class);
    target.nowFive = Utils.findRequiredViewAsType(source, R.id.now_five, "field 'nowFive'", TextView.class);
    target.nowSix = Utils.findRequiredViewAsType(source, R.id.now_six, "field 'nowSix'", TextView.class);
    target.llOneCurrent = Utils.findRequiredViewAsType(source, R.id.ll_one_current, "field 'llOneCurrent'", LinearLayout.class);
    target.tvTimeCurrent = Utils.findRequiredViewAsType(source, R.id.tv_time_current, "field 'tvTimeCurrent'", TextView.class);
    target.tvCompensation = Utils.findRequiredViewAsType(source, R.id.tv_compensation, "field 'tvCompensation'", TextView.class);

    Context context = source.getContext();
    Resources res = context.getResources();
    target.titles = res.getStringArray(R.array.k_line_tab_option);
  }

  @Override
  @CallSuper
  public void unbind() {
    OptionRealFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ibBack = null;
    target.ibOpen = null;
    target.tvTitle = null;
    target.ibMessage = null;
    target.viewLine = null;
    target.llTitle = null;
    target.tvCurrentTrust = null;
    target.currentTrustUnderline = null;
    target.llCurrentTrust = null;
    target.tvHistoryTrust = null;
    target.historyTrustUnderline = null;
    target.llHistoryTrust = null;
    target.textToAll = null;
    target.mTvseven = null;
    target.btnToLogin = null;
    target.smartrefreshLayout = null;
    target.llRoot = null;
    target.tabTime = null;
    target.klineView = null;
    target.llK = null;
    target.tvOpenPrice = null;
    target.tvNowPrice = null;
    target.tvExpect = null;
    target.tvTime = null;
    target.tvBuy = null;
    target.tvSell = null;
    target.tvAmount = null;
    target.rvAmount = null;
    target.tvUseMoney = null;
    target.buRise = null;
    target.buFall = null;
    target.llHistory = null;
    target.llCurrent = null;
    target.tvExpect2 = null;
    target.tvBuy2 = null;
    target.tvSell2 = null;
    target.tvAmount2 = null;
    target.seekbar = null;
    target.tvPercent = null;
    target.rvHistory = null;
    target.rvCurrent = null;
    target.installments = null;
    target.tvTime2 = null;
    target.nowOne = null;
    target.nowTwo = null;
    target.nowThree = null;
    target.nowFour = null;
    target.nowFive = null;
    target.nowSix = null;
    target.llOneCurrent = null;
    target.tvTimeCurrent = null;
    target.tvCompensation = null;
  }
}
