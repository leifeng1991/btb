// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDepthBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ProgressBar depthBar;

  @NonNull
  public final LinearLayout llDepthTab;

  @NonNull
  public final RecyclerView rvDepth;

  @NonNull
  public final TextView tvNumber;

  @NonNull
  public final TextView tvNumberR;

  @NonNull
  public final TextView tvPrice;

  private FragmentDepthBinding(@NonNull LinearLayout rootView, @NonNull ProgressBar depthBar,
      @NonNull LinearLayout llDepthTab, @NonNull RecyclerView rvDepth, @NonNull TextView tvNumber,
      @NonNull TextView tvNumberR, @NonNull TextView tvPrice) {
    this.rootView = rootView;
    this.depthBar = depthBar;
    this.llDepthTab = llDepthTab;
    this.rvDepth = rvDepth;
    this.tvNumber = tvNumber;
    this.tvNumberR = tvNumberR;
    this.tvPrice = tvPrice;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDepthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDepthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_depth, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDepthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      ProgressBar depthBar = rootView.findViewById(R.id.depthBar);
      if (depthBar == null) {
        missingId = "depthBar";
        break missingId;
      }
      LinearLayout llDepthTab = rootView.findViewById(R.id.llDepthTab);
      if (llDepthTab == null) {
        missingId = "llDepthTab";
        break missingId;
      }
      RecyclerView rvDepth = rootView.findViewById(R.id.rvDepth);
      if (rvDepth == null) {
        missingId = "rvDepth";
        break missingId;
      }
      TextView tvNumber = rootView.findViewById(R.id.tvNumber);
      if (tvNumber == null) {
        missingId = "tvNumber";
        break missingId;
      }
      TextView tvNumberR = rootView.findViewById(R.id.tvNumberR);
      if (tvNumberR == null) {
        missingId = "tvNumberR";
        break missingId;
      }
      TextView tvPrice = rootView.findViewById(R.id.tvPrice);
      if (tvPrice == null) {
        missingId = "tvPrice";
        break missingId;
      }
      return new FragmentDepthBinding((LinearLayout) rootView, depthBar, llDepthTab, rvDepth,
          tvNumber, tvNumberR, tvPrice);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
