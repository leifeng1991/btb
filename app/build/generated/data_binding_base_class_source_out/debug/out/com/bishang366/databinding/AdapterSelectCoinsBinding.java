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

public final class AdapterSelectCoinsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView tvCoin;

  private AdapterSelectCoinsBinding(@NonNull LinearLayout rootView, @NonNull TextView tvCoin) {
    this.rootView = rootView;
    this.tvCoin = tvCoin;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterSelectCoinsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterSelectCoinsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter_select_coins, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterSelectCoinsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView tvCoin = rootView.findViewById(R.id.tvCoin);
      if (tvCoin == null) {
        missingId = "tvCoin";
        break missingId;
      }
      return new AdapterSelectCoinsBinding((LinearLayout) rootView, tvCoin);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
