package com.Project.OMRReader.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Project.OMRReader.Models.RetrofitModels.AdminHomeResponse;
import com.Project.OMRReader.R;
import com.Project.OMRReader.RetrofitCalls.AdminHomeInfoInterface;
import com.Project.OMRReader.RetrofitCalls.Impl.AdminHomeInfoImpl;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class HomeAdminFragment extends Fragment implements AdminHomeInfoInterface {

    TextView totalStudent,totalQuiz,topName,topBatch,topAccuracy,lastTopic,lastDate,lastType,lastInitiated,quizId;
    AdminHomeInfoImpl adminHomeInfo;
    LineChart totalQuizChart,totalStudentChart;
    PieChart pieChart;

    int[] color = new int[]{Color.GREEN,Color.RED};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_admin_fragment,container,false);

        init(view);
        adminHomeInfo = new AdminHomeInfoImpl(this);
        adminHomeInfo.get();

        return view;
    }

    private void setLastDate(AdminHomeResponse response){
        totalQuiz.setText(String.valueOf(response.getTotalQuiz()));
        totalStudent.setText(String.valueOf(response.getTotalStudent()));
        topName.setText(response.getGainer().getUser_info().getFirst_name()+" "+response.getGainer().getUser_info().getLast_name());
        topBatch.setText(response.getGainer().getBatch());
        topAccuracy.setText(response.getGainer().getAbout());
        lastTopic.setText(response.getLastQuiz().getTopic());
        if (response.getLastQuiz().isNegative())
            lastType.setText("Negative Multiple Correct");
        else
            lastType.setText("Multiple Correct");
        lastInitiated.setText(response.getLastQuiz().getInitiatedBy());
        lastDate.setText(response.getLastQuiz().getDate());
        quizId.setText("Last Quiz: "+response.getLastQuiz().getId());
    }

    private void init(View view){
        totalQuiz = view.findViewById(R.id.quiz);
        totalStudent = view.findViewById(R.id.student);
        topAccuracy = view.findViewById(R.id.topAccuracy);
        topBatch = view.findViewById(R.id.topBatch);
        topName = view.findViewById(R.id.topName);
        lastDate = view.findViewById(R.id.lastDate);
        lastInitiated = view.findViewById(R.id.lastInitiated);
        lastTopic = view.findViewById(R.id.lastTopic);
        lastType = view.findViewById(R.id.lastType);
        quizId = view.findViewById(R.id.quizid);
        totalStudentChart = view.findViewById(R.id.totalStudentChart);
        totalQuizChart = view.findViewById(R.id.totalquizChart);
        pieChart = view.findViewById(R.id.pieChart);
        setTotalQuizChart(totalQuizChart);
        setTotalQuizChart(totalStudentChart);
        setPieChart();
    }

    @Override
    public void response(AdminHomeResponse response) {
            setLastDate(response);
    }
    private void setPieChart(){
        PieDataSet pieDataSet = new PieDataSet(pieData(),"");
        pieDataSet.setColors(color);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setDrawEntryLabels(true);
        pieChart.setUsePercentValues(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.getDescription().setEnabled(false);
        
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    private ArrayList<PieEntry> pieData() {
        ArrayList<PieEntry> list = new ArrayList<>();
        list.add(new PieEntry(60,"Correct"));
        list.add(new PieEntry(40,"wrong"));
        return list;
    }

    private void setTotalQuizChart(LineChart totalQuizChart){
        LineDataSet lineDataSet = new LineDataSet(dataValue(),"Data Set");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        LineData data = new LineData(dataSets);
        totalQuizChart.setData(data);
        totalQuizChart.setTouchEnabled(true);
        totalQuizChart.setClickable(false);
        totalQuizChart.setDoubleTapToZoomEnabled(false);
        totalQuizChart.setDoubleTapToZoomEnabled(false);

        totalQuizChart.setDrawBorders(false);
        totalQuizChart.setDrawGridBackground(false);

        totalQuizChart.getDescription().setEnabled(false);
        totalQuizChart.getLegend().setEnabled(false);
        totalQuizChart.getAxisLeft().setDrawGridLines(false);
        totalQuizChart.getXAxis().setDrawGridLines(false);
        totalQuizChart.getXAxis().setDrawLabels(false);
        totalQuizChart.getXAxis().setDrawAxisLine(false);

        totalQuizChart.getAxisRight().setDrawGridLines(false);
        totalQuizChart.getAxisRight().setDrawLabels(false);
        totalQuizChart.getAxisRight().setDrawAxisLine(false);
        totalQuizChart.invalidate();
    }

    private ArrayList<Entry> dataValue(){
        ArrayList<Entry> dataValue = new ArrayList<>();
        dataValue.add(new Entry(0,0));
        dataValue.add(new Entry(1,2));
        dataValue.add(new Entry(3,1));
        dataValue.add(new Entry(5,1));
        return dataValue;
    }
}

