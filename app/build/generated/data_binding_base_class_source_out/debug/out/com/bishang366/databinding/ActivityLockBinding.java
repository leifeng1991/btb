// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import com.bishang366.customview.CircleImageView;
import com.bishang366.customview.lock.LockPatternView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLockBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout gestureTipLayout;

  @NonNull
  public final CircleImageView ivHeader;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final LockPatternView lockView;

  @NonNull
  public final TextView tvForgot;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvNickName;

  private ActivityLockBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout gestureTipLayout, @NonNull CircleImageView ivHeader,
      @NonNull LinearLayout llTitle, @NonNull LockPatternView lockView, @NonNull TextView tvForgot,
      @NonNull TextView tvMessage, @NonNull TextView tvNickName) {
    this.rootView = rootView;
    this.gestureTipLayout = gestureTipLayout;
    this.ivHeader = ivHeader;
    this.llTitle = llTitle;
    this.lockView = lockView;
    this.tvForgot = tvForgot;
    this.tvMessage = tvMessage;
    this.tvNickName = tvNickName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLockBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLockBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_lock, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLockBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      LinearLayout gestureTipLayout = rootView.findViewById(R.id.gesture_tip_layout);
      if (gestureTipLayout == null) {
        missingId = "gestureTipLayout";
        break missingId;
      }
      CircleImageView ivHeader = rootView.findViewById(R.id.ivHeader);
      if (ivHeader == null) {
        missingId = "ivHeader";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      LockPatternView lockView = rootView.findViewById(R.id.lockView);
      if (lockView == null) {
        missingId = "lockView";
        break missingId;
      }
      TextView tvForgot = rootView.findViewById(R.id.tvForgot);
      if (tvForgot == null) {
        missingId = "tvForgot";
        break missingId;
      }
      TextView tvMessage = rootView.findViewById(R.id.tvMessage);
      if (tvMessage == null) {
        missingId = "tvMessage";
        break missingId;
      }
      TextView tvNickName = rootView.findViewById(R.id.tvNickName);
      if (tvNickName == null) {
        missingId = "tvNickName";
        break missingId;
      }
      return new ActivityLockBinding((LinearLayout) rootView, gestureTipLayout, ivHeader, llTitle,
          lockView, tvForgot, tvMessage, tvNickName);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}