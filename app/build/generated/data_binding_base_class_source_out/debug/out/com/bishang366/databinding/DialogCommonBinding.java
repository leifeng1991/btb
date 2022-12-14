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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogCommonBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final View dialogMiddleLine;

  @NonNull
  public final TextView tvDialogMessage;

  @NonNull
  public final TextView tvDialogNo;

  @NonNull
  public final TextView tvDialogYes;

  private DialogCommonBinding(@NonNull LinearLayout rootView, @NonNull View dialogMiddleLine,
      @NonNull TextView tvDialogMessage, @NonNull TextView tvDialogNo,
      @NonNull TextView tvDialogYes) {
    this.rootView = rootView;
    this.dialogMiddleLine = dialogMiddleLine;
    this.tvDialogMessage = tvDialogMessage;
    this.tvDialogNo = tvDialogNo;
    this.tvDialogYes = tvDialogYes;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogCommonBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogCommonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_common, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogCommonBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      View dialogMiddleLine = rootView.findViewById(R.id.dialog_middle_line);
      if (dialogMiddleLine == null) {
        missingId = "dialogMiddleLine";
        break missingId;
      }
      TextView tvDialogMessage = rootView.findViewById(R.id.tv_dialog_message);
      if (tvDialogMessage == null) {
        missingId = "tvDialogMessage";
        break missingId;
      }
      TextView tvDialogNo = rootView.findViewById(R.id.tv_dialog_no);
      if (tvDialogNo == null) {
        missingId = "tvDialogNo";
        break missingId;
      }
      TextView tvDialogYes = rootView.findViewById(R.id.tv_dialog_yes);
      if (tvDialogYes == null) {
        missingId = "tvDialogYes";
        break missingId;
      }
      return new DialogCommonBinding((LinearLayout) rootView, dialogMiddleLine, tvDialogMessage,
          tvDialogNo, tvDialogYes);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
