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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBottomShowBuySellBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView ivBuy;

  @NonNull
  public final ImageView ivSell;

  @NonNull
  public final LinearLayout ll;

  @NonNull
  public final RelativeLayout rlContent;

  @NonNull
  public final TextView tvBuy;

  @NonNull
  public final TextView tvCancle;

  @NonNull
  public final TextView tvSell;

  private FragmentBottomShowBuySellBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView ivBuy, @NonNull ImageView ivSell, @NonNull LinearLayout ll,
      @NonNull RelativeLayout rlContent, @NonNull TextView tvBuy, @NonNull TextView tvCancle,
      @NonNull TextView tvSell) {
    this.rootView = rootView;
    this.ivBuy = ivBuy;
    this.ivSell = ivSell;
    this.ll = ll;
    this.rlContent = rlContent;
    this.tvBuy = tvBuy;
    this.tvCancle = tvCancle;
    this.tvSell = tvSell;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBottomShowBuySellBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBottomShowBuySellBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_bottom_show_buy_sell, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBottomShowBuySellBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      ImageView ivBuy = rootView.findViewById(R.id.ivBuy);
      if (ivBuy == null) {
        missingId = "ivBuy";
        break missingId;
      }
      ImageView ivSell = rootView.findViewById(R.id.ivSell);
      if (ivSell == null) {
        missingId = "ivSell";
        break missingId;
      }
      LinearLayout ll = rootView.findViewById(R.id.ll);
      if (ll == null) {
        missingId = "ll";
        break missingId;
      }
      RelativeLayout rlContent = rootView.findViewById(R.id.rlContent);
      if (rlContent == null) {
        missingId = "rlContent";
        break missingId;
      }
      TextView tvBuy = rootView.findViewById(R.id.tvBuy);
      if (tvBuy == null) {
        missingId = "tvBuy";
        break missingId;
      }
      TextView tvCancle = rootView.findViewById(R.id.tvCancle);
      if (tvCancle == null) {
        missingId = "tvCancle";
        break missingId;
      }
      TextView tvSell = rootView.findViewById(R.id.tvSell);
      if (tvSell == null) {
        missingId = "tvSell";
        break missingId;
      }
      return new FragmentBottomShowBuySellBinding((RelativeLayout) rootView, ivBuy, ivSell, ll,
          rlContent, tvBuy, tvCancle, tvSell);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}