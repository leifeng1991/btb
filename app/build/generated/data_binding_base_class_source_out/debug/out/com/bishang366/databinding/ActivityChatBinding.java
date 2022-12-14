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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChatBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etContent;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final SwipeRefreshLayout refreshLayout;

  @NonNull
  public final RecyclerView rvMessage;

  @NonNull
  public final TextView tvOrder;

  @NonNull
  public final TextView tvSend;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final View viewBack;

  private ActivityChatBinding(@NonNull LinearLayout rootView, @NonNull EditText etContent,
      @NonNull ImageButton ibBack, @NonNull LinearLayout llTitle,
      @NonNull SwipeRefreshLayout refreshLayout, @NonNull RecyclerView rvMessage,
      @NonNull TextView tvOrder, @NonNull TextView tvSend, @NonNull TextView tvTitle,
      @NonNull View viewBack) {
    this.rootView = rootView;
    this.etContent = etContent;
    this.ibBack = ibBack;
    this.llTitle = llTitle;
    this.refreshLayout = refreshLayout;
    this.rvMessage = rvMessage;
    this.tvOrder = tvOrder;
    this.tvSend = tvSend;
    this.tvTitle = tvTitle;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_chat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etContent = rootView.findViewById(R.id.etContent);
      if (etContent == null) {
        missingId = "etContent";
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
      SwipeRefreshLayout refreshLayout = rootView.findViewById(R.id.refreshLayout);
      if (refreshLayout == null) {
        missingId = "refreshLayout";
        break missingId;
      }
      RecyclerView rvMessage = rootView.findViewById(R.id.rvMessage);
      if (rvMessage == null) {
        missingId = "rvMessage";
        break missingId;
      }
      TextView tvOrder = rootView.findViewById(R.id.tvOrder);
      if (tvOrder == null) {
        missingId = "tvOrder";
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
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityChatBinding((LinearLayout) rootView, etContent, ibBack, llTitle,
          refreshLayout, rvMessage, tvOrder, tvSend, tvTitle, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
