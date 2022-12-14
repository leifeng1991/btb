// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import com.bishang366.customview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityC2CbuyBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etLocalCoin;

  @NonNull
  public final EditText etOtherCoin;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final CircleImageView ivHeader;

  @NonNull
  public final ImageView ivUnionPay;

  @NonNull
  public final ImageView ivWeChat;

  @NonNull
  public final ImageView ivZhifubao;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView tvBuy;

  @NonNull
  public final TextView tvCommentPercent;

  @NonNull
  public final TextView tvDoneHistory;

  @NonNull
  public final TextView tvExchangeCount;

  @NonNull
  public final TextView tvInfo;

  @NonNull
  public final TextView tvLimit;

  @NonNull
  public final TextView tvLocalCoinText;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvMyOrder;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvOtherCoinText;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvRemainAmount;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvTradeAmount;

  @NonNull
  public final View viewBack;

  private ActivityC2CbuyBinding(@NonNull LinearLayout rootView, @NonNull EditText etLocalCoin,
      @NonNull EditText etOtherCoin, @NonNull ImageButton ibBack, @NonNull CircleImageView ivHeader,
      @NonNull ImageView ivUnionPay, @NonNull ImageView ivWeChat, @NonNull ImageView ivZhifubao,
      @NonNull LinearLayout llTitle, @NonNull TextView tvBuy, @NonNull TextView tvCommentPercent,
      @NonNull TextView tvDoneHistory, @NonNull TextView tvExchangeCount, @NonNull TextView tvInfo,
      @NonNull TextView tvLimit, @NonNull TextView tvLocalCoinText, @NonNull TextView tvMessage,
      @NonNull TextView tvMyOrder, @NonNull TextView tvName, @NonNull TextView tvOtherCoinText,
      @NonNull TextView tvPrice, @NonNull TextView tvRemainAmount, @NonNull TextView tvTitle,
      @NonNull TextView tvTradeAmount, @NonNull View viewBack) {
    this.rootView = rootView;
    this.etLocalCoin = etLocalCoin;
    this.etOtherCoin = etOtherCoin;
    this.ibBack = ibBack;
    this.ivHeader = ivHeader;
    this.ivUnionPay = ivUnionPay;
    this.ivWeChat = ivWeChat;
    this.ivZhifubao = ivZhifubao;
    this.llTitle = llTitle;
    this.tvBuy = tvBuy;
    this.tvCommentPercent = tvCommentPercent;
    this.tvDoneHistory = tvDoneHistory;
    this.tvExchangeCount = tvExchangeCount;
    this.tvInfo = tvInfo;
    this.tvLimit = tvLimit;
    this.tvLocalCoinText = tvLocalCoinText;
    this.tvMessage = tvMessage;
    this.tvMyOrder = tvMyOrder;
    this.tvName = tvName;
    this.tvOtherCoinText = tvOtherCoinText;
    this.tvPrice = tvPrice;
    this.tvRemainAmount = tvRemainAmount;
    this.tvTitle = tvTitle;
    this.tvTradeAmount = tvTradeAmount;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityC2CbuyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityC2CbuyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_c2_cbuy, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityC2CbuyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etLocalCoin = rootView.findViewById(R.id.etLocalCoin);
      if (etLocalCoin == null) {
        missingId = "etLocalCoin";
        break missingId;
      }
      EditText etOtherCoin = rootView.findViewById(R.id.etOtherCoin);
      if (etOtherCoin == null) {
        missingId = "etOtherCoin";
        break missingId;
      }
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      CircleImageView ivHeader = rootView.findViewById(R.id.ivHeader);
      if (ivHeader == null) {
        missingId = "ivHeader";
        break missingId;
      }
      ImageView ivUnionPay = rootView.findViewById(R.id.ivUnionPay);
      if (ivUnionPay == null) {
        missingId = "ivUnionPay";
        break missingId;
      }
      ImageView ivWeChat = rootView.findViewById(R.id.ivWeChat);
      if (ivWeChat == null) {
        missingId = "ivWeChat";
        break missingId;
      }
      ImageView ivZhifubao = rootView.findViewById(R.id.ivZhifubao);
      if (ivZhifubao == null) {
        missingId = "ivZhifubao";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      TextView tvBuy = rootView.findViewById(R.id.tvBuy);
      if (tvBuy == null) {
        missingId = "tvBuy";
        break missingId;
      }
      TextView tvCommentPercent = rootView.findViewById(R.id.tvCommentPercent);
      if (tvCommentPercent == null) {
        missingId = "tvCommentPercent";
        break missingId;
      }
      TextView tvDoneHistory = rootView.findViewById(R.id.tvDoneHistory);
      if (tvDoneHistory == null) {
        missingId = "tvDoneHistory";
        break missingId;
      }
      TextView tvExchangeCount = rootView.findViewById(R.id.tvExchangeCount);
      if (tvExchangeCount == null) {
        missingId = "tvExchangeCount";
        break missingId;
      }
      TextView tvInfo = rootView.findViewById(R.id.tvInfo);
      if (tvInfo == null) {
        missingId = "tvInfo";
        break missingId;
      }
      TextView tvLimit = rootView.findViewById(R.id.tvLimit);
      if (tvLimit == null) {
        missingId = "tvLimit";
        break missingId;
      }
      TextView tvLocalCoinText = rootView.findViewById(R.id.tvLocalCoinText);
      if (tvLocalCoinText == null) {
        missingId = "tvLocalCoinText";
        break missingId;
      }
      TextView tvMessage = rootView.findViewById(R.id.tvMessage);
      if (tvMessage == null) {
        missingId = "tvMessage";
        break missingId;
      }
      TextView tvMyOrder = rootView.findViewById(R.id.tvMyOrder);
      if (tvMyOrder == null) {
        missingId = "tvMyOrder";
        break missingId;
      }
      TextView tvName = rootView.findViewById(R.id.tvName);
      if (tvName == null) {
        missingId = "tvName";
        break missingId;
      }
      TextView tvOtherCoinText = rootView.findViewById(R.id.tvOtherCoinText);
      if (tvOtherCoinText == null) {
        missingId = "tvOtherCoinText";
        break missingId;
      }
      TextView tvPrice = rootView.findViewById(R.id.tvPrice);
      if (tvPrice == null) {
        missingId = "tvPrice";
        break missingId;
      }
      TextView tvRemainAmount = rootView.findViewById(R.id.tvRemainAmount);
      if (tvRemainAmount == null) {
        missingId = "tvRemainAmount";
        break missingId;
      }
      TextView tvTitle = rootView.findViewById(R.id.tvTitle);
      if (tvTitle == null) {
        missingId = "tvTitle";
        break missingId;
      }
      TextView tvTradeAmount = rootView.findViewById(R.id.tvTradeAmount);
      if (tvTradeAmount == null) {
        missingId = "tvTradeAmount";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityC2CbuyBinding((LinearLayout) rootView, etLocalCoin, etOtherCoin, ibBack,
          ivHeader, ivUnionPay, ivWeChat, ivZhifubao, llTitle, tvBuy, tvCommentPercent,
          tvDoneHistory, tvExchangeCount, tvInfo, tvLimit, tvLocalCoinText, tvMessage, tvMyOrder,
          tvName, tvOtherCoinText, tvPrice, tvRemainAmount, tvTitle, tvTradeAmount, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
