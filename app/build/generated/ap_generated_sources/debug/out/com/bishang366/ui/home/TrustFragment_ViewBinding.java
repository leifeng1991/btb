// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bishang366.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TrustFragment_ViewBinding implements Unbinder {
  private TrustFragment target;

  @UiThread
  public TrustFragment_ViewBinding(TrustFragment target, View source) {
    this.target = target;

    target.rvTrust = Utils.findRequiredViewAsType(source, R.id.rv_trust, "field 'rvTrust'", RecyclerView.class);
    target.tvNoData = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'tvNoData'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TrustFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvTrust = null;
    target.tvNoData = null;
  }
}
