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

public final class ActivityCreditInfoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etIdCardNo;

  @NonNull
  public final EditText etName;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final LinearLayout lineWei;

  @NonNull
  public final LinearLayout llIdCardPhoto;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final TextView textYuanyin;

  @NonNull
  public final TextView tvPhotoState;

  @NonNull
  public final TextView tvSave;

  @NonNull
  public final View viewBack;

  private ActivityCreditInfoBinding(@NonNull LinearLayout rootView, @NonNull EditText etIdCardNo,
      @NonNull EditText etName, @NonNull ImageButton ibBack, @NonNull LinearLayout lineWei,
      @NonNull LinearLayout llIdCardPhoto, @NonNull LinearLayout llTitle,
      @NonNull TextView textYuanyin, @NonNull TextView tvPhotoState, @NonNull TextView tvSave,
      @NonNull View viewBack) {
    this.rootView = rootView;
    this.etIdCardNo = etIdCardNo;
    this.etName = etName;
    this.ibBack = ibBack;
    this.lineWei = lineWei;
    this.llIdCardPhoto = llIdCardPhoto;
    this.llTitle = llTitle;
    this.textYuanyin = textYuanyin;
    this.tvPhotoState = tvPhotoState;
    this.tvSave = tvSave;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreditInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreditInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_credit_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreditInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etIdCardNo = rootView.findViewById(R.id.et_id_card_no);
      if (etIdCardNo == null) {
        missingId = "etIdCardNo";
        break missingId;
      }
      EditText etName = rootView.findViewById(R.id.et_name);
      if (etName == null) {
        missingId = "etName";
        break missingId;
      }
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      LinearLayout lineWei = rootView.findViewById(R.id.line_wei);
      if (lineWei == null) {
        missingId = "lineWei";
        break missingId;
      }
      LinearLayout llIdCardPhoto = rootView.findViewById(R.id.ll_id_card_photo);
      if (llIdCardPhoto == null) {
        missingId = "llIdCardPhoto";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      TextView textYuanyin = rootView.findViewById(R.id.text_yuanyin);
      if (textYuanyin == null) {
        missingId = "textYuanyin";
        break missingId;
      }
      TextView tvPhotoState = rootView.findViewById(R.id.tv_photo_state);
      if (tvPhotoState == null) {
        missingId = "tvPhotoState";
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
      return new ActivityCreditInfoBinding((LinearLayout) rootView, etIdCardNo, etName, ibBack,
          lineWei, llIdCardPhoto, llTitle, textYuanyin, tvPhotoState, tvSave, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}