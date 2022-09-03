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

public final class AdapterCtcorderBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView ctcAmount;

  @NonNull
  public final TextView ctcCreatetime;

  @NonNull
  public final TextView ctcDirection;

  @NonNull
  public final TextView ctcMoney;

  @NonNull
  public final TextView ctcOrdersn;

  @NonNull
  public final TextView ctcPrice;

  @NonNull
  public final TextView ctcStatus;

  @NonNull
  public final TextView ctcStatusdetail;

  private AdapterCtcorderBinding(@NonNull LinearLayout rootView, @NonNull TextView ctcAmount,
      @NonNull TextView ctcCreatetime, @NonNull TextView ctcDirection, @NonNull TextView ctcMoney,
      @NonNull TextView ctcOrdersn, @NonNull TextView ctcPrice, @NonNull TextView ctcStatus,
      @NonNull TextView ctcStatusdetail) {
    this.rootView = rootView;
    this.ctcAmount = ctcAmount;
    this.ctcCreatetime = ctcCreatetime;
    this.ctcDirection = ctcDirection;
    this.ctcMoney = ctcMoney;
    this.ctcOrdersn = ctcOrdersn;
    this.ctcPrice = ctcPrice;
    this.ctcStatus = ctcStatus;
    this.ctcStatusdetail = ctcStatusdetail;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterCtcorderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterCtcorderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter_ctcorder, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterCtcorderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView ctcAmount = rootView.findViewById(R.id.ctc_amount);
      if (ctcAmount == null) {
        missingId = "ctcAmount";
        break missingId;
      }
      TextView ctcCreatetime = rootView.findViewById(R.id.ctc_createtime);
      if (ctcCreatetime == null) {
        missingId = "ctcCreatetime";
        break missingId;
      }
      TextView ctcDirection = rootView.findViewById(R.id.ctc_direction);
      if (ctcDirection == null) {
        missingId = "ctcDirection";
        break missingId;
      }
      TextView ctcMoney = rootView.findViewById(R.id.ctc_money);
      if (ctcMoney == null) {
        missingId = "ctcMoney";
        break missingId;
      }
      TextView ctcOrdersn = rootView.findViewById(R.id.ctc_ordersn);
      if (ctcOrdersn == null) {
        missingId = "ctcOrdersn";
        break missingId;
      }
      TextView ctcPrice = rootView.findViewById(R.id.ctc_price);
      if (ctcPrice == null) {
        missingId = "ctcPrice";
        break missingId;
      }
      TextView ctcStatus = rootView.findViewById(R.id.ctc_status);
      if (ctcStatus == null) {
        missingId = "ctcStatus";
        break missingId;
      }
      TextView ctcStatusdetail = rootView.findViewById(R.id.ctc_statusdetail);
      if (ctcStatusdetail == null) {
        missingId = "ctcStatusdetail";
        break missingId;
      }
      return new AdapterCtcorderBinding((LinearLayout) rootView, ctcAmount, ctcCreatetime,
          ctcDirection, ctcMoney, ctcOrdersn, ctcPrice, ctcStatus, ctcStatusdetail);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
