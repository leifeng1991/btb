// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogJypasswordBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final TextView tvRelease;

  private DialogJypasswordBinding(@NonNull LinearLayout rootView, @NonNull EditText etPassword,
      @NonNull TextView tvRelease) {
    this.rootView = rootView;
    this.etPassword = etPassword;
    this.tvRelease = tvRelease;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogJypasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogJypasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_jypassword, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogJypasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etPassword = rootView.findViewById(R.id.etPassword);
      if (etPassword == null) {
        missingId = "etPassword";
        break missingId;
      }
      TextView tvRelease = rootView.findViewById(R.id.tvRelease);
      if (tvRelease == null) {
        missingId = "tvRelease";
        break missingId;
      }
      return new DialogJypasswordBinding((LinearLayout) rootView, etPassword, tvRelease);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
