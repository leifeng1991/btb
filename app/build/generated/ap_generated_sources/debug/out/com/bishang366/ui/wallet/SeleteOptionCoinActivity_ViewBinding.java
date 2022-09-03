// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.wallet;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bishang366.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SeleteOptionCoinActivity_ViewBinding implements Unbinder {
  private SeleteOptionCoinActivity target;

  private View view2131296579;

  @UiThread
  public SeleteOptionCoinActivity_ViewBinding(SeleteOptionCoinActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SeleteOptionCoinActivity_ViewBinding(final SeleteOptionCoinActivity target, View source) {
    this.target = target;

    View view;
    target.llTitle = Utils.findRequiredViewAsType(source, R.id.llTitle, "field 'llTitle'", LinearLayout.class);
    target.rvCoins = Utils.findRequiredViewAsType(source, R.id.rv_coins, "field 'rvCoins'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ibBack, "method 'onViewClicked'");
    view2131296579 = view;
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
    SeleteOptionCoinActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llTitle = null;
    target.rvCoins = null;

    view2131296579.setOnClickListener(null);
    view2131296579 = null;
  }
}
