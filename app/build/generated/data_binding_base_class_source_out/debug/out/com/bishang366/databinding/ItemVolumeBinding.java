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

public final class ItemVolumeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView tvDirect;

  @NonNull
  public final TextView tvNumber;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvTime;

  private ItemVolumeBinding(@NonNull LinearLayout rootView, @NonNull TextView tvDirect,
      @NonNull TextView tvNumber, @NonNull TextView tvPrice, @NonNull TextView tvTime) {
    this.rootView = rootView;
    this.tvDirect = tvDirect;
    this.tvNumber = tvNumber;
    this.tvPrice = tvPrice;
    this.tvTime = tvTime;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemVolumeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemVolumeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_volume, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemVolumeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView tvDirect = rootView.findViewById(R.id.tvDirect);
      if (tvDirect == null) {
        missingId = "tvDirect";
        break missingId;
      }
      TextView tvNumber = rootView.findViewById(R.id.tvNumber);
      if (tvNumber == null) {
        missingId = "tvNumber";
        break missingId;
      }
      TextView tvPrice = rootView.findViewById(R.id.tvPrice);
      if (tvPrice == null) {
        missingId = "tvPrice";
        break missingId;
      }
      TextView tvTime = rootView.findViewById(R.id.tvTime);
      if (tvTime == null) {
        missingId = "tvTime";
        break missingId;
      }
      return new ItemVolumeBinding((LinearLayout) rootView, tvDirect, tvNumber, tvPrice, tvTime);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
