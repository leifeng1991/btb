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

public final class ActivityEditAccountPwdBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etLoginPwd;

  @NonNull
  public final EditText etOld;

  @NonNull
  public final EditText etRepeate;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final EditText sellPrice;

  @NonNull
  public final TextView tvEdit;

  @NonNull
  public final TextView tvForgot;

  @NonNull
  public final View viewBack;

  @NonNull
  public final ImageView yan;

  @NonNull
  public final ImageView yan1;

  @NonNull
  public final ImageView yan2;

  private ActivityEditAccountPwdBinding(@NonNull LinearLayout rootView,
      @NonNull EditText etLoginPwd, @NonNull EditText etOld, @NonNull EditText etRepeate,
      @NonNull ImageButton ibBack, @NonNull LinearLayout llTitle, @NonNull EditText sellPrice,
      @NonNull TextView tvEdit, @NonNull TextView tvForgot, @NonNull View viewBack,
      @NonNull ImageView yan, @NonNull ImageView yan1, @NonNull ImageView yan2) {
    this.rootView = rootView;
    this.etLoginPwd = etLoginPwd;
    this.etOld = etOld;
    this.etRepeate = etRepeate;
    this.ibBack = ibBack;
    this.llTitle = llTitle;
    this.sellPrice = sellPrice;
    this.tvEdit = tvEdit;
    this.tvForgot = tvForgot;
    this.viewBack = viewBack;
    this.yan = yan;
    this.yan1 = yan1;
    this.yan2 = yan2;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditAccountPwdBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditAccountPwdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_account_pwd, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditAccountPwdBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etLoginPwd = rootView.findViewById(R.id.etLoginPwd);
      if (etLoginPwd == null) {
        missingId = "etLoginPwd";
        break missingId;
      }
      EditText etOld = rootView.findViewById(R.id.etOld);
      if (etOld == null) {
        missingId = "etOld";
        break missingId;
      }
      EditText etRepeate = rootView.findViewById(R.id.etRepeate);
      if (etRepeate == null) {
        missingId = "etRepeate";
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
      EditText sellPrice = rootView.findViewById(R.id.sellPrice);
      if (sellPrice == null) {
        missingId = "sellPrice";
        break missingId;
      }
      TextView tvEdit = rootView.findViewById(R.id.tvEdit);
      if (tvEdit == null) {
        missingId = "tvEdit";
        break missingId;
      }
      TextView tvForgot = rootView.findViewById(R.id.tvForgot);
      if (tvForgot == null) {
        missingId = "tvForgot";
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
      ImageView yan2 = rootView.findViewById(R.id.yan2);
      if (yan2 == null) {
        missingId = "yan2";
        break missingId;
      }
      return new ActivityEditAccountPwdBinding((LinearLayout) rootView, etLoginPwd, etOld,
          etRepeate, ibBack, llTitle, sellPrice, tvEdit, tvForgot, viewBack, yan, yan1, yan2);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
