package com.Project.OMRReader.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.Project.OMRReader.Models.RetrofitModels.NewQuizRequest;
import com.Project.OMRReader.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class NewQuizDetailsScreen extends AppCompatActivity {

    TextInputLayout topic, des, initiatedBy;
    CheckBox checkBox;
    TextView date;
    MaterialButton next;
    NewQuizRequest newQuizRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_quiz_details_screen);
        init();
        setOnClick();
    }

    private void setOnClick() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInfo();
                Intent intent = new Intent(getApplicationContext(),AddQuestionScreen.class);
                intent.putExtra("Quiz",newQuizRequest);
                startActivity(intent);
            }
        });
    }

    private void init() {
        topic = findViewById(R.id.topic);
        des = findViewById(R.id.des);
        initiatedBy = findViewById(R.id.InitiatedBy);
        checkBox = findViewById(R.id.negative);
        date = findViewById(R.id.date);
        next = findViewById(R.id.next);
        newQuizRequest = new NewQuizRequest();
    }

    private void getInfo() {
        newQuizRequest.setTopic(topic.getEditText().getText().toString());
        if (des.getEditText().getText().toString().isEmpty())
            newQuizRequest.setDescription("Test");
        else
            newQuizRequest.setDescription(des.getEditText().getText().toString());
        newQuizRequest.setNegative(checkBox.isChecked());
        newQuizRequest.setInitiatedBy(initiatedBy.getEditText().getText().toString());
    }
}