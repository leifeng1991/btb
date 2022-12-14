// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PopSixMultiples2Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buClose2;

  @NonNull
  public final Button buTrue2;

  @NonNull
  public final ImageView imgInto;

  @NonNull
  public final RecyclerView rvMultiple;

  private PopSixMultiples2Binding(@NonNull LinearLayout rootView, @NonNull Button buClose2,
      @NonNull Button buTrue2, @NonNull ImageView imgInto, @NonNull RecyclerView rvMultiple) {
    this.rootView = rootView;
    this.buClose2 = buClose2;
    this.buTrue2 = buTrue2;
    this.imgInto = imgInto;
    this.rvMultiple = rvMultiple;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PopSixMultiples2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PopSixMultiples2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pop_six_multiples2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PopSixMultiples2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      Button buClose2 = rootView.findViewById(R.id.bu_close2);
      if (buClose2 == null) {
        missingId = "buClose2";
        break missingId;
      }
      Button buTrue2 = rootView.findViewById(R.id.bu_true2);
      if (buTrue2 == null) {
        missingId = "buTrue2";
        break missingId;
      }
      ImageView imgInto = rootView.findViewById(R.id.img_into);
      if (imgInto == null) {
        missingId = "imgInto";
        break missingId;
      }
      RecyclerView rvMultiple = rootView.findViewById(R.id.rv_multiple);
      if (rvMultiple == null) {
        missingId = "rvMultiple";
        break missingId;
      }
      return new PopSixMultiples2Binding((LinearLayout) rootView, buClose2, buTrue2, imgInto,
          rvMultiple);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
