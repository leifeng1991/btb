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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bishang366.R;
import com.xw.repo.BubbleSeekBar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PopSixMultiplesBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buClose;

  @NonNull
  public final Button buTrue;

  @NonNull
  public final BubbleSeekBar mOneSeekBar;

  @NonNull
  public final LinearLayout mOneSeekBarLin;

  @NonNull
  public final RelativeLayout mOneXian;

  @NonNull
  public final TextView tvAdd;

  @NonNull
  public final TextView tvMultiple;

  @NonNull
  public final TextView tvSubtract;

  private PopSixMultiplesBinding(@NonNull LinearLayout rootView, @NonNull Button buClose,
      @NonNull Button buTrue, @NonNull BubbleSeekBar mOneSeekBar,
      @NonNull LinearLayout mOneSeekBarLin, @NonNull RelativeLayout mOneXian,
      @NonNull TextView tvAdd, @NonNull TextView tvMultiple, @NonNull TextView tvSubtract) {
    this.rootView = rootView;
    this.buClose = buClose;
    this.buTrue = buTrue;
    this.mOneSeekBar = mOneSeekBar;
    this.mOneSeekBarLin = mOneSeekBarLin;
    this.mOneXian = mOneXian;
    this.tvAdd = tvAdd;
    this.tvMultiple = tvMultiple;
    this.tvSubtract = tvSubtract;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PopSixMultiplesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PopSixMultiplesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pop_six_multiples, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PopSixMultiplesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      Button buClose = rootView.findViewById(R.id.bu_close);
      if (buClose == null) {
        missingId = "buClose";
        break missingId;
      }
      Button buTrue = rootView.findViewById(R.id.bu_true);
      if (buTrue == null) {
        missingId = "buTrue";
        break missingId;
      }
      BubbleSeekBar mOneSeekBar = rootView.findViewById(R.id.mOneSeekBar);
      if (mOneSeekBar == null) {
        missingId = "mOneSeekBar";
        break missingId;
      }
      LinearLayout mOneSeekBarLin = rootView.findViewById(R.id.mOneSeekBarLin);
      if (mOneSeekBarLin == null) {
        missingId = "mOneSeekBarLin";
        break missingId;
      }
      RelativeLayout mOneXian = rootView.findViewById(R.id.mOneXian);
      if (mOneXian == null) {
        missingId = "mOneXian";
        break missingId;
      }
      TextView tvAdd = rootView.findViewById(R.id.tv_add);
      if (tvAdd == null) {
        missingId = "tvAdd";
        break missingId;
      }
      TextView tvMultiple = rootView.findViewById(R.id.tv_multiple);
      if (tvMultiple == null) {
        missingId = "tvMultiple";
        break missingId;
      }
      TextView tvSubtract = rootView.findViewById(R.id.tv_subtract);
      if (tvSubtract == null) {
        missingId = "tvSubtract";
        break missingId;
      }
      return new PopSixMultiplesBinding((LinearLayout) rootView, buClose, buTrue, mOneSeekBar,
          mOneSeekBarLin, mOneXian, tvAdd, tvMultiple, tvSubtract);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
