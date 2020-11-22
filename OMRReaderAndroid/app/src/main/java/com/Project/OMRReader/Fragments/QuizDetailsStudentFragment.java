package com.Project.OMRReader.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Project.OMRReader.Adapters.QuizStudentAdapter;
import com.Project.OMRReader.Models.RetrofitModels.StudentQuizListResponse;
import com.Project.OMRReader.R;
import com.Project.OMRReader.RetrofitCalls.Impl.StudentListQuizImpl;
import com.Project.OMRReader.RetrofitCalls.StudentListQuizInterface;

import java.util.ArrayList;

public class QuizDetailsStudentFragment extends Fragment implements StudentListQuizInterface {

    RecyclerView recyclerView;
    QuizStudentAdapter quizStudentAdapter;
    StudentListQuizImpl studentListQuiz;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quizdetailsstudentfragment, container, false);
        init(view);
        setRecyclerView();
        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.recycleView);
        studentListQuiz = new StudentListQuizImpl(this);
        studentListQuiz.get(1);
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void Response(ArrayList<StudentQuizListResponse> responses) {
        quizStudentAdapter = new QuizStudentAdapter(getContext(), responses);
        recyclerView.setAdapter(quizStudentAdapter);
        ;
    }
}
