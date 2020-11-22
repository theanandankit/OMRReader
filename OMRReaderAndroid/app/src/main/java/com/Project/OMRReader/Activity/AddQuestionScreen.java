package com.Project.OMRReader.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.Project.OMRReader.Adapters.AddQuestionAdapter;
import com.Project.OMRReader.Models.AddQuestionModel;
import com.Project.OMRReader.Models.RetrofitModels.NewQuizRequest;
import com.Project.OMRReader.Models.RetrofitModels.ResponseStatus;
import com.Project.OMRReader.R;
import com.Project.OMRReader.RetrofitCalls.CreateQuizInterface;
import com.Project.OMRReader.RetrofitCalls.Impl.CreateQuizImpl;
import com.Project.OMRReader.Utilities.AddQuestionDialog.AddQuestionDialogImpl;
import com.Project.OMRReader.Utilities.AddQuestionDialog.AddQuestionDialogInterface;
import com.Project.OMRReader.Utilities.ConvertToString;
import com.Project.OMRReader.Utilities.LoadingDialog;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class AddQuestionScreen extends AppCompatActivity implements AddQuestionDialogInterface, CreateQuizInterface {

    MaterialButton button, push;
    AddQuestionDialogImpl addQuestionDialog;
    AddQuestionAdapter addQuestionAdapter;
    RecyclerView recyclerView;
    ArrayList<AddQuestionModel> list;
    NewQuizRequest newQuizRequest;
    CreateQuizImpl createQuiz;
    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question_screen);
        init();
        setButton();

    }

    private void init() {
        button = findViewById(R.id.add);
        recyclerView = findViewById(R.id.recycleView);
        push = findViewById(R.id.push);
        loadingDialog = new LoadingDialog(AddQuestionScreen.this);
        loadingDialog.SetDialog("Creating Quiz ...");
        createQuiz = new CreateQuizImpl(AddQuestionScreen.this);
        newQuizRequest = (NewQuizRequest) getIntent().getSerializableExtra("Quiz");
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        addQuestionAdapter = new AddQuestionAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(addQuestionAdapter);
        addQuestionDialog = new AddQuestionDialogImpl(AddQuestionScreen.this, this);
        addQuestionDialog.set();
    }

    private void setButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addQuestionDialog.show(list.size() + 1);
            }
        });
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConvertToString convertToString = new ConvertToString(list);
                newQuizRequest.setAnswer(convertToString.getAnswer());
                newQuizRequest.setAnswerType(convertToString.getAnswerType());
                createQuiz.get(newQuizRequest);
                loadingDialog.show();
            }
        });
    }

    @Override
    public void Response(AddQuestionModel response) {
        list.add(response);
        addQuestionAdapter.notifyDataSetChanged();
    }

    @Override
    public void Response(ResponseStatus responseStatus) {
        loadingDialog.dismiss();
        Toast.makeText(getApplicationContext(), "Quiz Created", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), AdminHomeScreen.class));
        finishAffinity();
    }
}