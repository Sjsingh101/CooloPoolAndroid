package com.coolopool.coolopool.Helper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
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
        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(mViewId);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        dialog.setCancelable(true);
        dialog.show();
    }

    public void destroy(){
        dialog.dismiss();
    }

    public Dialog getDialog() {
        return dialog;
    }
}
