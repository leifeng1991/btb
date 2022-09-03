// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAppealBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText etRemark;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final TextView ibRegist;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView tvSubmit;

  @NonNull
  public final View viewBack;

  private ActivityAppealBinding(@NonNull RelativeLayout rootView, @NonNull EditText etRemark,
      @NonNull ImageButton ibBack, @NonNull TextView ibRegist, @NonNull LinearLayout llTitle,
      @NonNull TextView tvSubmit, @NonNull View viewBack) {
    this.rootView = rootView;
    this.etRemark = etRemark;
    this.ibBack = ibBack;
    this.ibRegist = ibRegist;
    this.llTitle = llTitle;
    this.tvSubmit = tvSubmit;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAppealBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAppealBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_appeal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAppealBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etRemark = rootView.findViewById(R.id.etRemark);
      if (etRemark == null) {
        missingId = "etRemark";
        break missingId;
      }
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
      TextView tvSubmit = rootView.findViewById(R.id.tvSubmit);
      if (tvSubmit == null) {
        missingId = "tvSubmit";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityAppealBinding((RelativeLayout) rootView, etRemark, ibBack, ibRegist,
          llTitle, tvSubmit, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}