// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bishang366.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ETHMarketFragment_ViewBinding implements Unbinder {
  private ETHMarketFragment target;

  @UiThread
  public ETHMarketFragment_ViewBinding(ETHMarketFragment target, View source) {
    this.target = target;

    target.rvContent = Utils.findRequiredViewAsType(source, R.id.rvContent, "field 'rvContent'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ETHMarketFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvContent = null;
  }
}
