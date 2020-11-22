package com.Project.OMRReader.Utilities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.Project.OMRReader.R;

public class LoadingDialog {
    Dialog dialog;
    Context context;
    TextView message;

    public LoadingDialog(Context context) {
        this.context = context;
    }

    public void SetDialog(String s) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.progresslayout);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        message = dialog.findViewById(R.id.progress_message);
        message.setText(s);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setAttributes(lp);
    }

    public void show() {
        dialog.show();
    }


    public void dismiss() {
        dialog.dismiss();
    }

    public void changeText(String s) {
        message.setText(s);
    }
}
