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

public final class ActivityCreditBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivHold;

  @NonNull
  public final ImageView ivIdFace;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView textShili;

  @NonNull
  public final TextView tvSave;

  @NonNull
  public final View viewBack;

  private ActivityCreditBinding(@NonNull LinearLayout rootView, @NonNull ImageButton ibBack,
      @NonNull ImageView ivBack, @NonNull ImageView ivHold, @NonNull ImageView ivIdFace,
      @NonNull LinearLayout llTitle, @NonNull TextView textShili, @NonNull TextView tvSave,
      @NonNull View viewBack) {
    this.rootView = rootView;
    this.ibBack = ibBack;
    this.ivBack = ivBack;
    this.ivHold = ivHold;
    this.ivIdFace = ivIdFace;
    this.llTitle = llTitle;
    this.textShili = textShili;
    this.tvSave = tvSave;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreditBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreditBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_credit, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreditBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      ImageView ivBack = rootView.findViewById(R.id.ivBack);
      if (ivBack == null) {
        missingId = "ivBack";
        break missingId;
      }
      ImageView ivHold = rootView.findViewById(R.id.ivHold);
      if (ivHold == null) {
        missingId = "ivHold";
        break missingId;
      }
      ImageView ivIdFace = rootView.findViewById(R.id.ivIdFace);
      if (ivIdFace == null) {
        missingId = "ivIdFace";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      TextView textShili = rootView.findViewById(R.id.text_shili);
      if (textShili == null) {
        missingId = "textShili";
        break missingId;
      }
      TextView tvSave = rootView.findViewById(R.id.tv_save);
      if (tvSave == null) {
        missingId = "tvSave";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityCreditBinding((LinearLayout) rootView, ibBack, ivBack, ivHold, ivIdFace,
          llTitle, textShili, tvSave, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
