// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.setting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bishang366.R;
import com.bishang366.base.LinListView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HelpQitaActivity_ViewBinding implements Unbinder {
  private HelpQitaActivity target;

  @UiThread
  public HelpQitaActivity_ViewBinding(HelpQitaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HelpQitaActivity_ViewBinding(HelpQitaActivity target, View source) {
    this.target = target;

    target.llTitle = Utils.findRequiredViewAsType(source, R.id.llTitle, "field 'llTitle'", LinearLayout.class);
    target.listview_qita = Utils.findRequiredViewAsType(source, R.id.listview_qita, "field 'listview_qita'", LinListView.class);
    target.ibBack = Utils.findRequiredViewAsType(source, R.id.ibBack, "field 'ibBack'", ImageButton.class);
    target.view_back = Utils.findRequiredView(source, R.id.view_back, "field 'view_back'");
  }

  @Override
  @CallSuper
  public void unbind() {
    HelpQitaActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llTitle = null;
    target.listview_qita = null;
    target.ibBack = null;
    target.view_back = null;
  }
}
