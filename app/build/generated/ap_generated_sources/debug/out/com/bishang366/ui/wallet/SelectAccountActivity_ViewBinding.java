// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.wallet;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bishang366.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectAccountActivity_ViewBinding implements Unbinder {
  private SelectAccountActivity target;

  private View view2131296578;

  private View view2131296826;

  private View view2131296851;

  @UiThread
  public SelectAccountActivity_ViewBinding(SelectAccountActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelectAccountActivity_ViewBinding(final SelectAccountActivity target, View source) {
    this.target = target;

    View view;
    target.llTitle = Utils.findRequiredViewAsType(source, R.id.llTitle, "field 'llTitle'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ibBack, "method 'onViewClicked'");
    view2131296578 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_constract, "method 'onViewClicked'");
    view2131296826 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_wealth_management, "method 'onViewClicked'");
    view2131296851 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectAccountActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llTitle = null;

    view2131296578.setOnClickListener(null);
    view2131296578 = null;
    view2131296826.setOnClickListener(null);
    view2131296826 = null;
    view2131296851.setOnClickListener(null);
    view2131296851 = null;
  }
}
