// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.option;

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

public class CompensationDialogFragment_ViewBinding implements Unbinder {
  private CompensationDialogFragment target;

  @UiThread
  public CompensationDialogFragment_ViewBinding(CompensationDialogFragment target, View source) {
    this.target = target;

    target.btnCancel = Utils.findRequiredViewAsType(source, R.id.btnCancel, "field 'btnCancel'", TextView.class);
    target.rvCurrent = Utils.findRequiredViewAsType(source, R.id.rv_current, "field 'rvCurrent'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CompensationDialogFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnCancel = null;
    target.rvCurrent = null;
  }
}
