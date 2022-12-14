// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ListView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomListviewFreshBinding implements ViewBinding {
  @NonNull
  private final SwipeRefreshLayout rootView;

  @NonNull
  public final SwipeRefreshLayout freshLayout;

  @NonNull
  public final ListView pagingListView;

  private CustomListviewFreshBinding(@NonNull SwipeRefreshLayout rootView,
      @NonNull SwipeRefreshLayout freshLayout, @NonNull ListView pagingListView) {
    this.rootView = rootView;
    this.freshLayout = freshLayout;
    this.pagingListView = pagingListView;
  }

  @Override
  @NonNull
  public SwipeRefreshLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomListviewFreshBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomListviewFreshBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_listview_fresh, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomListviewFreshBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      SwipeRefreshLayout freshLayout = rootView.findViewById(R.id.fresh_layout);
      if (freshLayout == null) {
        missingId = "freshLayout";
        break missingId;
      }
      ListView pagingListView = rootView.findViewById(R.id.paging_list_view);
      if (pagingListView == null) {
        missingId = "pagingListView";
        break missingId;
      }
      return new CustomListviewFreshBinding((SwipeRefreshLayout) rootView, freshLayout,
          pagingListView);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
