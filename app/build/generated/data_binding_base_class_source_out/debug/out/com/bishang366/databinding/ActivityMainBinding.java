// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final DrawerLayout dlRoot;

  @NonNull
  public final FrameLayout flContainer;

  @NonNull
  public final ImageButton ibClose;

  @NonNull
  public final ImageButton ibCloseConstract;

  @NonNull
  public final ImageButton ibCloseOption;

  @NonNull
  public final LinearLayout llCoins;

  @NonNull
  public final LinearLayout llContract;

  @NonNull
  public final LinearLayout llFive;

  @NonNull
  public final LinearLayout llFour;

  @NonNull
  public final LinearLayout llOne;

  @NonNull
  public final LinearLayout llOption;

  @NonNull
  public final LinearLayout llSeven;

  @NonNull
  public final LinearLayout llSix;

  @NonNull
  public final LinearLayout llTab;

  @NonNull
  public final LinearLayout llThree;

  @NonNull
  public final LinearLayout llTwo;

  @NonNull
  public final TabLayout tab;

  @NonNull
  public final ViewPager vpConstract;

  @NonNull
  public final ViewPager vpMenu;

  @NonNull
  public final ViewPager vpOption;

  private ActivityMainBinding(@NonNull DrawerLayout rootView, @NonNull DrawerLayout dlRoot,
      @NonNull FrameLayout flContainer, @NonNull ImageButton ibClose,
      @NonNull ImageButton ibCloseConstract, @NonNull ImageButton ibCloseOption,
      @NonNull LinearLayout llCoins, @NonNull LinearLayout llContract, @NonNull LinearLayout llFive,
      @NonNull LinearLayout llFour, @NonNull LinearLayout llOne, @NonNull LinearLayout llOption,
      @NonNull LinearLayout llSeven, @NonNull LinearLayout llSix, @NonNull LinearLayout llTab,
      @NonNull LinearLayout llThree, @NonNull LinearLayout llTwo, @NonNull TabLayout tab,
      @NonNull ViewPager vpConstract, @NonNull ViewPager vpMenu, @NonNull ViewPager vpOption) {
    this.rootView = rootView;
    this.dlRoot = dlRoot;
    this.flContainer = flContainer;
    this.ibClose = ibClose;
    this.ibCloseConstract = ibCloseConstract;
    this.ibCloseOption = ibCloseOption;
    this.llCoins = llCoins;
    this.llContract = llContract;
    this.llFive = llFive;
    this.llFour = llFour;
    this.llOne = llOne;
    this.llOption = llOption;
    this.llSeven = llSeven;
    this.llSix = llSix;
    this.llTab = llTab;
    this.llThree = llThree;
    this.llTwo = llTwo;
    this.tab = tab;
    this.vpConstract = vpConstract;
    this.vpMenu = vpMenu;
    this.vpOption = vpOption;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      DrawerLayout dlRoot = rootView.findViewById(R.id.dlRoot);
      if (dlRoot == null) {
        missingId = "dlRoot";
        break missingId;
      }
      FrameLayout flContainer = rootView.findViewById(R.id.flContainer);
      if (flContainer == null) {
        missingId = "flContainer";
        break missingId;
      }
      ImageButton ibClose = rootView.findViewById(R.id.ibClose);
      if (ibClose == null) {
        missingId = "ibClose";
        break missingId;
      }
      ImageButton ibCloseConstract = rootView.findViewById(R.id.ibClose_constract);
      if (ibCloseConstract == null) {
        missingId = "ibCloseConstract";
        break missingId;
      }
      ImageButton ibCloseOption = rootView.findViewById(R.id.ibClose_option);
      if (ibCloseOption == null) {
        missingId = "ibCloseOption";
        break missingId;
      }
      LinearLayout llCoins = rootView.findViewById(R.id.ll_coins);
      if (llCoins == null) {
        missingId = "llCoins";
        break missingId;
      }
      LinearLayout llContract = rootView.findViewById(R.id.ll_contract);
      if (llContract == null) {
        missingId = "llContract";
        break missingId;
      }
      LinearLayout llFive = rootView.findViewById(R.id.llFive);
      if (llFive == null) {
        missingId = "llFive";
        break missingId;
      }
      LinearLayout llFour = rootView.findViewById(R.id.llFour);
      if (llFour == null) {
        missingId = "llFour";
        break missingId;
      }
      LinearLayout llOne = rootView.findViewById(R.id.llOne);
      if (llOne == null) {
        missingId = "llOne";
        break missingId;
      }
      LinearLayout llOption = rootView.findViewById(R.id.ll_option);
      if (llOption == null) {
        missingId = "llOption";
        break missingId;
      }
      LinearLayout llSeven = rootView.findViewById(R.id.llSeven);
      if (llSeven == null) {
        missingId = "llSeven";
        break missingId;
      }
      LinearLayout llSix = rootView.findViewById(R.id.llSix);
      if (llSix == null) {
        missingId = "llSix";
        break missingId;
      }
      LinearLayout llTab = rootView.findViewById(R.id.llTab);
      if (llTab == null) {
        missingId = "llTab";
        break missingId;
      }
      LinearLayout llThree = rootView.findViewById(R.id.llThree);
      if (llThree == null) {
        missingId = "llThree";
        break missingId;
      }
      LinearLayout llTwo = rootView.findViewById(R.id.llTwo);
      if (llTwo == null) {
        missingId = "llTwo";
        break missingId;
      }
      TabLayout tab = rootView.findViewById(R.id.tab);
      if (tab == null) {
        missingId = "tab";
        break missingId;
      }
      ViewPager vpConstract = rootView.findViewById(R.id.vp_constract);
      if (vpConstract == null) {
        missingId = "vpConstract";
        break missingId;
      }
      ViewPager vpMenu = rootView.findViewById(R.id.vpMenu);
      if (vpMenu == null) {
        missingId = "vpMenu";
        break missingId;
      }
      ViewPager vpOption = rootView.findViewById(R.id.vp_option);
      if (vpOption == null) {
        missingId = "vpOption";
        break missingId;
      }
      return new ActivityMainBinding((DrawerLayout) rootView, dlRoot, flContainer, ibClose,
          ibCloseConstract, ibCloseOption, llCoins, llContract, llFive, llFour, llOne, llOption,
          llSeven, llSix, llTab, llThree, llTwo, tab, vpConstract, vpMenu, vpOption);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
