package com.Project.OMRReader.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.Project.OMRReader.Models.RetrofitModels.StudentQueryModel;
import com.Project.OMRReader.R;
import com.Project.OMRReader.Services.RetrofitInterface;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentHomeFragment extends Fragment {
    PieChart pieChart;
    int[] color = new int[]{Color.GREEN,Color.RED};
    BarChart barChart;
    private int student_id;
    private Retrofit retrofit;
    private RetrofitInterface service;
    private View view;
    private int totalCorrectAnswer;
    private int totalIncorrectAnswer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_student_home, container, false);
        student_id=getArguments().getInt("id");
        TextView text=(TextView) view.findViewById(R.id.student_enrollment_number);
        retrofit= new Retrofit.Builder()
                .baseUrl("https://omrreaderapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(RetrofitInterface.class);
        text.setText(Integer.toString(student_id));
        pieChart = view.findViewById(R.id.pieChart);
        barChart = view.findViewById(R.id.barChart);
        fetchData();
        setPieChart();
        setBarChart();
        return view;
    }
    private void fetchData(){
        Call<ArrayList<StudentQueryModel>> call = service.getStudentinfo(student_id );
        call.enqueue(new Callback<ArrayList<StudentQueryModel>>() {
            @Override
            public void onResponse(Call<ArrayList<StudentQueryModel>> call, Response<ArrayList<StudentQueryModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(),"Network Error", Toast.LENGTH_LONG);
                return;}
                setResponse(response.body().get(0));
            }
            @Override
            public void onFailure(Call<ArrayList<StudentQueryModel>> call, Throwable t) {
                Toast.makeText(getContext(),"unknown error", Toast.LENGTH_LONG);
            }
        });

    }

    private void setResponse(StudentQueryModel data){
        totalCorrectAnswer=data.getTotalCorrect();
        totalIncorrectAnswer=data.getTotalInCorrect();
        TextView name= view.findViewById(R.id.student_name);
        name.setText(data.getUser_info().getUsername());
        TextView totalCorrect= view.findViewById(R.id.correct_answer);
        totalCorrect.setText(Integer.toString(totalCorrectAnswer));
        TextView totalIncorrect= view.findViewById(R.id.incorrect_answer);
        totalIncorrect.setText(Integer.toString(totalIncorrectAnswer));
        TextView totalMarks= view.findViewById(R.id.total_marks);
        totalMarks.setText(Integer.toString((totalCorrectAnswer*2)));

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
    private void setBarChart(){

        BarDataSet barDataSet = new BarDataSet(data(),"Number Of Students");

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);

        barChart.setData(barData);
        barChart.invalidate();
    }
    private ArrayList<BarEntry> data(){
        ArrayList<BarEntry> list = new ArrayList<>();
        list.add(new BarEntry(10,0));
        list.add(new BarEntry(20,0));
        list.add(new BarEntry(30,3));
        list.add(new BarEntry(40,2));
        list.add(new BarEntry(50,5));
        list.add(new BarEntry(60,6));
        list.add(new BarEntry(70,8));
        list.add(new BarEntry(80,8));
        list.add(new BarEntry(90,5));
        list.add(new BarEntry(100,2));

        return list;

    }

    private ArrayList<PieEntry> pieData() {
        ArrayList<PieEntry> list = new ArrayList<>();
        list.add(new PieEntry(90,"Correct"));
        list.add(new PieEntry(10,"Incorrect"));
        return list;
    }
}