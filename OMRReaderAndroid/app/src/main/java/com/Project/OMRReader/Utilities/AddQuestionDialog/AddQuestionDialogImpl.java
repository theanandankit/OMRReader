package com.Project.OMRReader.Utilities.AddQuestionDialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.Project.OMRReader.Models.AddQuestionModel;
import com.Project.OMRReader.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class AddQuestionDialogImpl {

    Dialog dialog;
    Context context;
    TextView text;
    CheckBox multiple;
    RadioButton optionA,optionB,optionC,optionD;
    AddQuestionDialogInterface addQuestionDialogInterface;
    MaterialButton button;
    boolean multiCheck = false;
    int questionNo;

    public AddQuestionDialogImpl(Context context,AddQuestionDialogInterface addQuestionDialogInterface){
        this.context = context;
        this.addQuestionDialogInterface = addQuestionDialogInterface;
    }

    public void set(){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.addquestiondialog);
        dialog.setCancelable(false);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        init(dialog);
        setOnclick();
        cleanAll();
        text.setText("");
        multiple.setChecked(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setAttributes(lp);
    }

    public void show(int n){
        questionNo = n;
        cleanAll();
        text.setText("Question No. "+String.valueOf(n));
        dialog.show();
    }

    private void init(Dialog dialog){
        text = dialog.findViewById(R.id.question);
        button = dialog.findViewById(R.id.add);
        multiple =dialog.findViewById(R.id.multiple);
        optionA = dialog.findViewById(R.id.optionA);
        optionB = dialog.findViewById(R.id.optionB);
        optionC = dialog.findViewById(R.id.optionC);
        optionD = dialog.findViewById(R.id.optionD);
    }

    private void cleanAll(){
        optionA.setChecked(false);
        optionB.setChecked(false);
        optionC.setChecked(false);
        optionD.setChecked(false);

    }

    private void setOnclick(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddQuestionModel addQuestionModel =new AddQuestionModel();
                ArrayList<String> list = new ArrayList<>();

                Log.e("ok", String.valueOf(check()));

                if (check()) {
                    if (optionA.isChecked())
                        list.add("A");
                    if (optionB.isChecked())
                        list.add("B");
                    if (optionC.isChecked())
                        list.add("C");
                    if (optionD.isChecked())
                        list.add("D");
                    addQuestionModel.setAnswer(list);
                    addQuestionModel.setQuestionNo(questionNo);
                    addQuestionDialogInterface.Response(addQuestionModel);
                    dialog.dismiss();
                }
            }
        });

        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanAll();
                if (!multiple.isChecked()){
                    multiCheck = false;
                } else {
                    multiCheck = true;
                }
            }
        });
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!multiCheck)
                    cleanAll();
                optionA.setChecked(true);
            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!multiCheck)
                    cleanAll();
                optionB.setChecked(true);
            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!multiCheck)
                    cleanAll();
                optionC.setChecked(true);
            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!multiCheck)
                    cleanAll();
                optionD.setChecked(true);
            }
        });
    }
    private boolean check(){
            if (optionA.isChecked()||optionB.isChecked()||optionC.isChecked()||optionD.isChecked())
                return true;
            else
                return false;
    }
}
