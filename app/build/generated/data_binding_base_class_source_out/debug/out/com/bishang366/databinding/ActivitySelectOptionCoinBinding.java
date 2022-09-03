// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySelectOptionCoinBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final TextView ibRegist;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final RecyclerView rvCoins;

  @NonNull
  public final View viewBack;

  private ActivitySelectOptionCoinBinding(@NonNull LinearLayout rootView,
      @NonNull ImageButton ibBack, @NonNull TextView ibRegist, @NonNull LinearLayout llTitle,
      @NonNull RecyclerView rvCoins, @NonNull View viewBack) {
    this.rootView = rootView;
    this.ibBack = ibBack;
    this.ibRegist = ibRegist;
    this.llTitle = llTitle;
    this.rvCoins = rvCoins;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySelectOptionCoinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySelectOptionCoinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_select_option_coin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySelectOptionCoinBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      TextView ibRegist = rootView.findViewById(R.id.ibRegist);
      if (ibRegist == null) {
        missingId = "ibRegist";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      RecyclerView rvCoins = rootView.findViewById(R.id.rv_coins);
      if (rvCoins == null) {
        missingId = "rvCoins";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivitySelectOptionCoinBinding((LinearLayout) rootView, ibBack, ibRegist, llTitle,
          rvCoins, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
