// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PopSevenIconBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buClose;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final LinearLayout ll11;

  @NonNull
  public final LinearLayout ll2;

  @NonNull
  public final LinearLayout ll22;

  @NonNull
  public final LinearLayout mOneXian;

  @NonNull
  public final TextView tvCloseTime;

  @NonNull
  public final TextView tvDown;

  @NonNull
  public final TextView tvOpenPrice;

  @NonNull
  public final TextView tvOpenTime;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvUp;

  @NonNull
  public final TextView tvclosePrice;

  private PopSevenIconBinding(@NonNull LinearLayout rootView, @NonNull Button buClose,
      @NonNull LinearLayout ll1, @NonNull LinearLayout ll11, @NonNull LinearLayout ll2,
      @NonNull LinearLayout ll22, @NonNull LinearLayout mOneXian, @NonNull TextView tvCloseTime,
      @NonNull TextView tvDown, @NonNull TextView tvOpenPrice, @NonNull TextView tvOpenTime,
      @NonNull TextView tvTitle, @NonNull TextView tvUp, @NonNull TextView tvclosePrice) {
    this.rootView = rootView;
    this.buClose = buClose;
    this.ll1 = ll1;
    this.ll11 = ll11;
    this.ll2 = ll2;
    this.ll22 = ll22;
    this.mOneXian = mOneXian;
    this.tvCloseTime = tvCloseTime;
    this.tvDown = tvDown;
    this.tvOpenPrice = tvOpenPrice;
    this.tvOpenTime = tvOpenTime;
    this.tvTitle = tvTitle;
    this.tvUp = tvUp;
    this.tvclosePrice = tvclosePrice;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PopSevenIconBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PopSevenIconBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pop_seven_icon, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PopSevenIconBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      Button buClose = rootView.findViewById(R.id.bu_close);
      if (buClose == null) {
        missingId = "buClose";
        break missingId;
      }
      LinearLayout ll1 = rootView.findViewById(R.id.ll1);
      if (ll1 == null) {
        missingId = "ll1";
        break missingId;
      }
      LinearLayout ll11 = rootView.findViewById(R.id.ll11);
      if (ll11 == null) {
        missingId = "ll11";
        break missingId;
      }
      LinearLayout ll2 = rootView.findViewById(R.id.ll2);
      if (ll2 == null) {
        missingId = "ll2";
        break missingId;
      }
      LinearLayout ll22 = rootView.findViewById(R.id.ll22);
      if (ll22 == null) {
        missingId = "ll22";
        break missingId;
      }
      LinearLayout mOneXian = rootView.findViewById(R.id.mOneXian);
      if (mOneXian == null) {
        missingId = "mOneXian";
        break missingId;
      }
      TextView tvCloseTime = rootView.findViewById(R.id.tv_close_time);
      if (tvCloseTime == null) {
        missingId = "tvCloseTime";
        break missingId;
      }
      TextView tvDown = rootView.findViewById(R.id.tv_down);
      if (tvDown == null) {
        missingId = "tvDown";
        break missingId;
      }
      TextView tvOpenPrice = rootView.findViewById(R.id.tv_open_price);
      if (tvOpenPrice == null) {
        missingId = "tvOpenPrice";
        break missingId;
      }
      TextView tvOpenTime = rootView.findViewById(R.id.tv_open_time);
      if (tvOpenTime == null) {
        missingId = "tvOpenTime";
        break missingId;
      }
      TextView tvTitle = rootView.findViewById(R.id.tv_title);
      if (tvTitle == null) {
        missingId = "tvTitle";
        break missingId;
      }
      TextView tvUp = rootView.findViewById(R.id.tv_up);
      if (tvUp == null) {
        missingId = "tvUp";
        break missingId;
      }
      TextView tvclosePrice = rootView.findViewById(R.id.tvclose_price);
      if (tvclosePrice == null) {
        missingId = "tvclosePrice";
        break missingId;
      }
      return new PopSevenIconBinding((LinearLayout) rootView, buClose, ll1, ll11, ll2, ll22,
          mOneXian, tvCloseTime, tvDown, tvOpenPrice, tvOpenTime, tvTitle, tvUp, tvclosePrice);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
