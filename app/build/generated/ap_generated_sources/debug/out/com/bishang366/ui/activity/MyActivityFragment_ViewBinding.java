// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bishang366.R;
import com.bishang366.customview.VpSwipeRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyActivityFragment_ViewBinding implements Unbinder {
  private MyActivityFragment target;

  @UiThread
  public MyActivityFragment_ViewBinding(MyActivityFragment target, View source) {
    this.target = target;

    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refreshLayout, "field 'refreshLayout'", VpSwipeRefreshLayout.class);
    target.listview = Utils.findRequiredViewAsType(source, R.id.listview, "field 'listview'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyActivityFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.refreshLayout = null;
    target.listview = null;
  }
}
