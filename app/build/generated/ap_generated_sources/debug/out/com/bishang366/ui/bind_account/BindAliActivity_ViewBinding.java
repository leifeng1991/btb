// Generated code from Butter Knife. Do not modify!
package com.bishang366.ui.bind_account;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bishang366.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BindAliActivity_ViewBinding implements Unbinder {
  private BindAliActivity target;

  @UiThread
  public BindAliActivity_ViewBinding(BindAliActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BindAliActivity_ViewBinding(BindAliActivity target, View source) {
    this.target = target;

    target.ibBack = Utils.findRequiredViewAsType(source, R.id.ibBack, "field 'ibBack'", ImageButton.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    target.etName = Utils.findRequiredViewAsType(source, R.id.etName, "field 'etName'", EditText.class);
    target.tvAccount = Utils.findRequiredViewAsType(source, R.id.tvAccount, "field 'tvAccount'", TextView.class);
    target.etAccount = Utils.findRequiredViewAsType(source, R.id.etAccount, "field 'etAccount'", EditText.class);
    target.etNewPwd = Utils.findRequiredViewAsType(source, R.id.etNewPwd, "field 'etNewPwd'", EditText.class);
    target.llQRCode = Utils.findRequiredViewAsType(source, R.id.llQRCode, "field 'llQRCode'", LinearLayout.class);
    target.tvConfirm = Utils.findRequiredViewAsType(source, R.id.tvConfirm, "field 'tvConfirm'", TextView.class);
    target.llTitle = Utils.findRequiredViewAsType(source, R.id.llTitle, "field 'llTitle'", LinearLayout.class);
    target.ivIdFace = Utils.findRequiredViewAsType(source, R.id.ivIdFace, "field 'ivIdFace'", ImageView.class);
    target.ivIdFace1 = Utils.findRequiredViewAsType(source, R.id.ivIdFace1, "field 'ivIdFace1'", ImageView.class);
    target.view_back = Utils.findRequiredView(source, R.id.view_back, "field 'view_back'");
  }

  @Override
  @CallSuper
  public void unbind() {
    BindAliActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ibBack = null;
    target.tvTitle = null;
    target.etName = null;
    target.tvAccount = null;
    target.etAccount = null;
    target.etNewPwd = null;
    target.llQRCode = null;
    target.tvConfirm = null;
    target.llTitle = null;
    target.ivIdFace = null;
    target.ivIdFace1 = null;
    target.view_back = null;
  }
}
