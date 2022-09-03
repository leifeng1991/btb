// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import com.bishang366.customview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdapterC2cBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CircleImageView ivHeader;

  @NonNull
  public final ImageView ivUnionPay;

  @NonNull
  public final ImageView ivWeChat;

  @NonNull
  public final ImageView ivZhifubao;

  @NonNull
  public final TextView tvBuy;

  @NonNull
  public final TextView tvLimit;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvNumber;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvTradeAmount;

  private AdapterC2cBinding(@NonNull LinearLayout rootView, @NonNull CircleImageView ivHeader,
      @NonNull ImageView ivUnionPay, @NonNull ImageView ivWeChat, @NonNull ImageView ivZhifubao,
      @NonNull TextView tvBuy, @NonNull TextView tvLimit, @NonNull TextView tvName,
      @NonNull TextView tvNumber, @NonNull TextView tvPrice, @NonNull TextView tvTradeAmount) {
    this.rootView = rootView;
    this.ivHeader = ivHeader;
    this.ivUnionPay = ivUnionPay;
    this.ivWeChat = ivWeChat;
    this.ivZhifubao = ivZhifubao;
    this.tvBuy = tvBuy;
    this.tvLimit = tvLimit;
    this.tvName = tvName;
    this.tvNumber = tvNumber;
    this.tvPrice = tvPrice;
    this.tvTradeAmount = tvTradeAmount;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterC2cBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterC2cBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter_c2c, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterC2cBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
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
      TextView tvBuy = rootView.findViewById(R.id.tvBuy);
      if (tvBuy == null) {
        missingId = "tvBuy";
        break missingId;
      }
      TextView tvLimit = rootView.findViewById(R.id.tvLimit);
      if (tvLimit == null) {
        missingId = "tvLimit";
        break missingId;
      }
      TextView tvName = rootView.findViewById(R.id.tvName);
      if (tvName == null) {
        missingId = "tvName";
        break missingId;
      }
      TextView tvNumber = rootView.findViewById(R.id.tvNumber);
      if (tvNumber == null) {
        missingId = "tvNumber";
        break missingId;
      }
      TextView tvPrice = rootView.findViewById(R.id.tvPrice);
      if (tvPrice == null) {
        missingId = "tvPrice";
        break missingId;
      }
      TextView tvTradeAmount = rootView.findViewById(R.id.tvTradeAmount);
      if (tvTradeAmount == null) {
        missingId = "tvTradeAmount";
        break missingId;
      }
      return new AdapterC2cBinding((LinearLayout) rootView, ivHeader, ivUnionPay, ivWeChat,
          ivZhifubao, tvBuy, tvLimit, tvName, tvNumber, tvPrice, tvTradeAmount);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
