// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogFragmentExchangeBbBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final LinearLayout ll2;

  @NonNull
  public final LinearLayout rlContent;

  @NonNull
  public final TextView tvAmount;

  @NonNull
  public final TextView tvCancle;

  @NonNull
  public final TextView tvConfirm;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvTotal;

  @NonNull
  public final TextView tvType;

  private DialogFragmentExchangeBbBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout ll1,
      @NonNull LinearLayout ll2, @NonNull LinearLayout rlContent, @NonNull TextView tvAmount,
      @NonNull TextView tvCancle, @NonNull TextView tvConfirm, @NonNull TextView tvPrice,
      @NonNull TextView tvTitle, @NonNull TextView tvTotal, @NonNull TextView tvType) {
    this.rootView = rootView;
    this.ll1 = ll1;
    this.ll2 = ll2;
    this.rlContent = rlContent;
    this.tvAmount = tvAmount;
    this.tvCancle = tvCancle;
    this.tvConfirm = tvConfirm;
    this.tvPrice = tvPrice;
    this.tvTitle = tvTitle;
    this.tvTotal = tvTotal;
    this.tvType = tvType;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogFragmentExchangeBbBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogFragmentExchangeBbBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_fragment_exchange_bb, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogFragmentExchangeBbBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      LinearLayout ll1 = rootView.findViewById(R.id.ll1);
      if (ll1 == null) {
        missingId = "ll1";
        break missingId;
      }
      LinearLayout ll2 = rootView.findViewById(R.id.ll2);
      if (ll2 == null) {
        missingId = "ll2";
        break missingId;
      }
      LinearLayout rlContent = rootView.findViewById(R.id.rlContent);
      if (rlContent == null) {
        missingId = "rlContent";
        break missingId;
      }
      TextView tvAmount = rootView.findViewById(R.id.tvAmount);
      if (tvAmount == null) {
        missingId = "tvAmount";
        break missingId;
      }
      TextView tvCancle = rootView.findViewById(R.id.tvCancle);
      if (tvCancle == null) {
        missingId = "tvCancle";
        break missingId;
      }
      TextView tvConfirm = rootView.findViewById(R.id.tvConfirm);
      if (tvConfirm == null) {
        missingId = "tvConfirm";
        break missingId;
      }
      TextView tvPrice = rootView.findViewById(R.id.tvPrice);
      if (tvPrice == null) {
        missingId = "tvPrice";
        break missingId;
      }
      TextView tvTitle = rootView.findViewById(R.id.tvTitle);
      if (tvTitle == null) {
        missingId = "tvTitle";
        break missingId;
      }
      TextView tvTotal = rootView.findViewById(R.id.tvTotal);
      if (tvTotal == null) {
        missingId = "tvTotal";
        break missingId;
      }
      TextView tvType = rootView.findViewById(R.id.tvType);
      if (tvType == null) {
        missingId = "tvType";
        break missingId;
      }
      return new DialogFragmentExchangeBbBinding((LinearLayout) rootView, ll1, ll2, rlContent,
          tvAmount, tvCancle, tvConfirm, tvPrice, tvTitle, tvTotal, tvType);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}