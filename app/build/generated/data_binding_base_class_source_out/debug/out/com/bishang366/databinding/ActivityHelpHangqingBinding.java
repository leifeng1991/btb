// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import com.bishang366.base.LinListView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHelpHangqingBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final TextView ibRegist;

  @NonNull
  public final LinListView listviewHangqing;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final View viewBack;

  private ActivityHelpHangqingBinding(@NonNull LinearLayout rootView, @NonNull ImageButton ibBack,
      @NonNull TextView ibRegist, @NonNull LinListView listviewHangqing,
      @NonNull LinearLayout llTitle, @NonNull View viewBack) {
    this.rootView = rootView;
    this.ibBack = ibBack;
    this.ibRegist = ibRegist;
    this.listviewHangqing = listviewHangqing;
    this.llTitle = llTitle;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHelpHangqingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHelpHangqingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_help_hangqing, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHelpHangqingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
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
      LinListView listviewHangqing = rootView.findViewById(R.id.listview_hangqing);
      if (listviewHangqing == null) {
        missingId = "listviewHangqing";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityHelpHangqingBinding((LinearLayout) rootView, ibBack, ibRegist,
          listviewHangqing, llTitle, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
