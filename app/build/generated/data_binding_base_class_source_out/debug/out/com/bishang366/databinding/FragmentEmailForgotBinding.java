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

public final class FragmentEmailForgotBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etCode;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final EditText etRePassword;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView tvBack;

  @NonNull
  public final TextView tvChangeType;

  @NonNull
  public final TextView tvGetCode;

  @NonNull
  public final TextView tvSubmit;

  private FragmentEmailForgotBinding(@NonNull LinearLayout rootView, @NonNull EditText etCode,
      @NonNull EditText etEmail, @NonNull EditText etPassword, @NonNull EditText etRePassword,
      @NonNull ImageButton ibBack, @NonNull LinearLayout llTitle, @NonNull TextView tvBack,
      @NonNull TextView tvChangeType, @NonNull TextView tvGetCode, @NonNull TextView tvSubmit) {
    this.rootView = rootView;
    this.etCode = etCode;
    this.etEmail = etEmail;
    this.etPassword = etPassword;
    this.etRePassword = etRePassword;
    this.ibBack = ibBack;
    this.llTitle = llTitle;
    this.tvBack = tvBack;
    this.tvChangeType = tvChangeType;
    this.tvGetCode = tvGetCode;
    this.tvSubmit = tvSubmit;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEmailForgotBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEmailForgotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_email_forgot, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEmailForgotBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etCode = rootView.findViewById(R.id.etCode);
      if (etCode == null) {
        missingId = "etCode";
        break missingId;
      }
      EditText etEmail = rootView.findViewById(R.id.etEmail);
      if (etEmail == null) {
        missingId = "etEmail";
        break missingId;
      }
      EditText etPassword = rootView.findViewById(R.id.etPassword);
      if (etPassword == null) {
        missingId = "etPassword";
        break missingId;
      }
      EditText etRePassword = rootView.findViewById(R.id.etRePassword);
      if (etRePassword == null) {
        missingId = "etRePassword";
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
      TextView tvBack = rootView.findViewById(R.id.tvBack);
      if (tvBack == null) {
        missingId = "tvBack";
        break missingId;
      }
      TextView tvChangeType = rootView.findViewById(R.id.tvChangeType);
      if (tvChangeType == null) {
        missingId = "tvChangeType";
        break missingId;
      }
      TextView tvGetCode = rootView.findViewById(R.id.tvGetCode);
      if (tvGetCode == null) {
        missingId = "tvGetCode";
        break missingId;
      }
      TextView tvSubmit = rootView.findViewById(R.id.tvSubmit);
      if (tvSubmit == null) {
        missingId = "tvSubmit";
        break missingId;
      }
      return new FragmentEmailForgotBinding((LinearLayout) rootView, etCode, etEmail, etPassword,
          etRePassword, ibBack, llTitle, tvBack, tvChangeType, tvGetCode, tvSubmit);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}