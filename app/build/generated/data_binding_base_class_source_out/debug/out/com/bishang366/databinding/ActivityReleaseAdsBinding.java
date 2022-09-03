// Generated by view binder compiler. Do not edit!
package com.bishang366.databinding;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.viewbinding.ViewBinding;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.bishang366.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityReleaseAdsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etCount;

  @NonNull
  public final EditText etMax;

  @NonNull
  public final EditText etMessage;

  @NonNull
  public final EditText etMin;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final EditText etReplyContent;

  @NonNull
  public final EditText etjyPrice;

  @NonNull
  public final ImageButton ibBack;

  @NonNull
  public final ImageButton ibHelp;

  @NonNull
  public final View line0;

  @NonNull
  public final LinearLayout llCoin;

  @NonNull
  public final LinearLayout llCountry;

  @NonNull
  public final LinearLayout llPayWay;

  @NonNull
  public final LinearLayout llTime;

  @NonNull
  public final LinearLayout llTitle;

  @NonNull
  public final RadioButton rbChange;

  @NonNull
  public final RadioButton rbFixed;

  @NonNull
  public final RadioButton rbNo;

  @NonNull
  public final RadioButton rbYes;

  @NonNull
  public final RadioGroup rgPriceType;

  @NonNull
  public final RadioGroup rgReply;

  @NonNull
  public final TextView tvCoin;

  @NonNull
  public final TextView tvCoinKind;

  @NonNull
  public final TextView tvCountText;

  @NonNull
  public final TextView tvCountry;

  @NonNull
  public final EditText tvOverflow;

  @NonNull
  public final TextView tvPayTime;

  @NonNull
  public final TextView tvPayWay;

  @NonNull
  public final TextView tvPayWayText;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvRelease;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final View viewBack;

  private ActivityReleaseAdsBinding(@NonNull LinearLayout rootView, @NonNull EditText etCount,
      @NonNull EditText etMax, @NonNull EditText etMessage, @NonNull EditText etMin,
      @NonNull EditText etPassword, @NonNull EditText etReplyContent, @NonNull EditText etjyPrice,
      @NonNull ImageButton ibBack, @NonNull ImageButton ibHelp, @NonNull View line0,
      @NonNull LinearLayout llCoin, @NonNull LinearLayout llCountry, @NonNull LinearLayout llPayWay,
      @NonNull LinearLayout llTime, @NonNull LinearLayout llTitle, @NonNull RadioButton rbChange,
      @NonNull RadioButton rbFixed, @NonNull RadioButton rbNo, @NonNull RadioButton rbYes,
      @NonNull RadioGroup rgPriceType, @NonNull RadioGroup rgReply, @NonNull TextView tvCoin,
      @NonNull TextView tvCoinKind, @NonNull TextView tvCountText, @NonNull TextView tvCountry,
      @NonNull EditText tvOverflow, @NonNull TextView tvPayTime, @NonNull TextView tvPayWay,
      @NonNull TextView tvPayWayText, @NonNull TextView tvPrice, @NonNull TextView tvRelease,
      @NonNull TextView tvTitle, @NonNull View viewBack) {
    this.rootView = rootView;
    this.etCount = etCount;
    this.etMax = etMax;
    this.etMessage = etMessage;
    this.etMin = etMin;
    this.etPassword = etPassword;
    this.etReplyContent = etReplyContent;
    this.etjyPrice = etjyPrice;
    this.ibBack = ibBack;
    this.ibHelp = ibHelp;
    this.line0 = line0;
    this.llCoin = llCoin;
    this.llCountry = llCountry;
    this.llPayWay = llPayWay;
    this.llTime = llTime;
    this.llTitle = llTitle;
    this.rbChange = rbChange;
    this.rbFixed = rbFixed;
    this.rbNo = rbNo;
    this.rbYes = rbYes;
    this.rgPriceType = rgPriceType;
    this.rgReply = rgReply;
    this.tvCoin = tvCoin;
    this.tvCoinKind = tvCoinKind;
    this.tvCountText = tvCountText;
    this.tvCountry = tvCountry;
    this.tvOverflow = tvOverflow;
    this.tvPayTime = tvPayTime;
    this.tvPayWay = tvPayWay;
    this.tvPayWayText = tvPayWayText;
    this.tvPrice = tvPrice;
    this.tvRelease = tvRelease;
    this.tvTitle = tvTitle;
    this.viewBack = viewBack;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityReleaseAdsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityReleaseAdsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_release_ads, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityReleaseAdsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      EditText etCount = rootView.findViewById(R.id.etCount);
      if (etCount == null) {
        missingId = "etCount";
        break missingId;
      }
      EditText etMax = rootView.findViewById(R.id.etMax);
      if (etMax == null) {
        missingId = "etMax";
        break missingId;
      }
      EditText etMessage = rootView.findViewById(R.id.etMessage);
      if (etMessage == null) {
        missingId = "etMessage";
        break missingId;
      }
      EditText etMin = rootView.findViewById(R.id.etMin);
      if (etMin == null) {
        missingId = "etMin";
        break missingId;
      }
      EditText etPassword = rootView.findViewById(R.id.etPassword);
      if (etPassword == null) {
        missingId = "etPassword";
        break missingId;
      }
      EditText etReplyContent = rootView.findViewById(R.id.etReplyContent);
      if (etReplyContent == null) {
        missingId = "etReplyContent";
        break missingId;
      }
      EditText etjyPrice = rootView.findViewById(R.id.etjyPrice);
      if (etjyPrice == null) {
        missingId = "etjyPrice";
        break missingId;
      }
      ImageButton ibBack = rootView.findViewById(R.id.ibBack);
      if (ibBack == null) {
        missingId = "ibBack";
        break missingId;
      }
      ImageButton ibHelp = rootView.findViewById(R.id.ibHelp);
      if (ibHelp == null) {
        missingId = "ibHelp";
        break missingId;
      }
      View line0 = rootView.findViewById(R.id.line0);
      if (line0 == null) {
        missingId = "line0";
        break missingId;
      }
      LinearLayout llCoin = rootView.findViewById(R.id.llCoin);
      if (llCoin == null) {
        missingId = "llCoin";
        break missingId;
      }
      LinearLayout llCountry = rootView.findViewById(R.id.llCountry);
      if (llCountry == null) {
        missingId = "llCountry";
        break missingId;
      }
      LinearLayout llPayWay = rootView.findViewById(R.id.llPayWay);
      if (llPayWay == null) {
        missingId = "llPayWay";
        break missingId;
      }
      LinearLayout llTime = rootView.findViewById(R.id.llTime);
      if (llTime == null) {
        missingId = "llTime";
        break missingId;
      }
      LinearLayout llTitle = rootView.findViewById(R.id.llTitle);
      if (llTitle == null) {
        missingId = "llTitle";
        break missingId;
      }
      RadioButton rbChange = rootView.findViewById(R.id.rbChange);
      if (rbChange == null) {
        missingId = "rbChange";
        break missingId;
      }
      RadioButton rbFixed = rootView.findViewById(R.id.rbFixed);
      if (rbFixed == null) {
        missingId = "rbFixed";
        break missingId;
      }
      RadioButton rbNo = rootView.findViewById(R.id.rbNo);
      if (rbNo == null) {
        missingId = "rbNo";
        break missingId;
      }
      RadioButton rbYes = rootView.findViewById(R.id.rbYes);
      if (rbYes == null) {
        missingId = "rbYes";
        break missingId;
      }
      RadioGroup rgPriceType = rootView.findViewById(R.id.rgPriceType);
      if (rgPriceType == null) {
        missingId = "rgPriceType";
        break missingId;
      }
      RadioGroup rgReply = rootView.findViewById(R.id.rgReply);
      if (rgReply == null) {
        missingId = "rgReply";
        break missingId;
      }
      TextView tvCoin = rootView.findViewById(R.id.tvCoin);
      if (tvCoin == null) {
        missingId = "tvCoin";
        break missingId;
      }
      TextView tvCoinKind = rootView.findViewById(R.id.tvCoinKind);
      if (tvCoinKind == null) {
        missingId = "tvCoinKind";
        break missingId;
      }
      TextView tvCountText = rootView.findViewById(R.id.tvCountText);
      if (tvCountText == null) {
        missingId = "tvCountText";
        break missingId;
      }
      TextView tvCountry = rootView.findViewById(R.id.tvCountry);
      if (tvCountry == null) {
        missingId = "tvCountry";
        break missingId;
      }
      EditText tvOverflow = rootView.findViewById(R.id.tvOverflow);
      if (tvOverflow == null) {
        missingId = "tvOverflow";
        break missingId;
      }
      TextView tvPayTime = rootView.findViewById(R.id.tvPayTime);
      if (tvPayTime == null) {
        missingId = "tvPayTime";
        break missingId;
      }
      TextView tvPayWay = rootView.findViewById(R.id.tvPayWay);
      if (tvPayWay == null) {
        missingId = "tvPayWay";
        break missingId;
      }
      TextView tvPayWayText = rootView.findViewById(R.id.tvPayWayText);
      if (tvPayWayText == null) {
        missingId = "tvPayWayText";
        break missingId;
      }
      TextView tvPrice = rootView.findViewById(R.id.tvPrice);
      if (tvPrice == null) {
        missingId = "tvPrice";
        break missingId;
      }
      TextView tvRelease = rootView.findViewById(R.id.tvRelease);
      if (tvRelease == null) {
        missingId = "tvRelease";
        break missingId;
      }
      TextView tvTitle = rootView.findViewById(R.id.tvTitle);
      if (tvTitle == null) {
        missingId = "tvTitle";
        break missingId;
      }
      View viewBack = rootView.findViewById(R.id.view_back);
      if (viewBack == null) {
        missingId = "viewBack";
        break missingId;
      }
      return new ActivityReleaseAdsBinding((LinearLayout) rootView, etCount, etMax, etMessage,
          etMin, etPassword, etReplyContent, etjyPrice, ibBack, ibHelp, line0, llCoin, llCountry,
          llPayWay, llTime, llTitle, rbChange, rbFixed, rbNo, rbYes, rgPriceType, rgReply, tvCoin,
          tvCoinKind, tvCountText, tvCountry, tvOverflow, tvPayTime, tvPayWay, tvPayWayText,
          tvPrice, tvRelease, tvTitle, viewBack);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}