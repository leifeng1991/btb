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
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBindPhoneBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etCode;

  @NonNull
  public final EditText etPhone;

  @NonNull
  public final EditText etPwd;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final TextView ibRegist;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView tvAreaCode;

  @NonNull
  public final TextView tvBind;

  @NonNull
  public final TextView tvCountry;

  @NonNull
  public final TextView tvSend;

  @NonNull
  public final TextView tvTitle;

  private ActivityBindPhoneBinding(@NonNull LinearLayout rootView, @NonNull EditText etCode,
      @NonNull EditText etPhone, @NonNull EditText etPwd, @NonNull ImageButton ibBack,
      @NonNull TextView ibRegist, @NonNull LinearLayout llTitle, @NonNull TextView tvAreaCode,
      @NonNull TextView tvBind, @NonNull TextView tvCountry, @NonNull TextView tvSend,
      @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.etCode = etCode;
    this.etPhone = etPhone;
    this.etPwd = etPwd;
    this.ibBack = ibBack;
    this.ibRegist = ibRegist;
    this.llTitle = llTitle;
    this.tvAreaCode = tvAreaCode;
    this.tvBind = tvBind;
    this.tvCountry = tvCountry;
    this.tvSend = tvSend;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBindPhoneBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBindPhoneBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bind_phone, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBindPhoneBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etCode = rootView.findViewById(R.id.etCode);
      if (etCode == null) {
        missingId = "etCode";
        break missingId;
      }
      EditText etPhone = rootView.findViewById(R.id.etPhone);
      if (etPhone == null) {
        missingId = "etPhone";
        break missingId;
      }
      EditText etPwd = rootView.findViewById(R.id.etPwd);
      if (etPwd == null) {
        missingId = "etPwd";
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
      TextView tvAreaCode = rootView.findViewById(R.id.tvAreaCode);
      if (tvAreaCode == null) {
        missingId = "tvAreaCode";
        break missingId;
      }
      TextView tvBind = rootView.findViewById(R.id.tvBind);
      if (tvBind == null) {
        missingId = "tvBind";
        break missingId;
      }
      TextView tvCountry = rootView.findViewById(R.id.tvCountry);
      if (tvCountry == null) {
        missingId = "tvCountry";
        break missingId;
      }
      TextView tvSend = rootView.findViewById(R.id.tvSend);
      if (tvSend == null) {
        missingId = "tvSend";
        break missingId;
      }
      TextView tvTitle = rootView.findViewById(R.id.tvTitle);
      if (tvTitle == null) {
        missingId = "tvTitle";
        break missingId;
      }
      return new ActivityBindPhoneBinding((LinearLayout) rootView, etCode, etPhone, etPwd, ibBack,
          ibRegist, llTitle, tvAreaCode, tvBind, tvCountry, tvSend, tvTitle);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
