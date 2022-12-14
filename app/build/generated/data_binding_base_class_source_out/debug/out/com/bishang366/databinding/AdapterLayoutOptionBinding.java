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

public final class AdapterLayoutOptionBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView itemHomeSymbol;

  @NonNull
  public final TextView itemHomeSymbolTwo;

  @NonNull
  public final LinearLayout llOption;

  private AdapterLayoutOptionBinding(@NonNull LinearLayout rootView,
      @NonNull TextView itemHomeSymbol, @NonNull TextView itemHomeSymbolTwo,
      @NonNull LinearLayout llOption) {
    this.rootView = rootView;
    this.itemHomeSymbol = itemHomeSymbol;
    this.itemHomeSymbolTwo = itemHomeSymbolTwo;
    this.llOption = llOption;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterLayoutOptionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterLayoutOptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter_layout_option, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterLayoutOptionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView itemHomeSymbol = rootView.findViewById(R.id.item_home_symbol);
      if (itemHomeSymbol == null) {
        missingId = "itemHomeSymbol";
        break missingId;
      }
      TextView itemHomeSymbolTwo = rootView.findViewById(R.id.item_home_symbolTwo);
      if (itemHomeSymbolTwo == null) {
        missingId = "itemHomeSymbolTwo";
        break missingId;
      }
      LinearLayout llOption = rootView.findViewById(R.id.ll_option);
      if (llOption == null) {
        missingId = "llOption";
        break missingId;
      }
      return new AdapterLayoutOptionBinding((LinearLayout) rootView, itemHomeSymbol,
          itemHomeSymbolTwo, llOption);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
