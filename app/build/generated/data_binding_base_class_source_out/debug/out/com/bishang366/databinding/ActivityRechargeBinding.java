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

public final class ActivityRechargeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final TextView ibRegist;

  @NonNull
  public final ImageView ivAddress;

  @NonNull
  public final LinearLayout layoutMemo;

  @NonNull
  public final LinearLayout llAlbum;

  @NonNull
  public final LinearLayout llCopy;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView textDeposit;

  @NonNull
  public final TextView textMemo;

  @NonNull
  public final TextView tvAddress;

  @NonNull
  public final TextView tvAddressText;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final View viewBack;

  private ActivityRechargeBinding(@NonNull LinearLayout rootView, @NonNull ImageButton ibBack,
      @NonNull TextView ibRegist, @NonNull ImageView ivAddress, @NonNull LinearLayout layoutMemo,
      @NonNull LinearLayout llAlbum, @NonNull LinearLayout llCopy, @NonNull LinearLayout llTitle,
      @NonNull TextView textDeposit, @NonNull TextView textMemo, @NonNull TextView tvAddress,
      @NonNull TextView tvAddressText, @NonNull TextView tvTitle, @NonNull View viewBack) {
    this.rootView = rootView;
    this.ibBack = ibBack;
    this.ibRegist = ibRegist;
    this.ivAddress = ivAddress;
    this.layoutMemo = layoutMemo;
    this.llAlbum = llAlbum;
    this.llCopy = llCopy;
    this.llTitle = llTitle;
    this.textDeposit = textDeposit;
    this.textMemo = textMemo;
    this.tvAddress = tvAddress;
    this.tvAddressText = tvAddressText;
    this.tvTitle = tvTitle;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRechargeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRechargeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_recharge, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRechargeBinding bind(@NonNull View rootView) {
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
      ImageView ivAddress = rootView.findViewById(R.id.ivAddress);
      if (ivAddress == null) {
        missingId = "ivAddress";
        break missingId;
      }
      LinearLayout layoutMemo = rootView.findViewById(R.id.layout_memo);
      if (layoutMemo == null) {
        missingId = "layoutMemo";
        break missingId;
      }
      LinearLayout llAlbum = rootView.findViewById(R.id.llAlbum);
      if (llAlbum == null) {
        missingId = "llAlbum";
        break missingId;
      }
      LinearLayout llCopy = rootView.findViewById(R.id.llCopy);
      if (llCopy == null) {
        missingId = "llCopy";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      TextView textDeposit = rootView.findViewById(R.id.text_deposit);
      if (textDeposit == null) {
        missingId = "textDeposit";
        break missingId;
      }
      TextView textMemo = rootView.findViewById(R.id.text_memo);
      if (textMemo == null) {
        missingId = "textMemo";
        break missingId;
      }
      TextView tvAddress = rootView.findViewById(R.id.tvAddress);
      if (tvAddress == null) {
        missingId = "tvAddress";
        break missingId;
      }
      TextView tvAddressText = rootView.findViewById(R.id.tvAddressText);
      if (tvAddressText == null) {
        missingId = "tvAddressText";
        break missingId;
      }
      TextView tvTitle = rootView.findViewById(R.id.tvTitle);
      if (tvTitle == null) {
        missingId = "tvTitle";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityRechargeBinding((LinearLayout) rootView, ibBack, ibRegist, ivAddress,
          layoutMemo, llAlbum, llCopy, llTitle, textDeposit, textMemo, tvAddress, tvAddressText,
          tvTitle, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
