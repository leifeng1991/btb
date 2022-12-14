// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOrderDetialBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final TextView ibDetail;

  @NonNull
  public final ImageView imgZhankai;

  @NonNull
  public final ImageView ivWeChatQR;

  @NonNull
  public final ImageView ivZhifubaoQR;

  @NonNull
  public final LinearLayout lineXingming;

  @NonNull
  public final LinearLayout lineZhankai;

  @NonNull
  public final LinearLayout llAppeal;

  @NonNull
  public final LinearLayout llLastTime;

  @NonNull
  public final LinearLayout llOperate;

  @NonNull
  public final LinearLayout llPayInfo;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView tvAppeal;

  @NonNull
  public final TextView tvBank;

  @NonNull
  public final TextView tvBankNo;

  @NonNull
  public final TextView tvBranch;

  @NonNull
  public final TextView tvCancle;

  @NonNull
  public final TextView tvCount;

  @NonNull
  public final TextView tvLastTime;

  @NonNull
  public final TextView tvOrderSn;

  @NonNull
  public final TextView tvOtherSide;

  @NonNull
  public final TextView tvPayDone;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvRelease;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvTime;

  @NonNull
  public final TextView tvTotal;

  @NonNull
  public final TextView tvWeChat;

  @NonNull
  public final TextView tvZhifubao;

  @NonNull
  public final TextView tvrealName;

  @NonNull
  public final View viewBack;

  private ActivityOrderDetialBinding(@NonNull LinearLayout rootView, @NonNull ImageButton ibBack,
      @NonNull TextView ibDetail, @NonNull ImageView imgZhankai, @NonNull ImageView ivWeChatQR,
      @NonNull ImageView ivZhifubaoQR, @NonNull LinearLayout lineXingming,
      @NonNull LinearLayout lineZhankai, @NonNull LinearLayout llAppeal,
      @NonNull LinearLayout llLastTime, @NonNull LinearLayout llOperate,
      @NonNull LinearLayout llPayInfo, @NonNull LinearLayout llTitle, @NonNull TextView tvAppeal,
      @NonNull TextView tvBank, @NonNull TextView tvBankNo, @NonNull TextView tvBranch,
      @NonNull TextView tvCancle, @NonNull TextView tvCount, @NonNull TextView tvLastTime,
      @NonNull TextView tvOrderSn, @NonNull TextView tvOtherSide, @NonNull TextView tvPayDone,
      @NonNull TextView tvPrice, @NonNull TextView tvRelease, @NonNull TextView tvStatus,
      @NonNull TextView tvTime, @NonNull TextView tvTotal, @NonNull TextView tvWeChat,
      @NonNull TextView tvZhifubao, @NonNull TextView tvrealName, @NonNull View viewBack) {
    this.rootView = rootView;
    this.ibBack = ibBack;
    this.ibDetail = ibDetail;
    this.imgZhankai = imgZhankai;
    this.ivWeChatQR = ivWeChatQR;
    this.ivZhifubaoQR = ivZhifubaoQR;
    this.lineXingming = lineXingming;
    this.lineZhankai = lineZhankai;
    this.llAppeal = llAppeal;
    this.llLastTime = llLastTime;
    this.llOperate = llOperate;
    this.llPayInfo = llPayInfo;
    this.llTitle = llTitle;
    this.tvAppeal = tvAppeal;
    this.tvBank = tvBank;
    this.tvBankNo = tvBankNo;
    this.tvBranch = tvBranch;
    this.tvCancle = tvCancle;
    this.tvCount = tvCount;
    this.tvLastTime = tvLastTime;
    this.tvOrderSn = tvOrderSn;
    this.tvOtherSide = tvOtherSide;
    this.tvPayDone = tvPayDone;
    this.tvPrice = tvPrice;
    this.tvRelease = tvRelease;
    this.tvStatus = tvStatus;
    this.tvTime = tvTime;
    this.tvTotal = tvTotal;
    this.tvWeChat = tvWeChat;
    this.tvZhifubao = tvZhifubao;
    this.tvrealName = tvrealName;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOrderDetialBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOrderDetialBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_order_detial, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOrderDetialBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      TextView ibDetail = rootView.findViewById(R.id.ibDetail);
      if (ibDetail == null) {
        missingId = "ibDetail";
        break missingId;
      }
      ImageView imgZhankai = rootView.findViewById(R.id.img_zhankai);
      if (imgZhankai == null) {
        missingId = "imgZhankai";
        break missingId;
      }
      ImageView ivWeChatQR = rootView.findViewById(R.id.ivWeChatQR);
      if (ivWeChatQR == null) {
        missingId = "ivWeChatQR";
        break missingId;
      }
      ImageView ivZhifubaoQR = rootView.findViewById(R.id.ivZhifubaoQR);
      if (ivZhifubaoQR == null) {
        missingId = "ivZhifubaoQR";
        break missingId;
      }
      LinearLayout lineXingming = rootView.findViewById(R.id.line_xingming);
      if (lineXingming == null) {
        missingId = "lineXingming";
        break missingId;
      }
      LinearLayout lineZhankai = rootView.findViewById(R.id.line_zhankai);
      if (lineZhankai == null) {
        missingId = "lineZhankai";
        break missingId;
      }
      LinearLayout llAppeal = rootView.findViewById(R.id.llAppeal);
      if (llAppeal == null) {
        missingId = "llAppeal";
        break missingId;
      }
      LinearLayout llLastTime = rootView.findViewById(R.id.llLastTime);
      if (llLastTime == null) {
        missingId = "llLastTime";
        break missingId;
      }
      LinearLayout llOperate = rootView.findViewById(R.id.llOperate);
      if (llOperate == null) {
        missingId = "llOperate";
        break missingId;
      }
      LinearLayout llPayInfo = rootView.findViewById(R.id.llPayInfo);
      if (llPayInfo == null) {
        missingId = "llPayInfo";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      TextView tvAppeal = rootView.findViewById(R.id.tvAppeal);
      if (tvAppeal == null) {
        missingId = "tvAppeal";
        break missingId;
      }
      TextView tvBank = rootView.findViewById(R.id.tvBank);
      if (tvBank == null) {
        missingId = "tvBank";
        break missingId;
      }
      TextView tvBankNo = rootView.findViewById(R.id.tvBankNo);
      if (tvBankNo == null) {
        missingId = "tvBankNo";
        break missingId;
      }
      TextView tvBranch = rootView.findViewById(R.id.tvBranch);
      if (tvBranch == null) {
        missingId = "tvBranch";
        break missingId;
      }
      TextView tvCancle = rootView.findViewById(R.id.tvCancle);
      if (tvCancle == null) {
        missingId = "tvCancle";
        break missingId;
      }
      TextView tvCount = rootView.findViewById(R.id.tvCount);
      if (tvCount == null) {
        missingId = "tvCount";
        break missingId;
      }
      TextView tvLastTime = rootView.findViewById(R.id.tvLastTime);
      if (tvLastTime == null) {
        missingId = "tvLastTime";
        break missingId;
      }
      TextView tvOrderSn = rootView.findViewById(R.id.tvOrderSn);
      if (tvOrderSn == null) {
        missingId = "tvOrderSn";
        break missingId;
      }
      TextView tvOtherSide = rootView.findViewById(R.id.tvOtherSide);
      if (tvOtherSide == null) {
        missingId = "tvOtherSide";
        break missingId;
      }
      TextView tvPayDone = rootView.findViewById(R.id.tvPayDone);
      if (tvPayDone == null) {
        missingId = "tvPayDone";
        break missingId;
      }
      TextView tvPrice = rootView.findViewById(R.id.tvPrice);
      if (tvPrice == null) {
        missingId = "tvPrice";
        break missingId;
      }
      TextView tvRelease = rootView.findViewById(R.id.tvRelease);
      if (tvRelease == null) {
        missingId = "tvRelease";
        break missingId;
      }
      TextView tvStatus = rootView.findViewById(R.id.tvStatus);
      if (tvStatus == null) {
        missingId = "tvStatus";
        break missingId;
      }
      TextView tvTime = rootView.findViewById(R.id.tvTime);
      if (tvTime == null) {
        missingId = "tvTime";
        break missingId;
      }
      TextView tvTotal = rootView.findViewById(R.id.tvTotal);
      if (tvTotal == null) {
        missingId = "tvTotal";
        break missingId;
      }
      TextView tvWeChat = rootView.findViewById(R.id.tvWeChat);
      if (tvWeChat == null) {
        missingId = "tvWeChat";
        break missingId;
      }
      TextView tvZhifubao = rootView.findViewById(R.id.tvZhifubao);
      if (tvZhifubao == null) {
        missingId = "tvZhifubao";
        break missingId;
      }
      TextView tvrealName = rootView.findViewById(R.id.tvrealName);
      if (tvrealName == null) {
        missingId = "tvrealName";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityOrderDetialBinding((LinearLayout) rootView, ibBack, ibDetail, imgZhankai,
          ivWeChatQR, ivZhifubaoQR, lineXingming, lineZhankai, llAppeal, llLastTime, llOperate,
          llPayInfo, llTitle, tvAppeal, tvBank, tvBankNo, tvBranch, tvCancle, tvCount, tvLastTime,
          tvOrderSn, tvOtherSide, tvPayDone, tvPrice, tvRelease, tvStatus, tvTime, tvTotal,
          tvWeChat, tvZhifubao, tvrealName, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
