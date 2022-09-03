// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLeadBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView btnGuideStartExperience;

  @NonNull
  public final LinearLayout dotLayout;

  @NonNull
  public final ViewPager myViewpager;

  private ActivityLeadBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView btnGuideStartExperience, @NonNull LinearLayout dotLayout,
      @NonNull ViewPager myViewpager) {
    this.rootView = rootView;
    this.btnGuideStartExperience = btnGuideStartExperience;
    this.dotLayout = dotLayout;
    this.myViewpager = myViewpager;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLeadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLeadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_lead, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLeadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      ImageView btnGuideStartExperience = rootView.findViewById(R.id.btn_guide_start_experience);
      if (btnGuideStartExperience == null) {
        missingId = "btnGuideStartExperience";
        break missingId;
      }
      LinearLayout dotLayout = rootView.findViewById(R.id.dot_layout);
      if (dotLayout == null) {
        missingId = "dotLayout";
        break missingId;
      }
      ViewPager myViewpager = rootView.findViewById(R.id.my_viewpager);
      if (myViewpager == null) {
        missingId = "myViewpager";
        break missingId;
      }
      return new ActivityLeadBinding((RelativeLayout) rootView, btnGuideStartExperience, dotLayout,
          myViewpager);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
