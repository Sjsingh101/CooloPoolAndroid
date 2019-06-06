package com.coolopool.coolopool.Helper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coolopool.coolopool.R;

public class DialogBuilder {

    private Context mContext;
    private int mViewId;
    private Dialog dialog;

    public DialogBuilder(Context context, int ViewId) {
        mContext = context;
        mViewId = ViewId;
    }

    public void build() {
        dialog = new Dialog(mContext);
        dialog.setContentView(mViewId);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        dialog.show();
    }

    public void reBuild(int viewId){
        destroy();
        mViewId = viewId;
        build();
    }

    public void destroy(){
        dialog.dismiss();
        dialog = null;
        System.gc();
    }

    public Dialog getDialog() {
        return dialog;
    }
}
