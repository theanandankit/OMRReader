package com.Project.OMRReader.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Project.OMRReader.Models.RetrofitModels.QuizHomeResponse;
import com.Project.OMRReader.R;
import com.Project.OMRReader.RetrofitCalls.Impl.QuizHomeInfoImpl;
import com.Project.OMRReader.RetrofitCalls.QuizHomeInfoInterface;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class QuizDetailsOverallFragment extends Fragment implements QuizHomeInfoInterface {

    BarChart barChart;
    QuizHomeInfoImpl quizHomeInfo;
    TextView totalStudent,average,topName,topBatch,totalQuestion,type,highest,initiatedBy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quizdetailsoverallfragment,container,false);
        init(view);
        setBarChart();

        return view;
    }
    private void init(View view){
        barChart = view.findViewById(R.id.barChart);
        totalQuestion = view.findViewById(R.id.totalQuestion);
        totalStudent = view.findViewById(R.id.student_total);
        average = view.findViewById(R.id.average);
        topBatch = view.findViewById(R.id.topBatch);
        topName = view.findViewById(R.id.topName);
        type = view.findViewById(R.id.type);
        highest = view.findViewById(R.id.high);
        initiatedBy = view.findViewById(R.id.initiated);
        quizHomeInfo = new QuizHomeInfoImpl(this);
        quizHomeInfo.get(1);
    }

    private void setBarChart(){

        BarDataSet barDataSet = new BarDataSet(data(),"Marks Distribution");

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);

        barChart.setData(barData);
        barChart.invalidate();
    }

    private ArrayList<BarEntry> data(){
        ArrayList<BarEntry> list = new ArrayList<>();
        list.add(new BarEntry(10,0));
        list.add(new BarEntry(20,0));
        list.add(new BarEntry(30,1));
        list.add(new BarEntry(40,2));
        list.add(new BarEntry(50,5));
        list.add(new BarEntry(60,6));
        list.add(new BarEntry(70,8));
        list.add(new BarEntry(80,10));
        list.add(new BarEntry(90,5));
        list.add(new BarEntry(100,0));

        return list;

    }

    @Override
    public void Response(QuizHomeResponse response) {
        totalStudent.setText(response.getTotalStudent());
        average.setText("84");
        topName.setText(response.getMaxStudent().getUser_info().getFirst_name()+" "+response.getMaxStudent().getUser_info().getLast_name());
        topBatch.setText(response.getMaxStudent().getBatch());
        totalQuestion.setText("30");
        highest.setText(response.getQuizinfo().getDate());
        if (response.getQuizinfo().isNegative())
            type.setText("Negative Multiple Choice");
        else
            type.setText("Single correct");
        initiatedBy.setText(response.getQuizinfo().getInitiatedBy());
    }
}
