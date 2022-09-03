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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAccountPwdBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etAccountPwd;

  @NonNull
  public final EditText etLoginPwd;

  @NonNull
  public final EditText etRepeatPwd;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView tvSet;

  @NonNull
  public final View viewBack;

  @NonNull
  public final ImageView yan;

  @NonNull
  public final ImageView yan1;

  private ActivityAccountPwdBinding(@NonNull LinearLayout rootView, @NonNull EditText etAccountPwd,
      @NonNull EditText etLoginPwd, @NonNull EditText etRepeatPwd, @NonNull ImageButton ibBack,
      @NonNull LinearLayout llTitle, @NonNull TextView tvSet, @NonNull View viewBack,
      @NonNull ImageView yan, @NonNull ImageView yan1) {
    this.rootView = rootView;
    this.etAccountPwd = etAccountPwd;
    this.etLoginPwd = etLoginPwd;
    this.etRepeatPwd = etRepeatPwd;
    this.ibBack = ibBack;
    this.llTitle = llTitle;
    this.tvSet = tvSet;
    this.viewBack = viewBack;
    this.yan = yan;
    this.yan1 = yan1;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAccountPwdBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAccountPwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_account_pwd, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAccountPwdBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etAccountPwd = rootView.findViewById(R.id.etAccountPwd);
      if (etAccountPwd == null) {
        missingId = "etAccountPwd";
        break missingId;
      }
      EditText etLoginPwd = rootView.findViewById(R.id.etLoginPwd);
      if (etLoginPwd == null) {
        missingId = "etLoginPwd";
        break missingId;
      }
      EditText etRepeatPwd = rootView.findViewById(R.id.etRepeatPwd);
      if (etRepeatPwd == null) {
        missingId = "etRepeatPwd";
        break missingId;
      }
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      TextView tvSet = rootView.findViewById(R.id.tvSet);
      if (tvSet == null) {
        missingId = "tvSet";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      ImageView yan = rootView.findViewById(R.id.yan);
      if (yan == null) {
        missingId = "yan";
        break missingId;
      }
      ImageView yan1 = rootView.findViewById(R.id.yan1);
      if (yan1 == null) {
        missingId = "yan1";
        break missingId;
      }
      return new ActivityAccountPwdBinding((LinearLayout) rootView, etAccountPwd, etLoginPwd,
          etRepeatPwd, ibBack, llTitle, tvSet, viewBack, yan, yan1);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
