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

public final class AdapterCurrentEntrustLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView nowFive;

  @NonNull
  public final TextView nowFour;

  @NonNull
  public final TextView nowOne;

  @NonNull
  public final TextView nowSix;

  @NonNull
  public final TextView nowThree;

  @NonNull
  public final TextView nowTime;

  @NonNull
  public final TextView nowTwo;

  @NonNull
  public final TextView nowType;

  @NonNull
  public final TextView trustBack;

  private AdapterCurrentEntrustLayoutBinding(@NonNull LinearLayout rootView,
      @NonNull TextView nowFive, @NonNull TextView nowFour, @NonNull TextView nowOne,
      @NonNull TextView nowSix, @NonNull TextView nowThree, @NonNull TextView nowTime,
      @NonNull TextView nowTwo, @NonNull TextView nowType, @NonNull TextView trustBack) {
    this.rootView = rootView;
    this.nowFive = nowFive;
    this.nowFour = nowFour;
    this.nowOne = nowOne;
    this.nowSix = nowSix;
    this.nowThree = nowThree;
    this.nowTime = nowTime;
    this.nowTwo = nowTwo;
    this.nowType = nowType;
    this.trustBack = trustBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterCurrentEntrustLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterCurrentEntrustLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter_current_entrust_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterCurrentEntrustLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView nowFive = rootView.findViewById(R.id.now_five);
      if (nowFive == null) {
        missingId = "nowFive";
        break missingId;
      }
      TextView nowFour = rootView.findViewById(R.id.now_four);
      if (nowFour == null) {
        missingId = "nowFour";
        break missingId;
      }
      TextView nowOne = rootView.findViewById(R.id.now_one);
      if (nowOne == null) {
        missingId = "nowOne";
        break missingId;
      }
      TextView nowSix = rootView.findViewById(R.id.now_six);
      if (nowSix == null) {
        missingId = "nowSix";
        break missingId;
      }
      TextView nowThree = rootView.findViewById(R.id.now_three);
      if (nowThree == null) {
        missingId = "nowThree";
        break missingId;
      }
      TextView nowTime = rootView.findViewById(R.id.now_time);
      if (nowTime == null) {
        missingId = "nowTime";
        break missingId;
      }
      TextView nowTwo = rootView.findViewById(R.id.now_two);
      if (nowTwo == null) {
        missingId = "nowTwo";
        break missingId;
      }
      TextView nowType = rootView.findViewById(R.id.now_type);
      if (nowType == null) {
        missingId = "nowType";
        break missingId;
      }
      TextView trustBack = rootView.findViewById(R.id.trust_back);
      if (trustBack == null) {
        missingId = "trustBack";
        break missingId;
      }
      return new AdapterCurrentEntrustLayoutBinding((LinearLayout) rootView, nowFive, nowFour,
          nowOne, nowSix, nowThree, nowTime, nowTwo, nowType, trustBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
