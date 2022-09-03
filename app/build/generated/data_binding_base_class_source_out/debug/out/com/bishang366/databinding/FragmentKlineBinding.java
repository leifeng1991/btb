// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bishang366.R;
import com.bishang366.customview.CustomViewPager;
import com.bishang366.customview.intercept.WonderfulScrollView;
import com.bishang366.ui.kline.kline.KLineView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentKlineBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final ImageView ivFullScreen;

  @NonNull
  public final TextView kCount;

  @NonNull
  public final TextView kDataOne;

  @NonNull
  public final TextView kDataText;

  @NonNull
  public final TextView kLow;

  @NonNull
  public final TextView kRange;

  @NonNull
  public final TextView kUp;

  @NonNull
  public final KLineView klineView;

  @NonNull
  public final LinearLayout llAllTab;

  @NonNull
  public final TabLayout llDepthTab;

  @NonNull
  public final LinearLayout llLandText;

  @NonNull
  public final LinearLayout llState;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final LinearLayout llVertical;

  @NonNull
  public final WonderfulScrollView scrollView;

  @NonNull
  public final LinearLayout tab;

  @NonNull
  public final TextView tvBuy;

  @NonNull
  public final TextView tvCollect;

  @NonNull
  public final TextView tvCurrencyName;

  @NonNull
  public final TextView tvIndex;

  @NonNull
  public final TextView tvMore;

  @NonNull
  public final TextView tvSell;

  @NonNull
  public final CustomViewPager vpDepth;

  private FragmentKlineBinding(@NonNull LinearLayout rootView, @NonNull ImageButton ibBack,
      @NonNull ImageView ivFullScreen, @NonNull TextView kCount, @NonNull TextView kDataOne,
      @NonNull TextView kDataText, @NonNull TextView kLow, @NonNull TextView kRange,
      @NonNull TextView kUp, @NonNull KLineView klineView, @NonNull LinearLayout llAllTab,
      @NonNull TabLayout llDepthTab, @NonNull LinearLayout llLandText,
      @NonNull LinearLayout llState, @NonNull LinearLayout llTitle,
      @NonNull LinearLayout llVertical, @NonNull WonderfulScrollView scrollView,
      @NonNull LinearLayout tab, @NonNull TextView tvBuy, @NonNull TextView tvCollect,
      @NonNull TextView tvCurrencyName, @NonNull TextView tvIndex, @NonNull TextView tvMore,
      @NonNull TextView tvSell, @NonNull CustomViewPager vpDepth) {
    this.rootView = rootView;
    this.ibBack = ibBack;
    this.ivFullScreen = ivFullScreen;
    this.kCount = kCount;
    this.kDataOne = kDataOne;
    this.kDataText = kDataText;
    this.kLow = kLow;
    this.kRange = kRange;
    this.kUp = kUp;
    this.klineView = klineView;
    this.llAllTab = llAllTab;
    this.llDepthTab = llDepthTab;
    this.llLandText = llLandText;
    this.llState = llState;
    this.llTitle = llTitle;
    this.llVertical = llVertical;
    this.scrollView = scrollView;
    this.tab = tab;
    this.tvBuy = tvBuy;
    this.tvCollect = tvCollect;
    this.tvCurrencyName = tvCurrencyName;
    this.tvIndex = tvIndex;
    this.tvMore = tvMore;
    this.tvSell = tvSell;
    this.vpDepth = vpDepth;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentKlineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentKlineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_kline, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentKlineBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      ImageView ivFullScreen = rootView.findViewById(R.id.ivFullScreen);
      if (ivFullScreen == null) {
        missingId = "ivFullScreen";
        break missingId;
      }
      TextView kCount = rootView.findViewById(R.id.kCount);
      if (kCount == null) {
        missingId = "kCount";
        break missingId;
      }
      TextView kDataOne = rootView.findViewById(R.id.kDataOne);
      if (kDataOne == null) {
        missingId = "kDataOne";
        break missingId;
      }
      TextView kDataText = rootView.findViewById(R.id.kDataText);
      if (kDataText == null) {
        missingId = "kDataText";
        break missingId;
      }
      TextView kLow = rootView.findViewById(R.id.kLow);
      if (kLow == null) {
        missingId = "kLow";
        break missingId;
      }
      TextView kRange = rootView.findViewById(R.id.kRange);
      if (kRange == null) {
        missingId = "kRange";
        break missingId;
      }
      TextView kUp = rootView.findViewById(R.id.kUp);
      if (kUp == null) {
        missingId = "kUp";
        break missingId;
      }
      KLineView klineView = rootView.findViewById(R.id.kline_view);
      if (klineView == null) {
        missingId = "klineView";
        break missingId;
      }
      LinearLayout llAllTab = rootView.findViewById(R.id.llAllTab);
      if (llAllTab == null) {
        missingId = "llAllTab";
        break missingId;
      }
      TabLayout llDepthTab = rootView.findViewById(R.id.llDepthTab);
      if (llDepthTab == null) {
        missingId = "llDepthTab";
        break missingId;
      }
      LinearLayout llLandText = rootView.findViewById(R.id.llLandText);
      if (llLandText == null) {
        missingId = "llLandText";
        break missingId;
      }
      LinearLayout llState = rootView.findViewById(R.id.llState);
      if (llState == null) {
        missingId = "llState";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      LinearLayout llVertical = rootView.findViewById(R.id.llVertical);
      if (llVertical == null) {
        missingId = "llVertical";
        break missingId;
      }
      WonderfulScrollView scrollView = rootView.findViewById(R.id.scrollView);
      if (scrollView == null) {
        missingId = "scrollView";
        break missingId;
      }
      LinearLayout tab = rootView.findViewById(R.id.tab);
      if (tab == null) {
        missingId = "tab";
        break missingId;
      }
      TextView tvBuy = rootView.findViewById(R.id.tvBuy);
      if (tvBuy == null) {
        missingId = "tvBuy";
        break missingId;
      }
      TextView tvCollect = rootView.findViewById(R.id.tv_collect);
      if (tvCollect == null) {
        missingId = "tvCollect";
        break missingId;
      }
      TextView tvCurrencyName = rootView.findViewById(R.id.tvCurrencyName);
      if (tvCurrencyName == null) {
        missingId = "tvCurrencyName";
        break missingId;
      }
      TextView tvIndex = rootView.findViewById(R.id.tvIndex);
      if (tvIndex == null) {
        missingId = "tvIndex";
        break missingId;
      }
      TextView tvMore = rootView.findViewById(R.id.tvMore);
      if (tvMore == null) {
        missingId = "tvMore";
        break missingId;
      }
      TextView tvSell = rootView.findViewById(R.id.tvSell);
      if (tvSell == null) {
        missingId = "tvSell";
        break missingId;
      }
      CustomViewPager vpDepth = rootView.findViewById(R.id.vpDepth);
      if (vpDepth == null) {
        missingId = "vpDepth";
        break missingId;
      }
      return new FragmentKlineBinding((LinearLayout) rootView, ibBack, ivFullScreen, kCount,
          kDataOne, kDataText, kLow, kRange, kUp, klineView, llAllTab, llDepthTab, llLandText,
          llState, llTitle, llVertical, scrollView, tab, tvBuy, tvCollect, tvCurrencyName, tvIndex,
          tvMore, tvSell, vpDepth);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}