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

public final class AdapterLayoutContractBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView itemHomeChange;

  @NonNull
  public final TextView itemHomeChg;

  @NonNull
  public final TextView itemHomeClose;

  @NonNull
  public final TextView itemHomeMoney;

  @NonNull
  public final TextView itemHomeSymbol;

  @NonNull
  public final TextView itemHomeSymbolTwo;

  @NonNull
  public final LinearLayout llContract;

  private AdapterLayoutContractBinding(@NonNull LinearLayout rootView,
      @NonNull TextView itemHomeChange, @NonNull TextView itemHomeChg,
      @NonNull TextView itemHomeClose, @NonNull TextView itemHomeMoney,
      @NonNull TextView itemHomeSymbol, @NonNull TextView itemHomeSymbolTwo,
      @NonNull LinearLayout llContract) {
    this.rootView = rootView;
    this.itemHomeChange = itemHomeChange;
    this.itemHomeChg = itemHomeChg;
    this.itemHomeClose = itemHomeClose;
    this.itemHomeMoney = itemHomeMoney;
    this.itemHomeSymbol = itemHomeSymbol;
    this.itemHomeSymbolTwo = itemHomeSymbolTwo;
    this.llContract = llContract;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterLayoutContractBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterLayoutContractBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter_layout_contract, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterLayoutContractBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      TextView itemHomeChange = rootView.findViewById(R.id.item_home_change);
      if (itemHomeChange == null) {
        missingId = "itemHomeChange";
        break missingId;
      }
      TextView itemHomeChg = rootView.findViewById(R.id.item_home_chg);
      if (itemHomeChg == null) {
        missingId = "itemHomeChg";
        break missingId;
      }
      TextView itemHomeClose = rootView.findViewById(R.id.item_home_close);
      if (itemHomeClose == null) {
        missingId = "itemHomeClose";
        break missingId;
      }
      TextView itemHomeMoney = rootView.findViewById(R.id.item_home_money);
      if (itemHomeMoney == null) {
        missingId = "itemHomeMoney";
        break missingId;
      }
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
      LinearLayout llContract = rootView.findViewById(R.id.ll_contract);
      if (llContract == null) {
        missingId = "llContract";
        break missingId;
      }
      return new AdapterLayoutContractBinding((LinearLayout) rootView, itemHomeChange, itemHomeChg,
          itemHomeClose, itemHomeMoney, itemHomeSymbol, itemHomeSymbolTwo, llContract);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
