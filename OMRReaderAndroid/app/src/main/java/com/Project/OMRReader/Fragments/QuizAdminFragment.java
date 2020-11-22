package com.Project.OMRReader.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Project.OMRReader.Activity.NewQuizDetailsScreen;
import com.Project.OMRReader.Adapters.QuizAdminListAdapter;
import com.Project.OMRReader.Models.RetrofitModels.QuizResponse;
import com.Project.OMRReader.R;
import com.Project.OMRReader.RetrofitCalls.Impl.QuizAllImpl;
import com.Project.OMRReader.RetrofitCalls.QuizAllInterface;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class QuizAdminFragment extends Fragment implements QuizAllInterface {

    RecyclerView recyclerView;
    QuizAdminListAdapter quizAdminListAdapter;
    ProgressBar progressBar;
    MaterialButton addQuiz;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_admin_fragment, container, false);
        init(view);
        QuizAllImpl quizAll = new QuizAllImpl(this);
        setOnClick();
        quizAll.get();
        return view;
    }

    private void setOnClick() {
        addQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), NewQuizDetailsScreen.class));
            }
        });
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.recycleView);
        progressBar = view.findViewById(R.id.progress);
        addQuiz = view.findViewById(R.id.add);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setRecyclerView(ArrayList<QuizResponse> responses) {
        quizAdminListAdapter = new QuizAdminListAdapter(getContext(), responses);
        recyclerView.setAdapter(quizAdminListAdapter);
    }

    @Override
    public void response(ArrayList<QuizResponse> response) {
        progressBar.setVisibility(View.GONE);
        setRecyclerView(response);
        recyclerView.setClickable(true);
    }
}
