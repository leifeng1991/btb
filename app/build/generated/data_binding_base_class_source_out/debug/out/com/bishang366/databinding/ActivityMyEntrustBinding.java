// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMyEntrustBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final TextView ibRegist;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final SwipeRefreshLayout refreshLayout;

  @NonNull
  public final RelativeLayout rlEmpty;

  @NonNull
  public final RecyclerView rlEntrust;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final View viewBack;

  private ActivityMyEntrustBinding(@NonNull RelativeLayout rootView, @NonNull ImageButton ibBack,
      @NonNull TextView ibRegist, @NonNull LinearLayout llTitle,
      @NonNull SwipeRefreshLayout refreshLayout, @NonNull RelativeLayout rlEmpty,
      @NonNull RecyclerView rlEntrust, @NonNull Spinner spinner, @NonNull TextView tvMessage,
      @NonNull View viewBack) {
    this.rootView = rootView;
    this.ibBack = ibBack;
    this.ibRegist = ibRegist;
    this.llTitle = llTitle;
    this.refreshLayout = refreshLayout;
    this.rlEmpty = rlEmpty;
    this.rlEntrust = rlEntrust;
    this.spinner = spinner;
    this.tvMessage = tvMessage;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMyEntrustBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMyEntrustBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_my_entrust, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMyEntrustBinding bind(@NonNull View rootView) {
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
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      SwipeRefreshLayout refreshLayout = rootView.findViewById(R.id.refreshLayout);
      if (refreshLayout == null) {
        missingId = "refreshLayout";
        break missingId;
      }
      RelativeLayout rlEmpty = rootView.findViewById(R.id.rlEmpty);
      if (rlEmpty == null) {
        missingId = "rlEmpty";
        break missingId;
      }
      RecyclerView rlEntrust = rootView.findViewById(R.id.rlEntrust);
      if (rlEntrust == null) {
        missingId = "rlEntrust";
        break missingId;
      }
      Spinner spinner = rootView.findViewById(R.id.spinner);
      if (spinner == null) {
        missingId = "spinner";
        break missingId;
      }
      TextView tvMessage = rootView.findViewById(R.id.tvMessage);
      if (tvMessage == null) {
        missingId = "tvMessage";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityMyEntrustBinding((RelativeLayout) rootView, ibBack, ibRegist, llTitle,
          refreshLayout, rlEmpty, rlEntrust, spinner, tvMessage, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
