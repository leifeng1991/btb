// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOrderConfirmBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView balance;

  @NonNull
  public final ImageView btnCancel;

  @NonNull
  public final ConstraintLayout clName;

  @NonNull
  public final TextView countBuy;

  @NonNull
  public final TextView currentPrice;

  @NonNull
  public final TextView currentPriceValue;

  @NonNull
  public final TextView direction;

  @NonNull
  public final TextView directionValue;

  @NonNull
  public final View divider;

  @NonNull
  public final EditText etCount;

  @NonNull
  public final RelativeLayout llRoot;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView nameValue;

  @NonNull
  public final RecyclerView rvTime;

  @NonNull
  public final RecyclerView rvTransferMode;

  @NonNull
  public final TextView sure;

  @NonNull
  public final TextView transferMode;

  @NonNull
  public final TextView useBalance;

  private ActivityOrderConfirmBinding(@NonNull RelativeLayout rootView, @NonNull TextView balance,
      @NonNull ImageView btnCancel, @NonNull ConstraintLayout clName, @NonNull TextView countBuy,
      @NonNull TextView currentPrice, @NonNull TextView currentPriceValue,
      @NonNull TextView direction, @NonNull TextView directionValue, @NonNull View divider,
      @NonNull EditText etCount, @NonNull RelativeLayout llRoot, @NonNull TextView name,
      @NonNull TextView nameValue, @NonNull RecyclerView rvTime,
      @NonNull RecyclerView rvTransferMode, @NonNull TextView sure, @NonNull TextView transferMode,
      @NonNull TextView useBalance) {
    this.rootView = rootView;
    this.balance = balance;
    this.btnCancel = btnCancel;
    this.clName = clName;
    this.countBuy = countBuy;
    this.currentPrice = currentPrice;
    this.currentPriceValue = currentPriceValue;
    this.direction = direction;
    this.directionValue = directionValue;
    this.divider = divider;
    this.etCount = etCount;
    this.llRoot = llRoot;
    this.name = name;
    this.nameValue = nameValue;
    this.rvTime = rvTime;
    this.rvTransferMode = rvTransferMode;
    this.sure = sure;
    this.transferMode = transferMode;
    this.useBalance = useBalance;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOrderConfirmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOrderConfirmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_order_confirm, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOrderConfirmBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView balance = rootView.findViewById(R.id.balance);
      if (balance == null) {
        missingId = "balance";
        break missingId;
      }
      ImageView btnCancel = rootView.findViewById(R.id.btnCancel);
      if (btnCancel == null) {
        missingId = "btnCancel";
        break missingId;
      }
      ConstraintLayout clName = rootView.findViewById(R.id.clName);
      if (clName == null) {
        missingId = "clName";
        break missingId;
      }
      TextView countBuy = rootView.findViewById(R.id.countBuy);
      if (countBuy == null) {
        missingId = "countBuy";
        break missingId;
      }
      TextView currentPrice = rootView.findViewById(R.id.currentPrice);
      if (currentPrice == null) {
        missingId = "currentPrice";
        break missingId;
      }
      TextView currentPriceValue = rootView.findViewById(R.id.currentPriceValue);
      if (currentPriceValue == null) {
        missingId = "currentPriceValue";
        break missingId;
      }
      TextView direction = rootView.findViewById(R.id.direction);
      if (direction == null) {
        missingId = "direction";
        break missingId;
      }
      TextView directionValue = rootView.findViewById(R.id.directionValue);
      if (directionValue == null) {
        missingId = "directionValue";
        break missingId;
      }
      View divider = rootView.findViewById(R.id.divider);
      if (divider == null) {
        missingId = "divider";
        break missingId;
      }
      EditText etCount = rootView.findViewById(R.id.etCount);
      if (etCount == null) {
        missingId = "etCount";
        break missingId;
      }
      RelativeLayout llRoot = rootView.findViewById(R.id.llRoot);
      if (llRoot == null) {
        missingId = "llRoot";
        break missingId;
      }
      TextView name = rootView.findViewById(R.id.name);
      if (name == null) {
        missingId = "name";
        break missingId;
      }
      TextView nameValue = rootView.findViewById(R.id.nameValue);
      if (nameValue == null) {
        missingId = "nameValue";
        break missingId;
      }
      RecyclerView rvTime = rootView.findViewById(R.id.rv_time);
      if (rvTime == null) {
        missingId = "rvTime";
        break missingId;
      }
      RecyclerView rvTransferMode = rootView.findViewById(R.id.rv_transferMode);
      if (rvTransferMode == null) {
        missingId = "rvTransferMode";
        break missingId;
      }
      TextView sure = rootView.findViewById(R.id.sure);
      if (sure == null) {
        missingId = "sure";
        break missingId;
      }
      TextView transferMode = rootView.findViewById(R.id.transferMode);
      if (transferMode == null) {
        missingId = "transferMode";
        break missingId;
      }
      TextView useBalance = rootView.findViewById(R.id.useBalance);
      if (useBalance == null) {
        missingId = "useBalance";
        break missingId;
      }
      return new ActivityOrderConfirmBinding((RelativeLayout) rootView, balance, btnCancel, clName,
          countBuy, currentPrice, currentPriceValue, direction, directionValue, divider, etCount,
          llRoot, name, nameValue, rvTime, rvTransferMode, sure, transferMode, useBalance);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}