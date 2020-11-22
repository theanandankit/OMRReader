package com.Project.OMRReader.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Project.OMRReader.Models.RetrofitModels.StudentQuizListResponse;
import com.Project.OMRReader.R;

import java.util.ArrayList;

public class QuizStudentAdapter extends RecyclerView.Adapter<QuizStudentAdapter.quizStudentHolder> {

    Context context;
    ArrayList<StudentQuizListResponse> responses;

    public QuizStudentAdapter(Context context,ArrayList<StudentQuizListResponse> responses) {
        this.context = context;
        this.responses = responses;

    }

    @NonNull
    @Override
    public QuizStudentAdapter.quizStudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.quizstudentitem, parent, false);
        return new quizStudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizStudentAdapter.quizStudentHolder holder, int position) {

        holder.name.setText(responses.get(position).getStudent().getUser_info().getFirst_name()+" "+responses.get(position).getStudent().getUser_info().getLast_name());
        holder.batch.setText(responses.get(position).getStudent().getBatch());
        holder.marks.setText(responses.get(position).getMarks());
        holder.roll.setText(responses.get(position).getStudent().getRollno());

    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    class quizStudentHolder extends RecyclerView.ViewHolder {

        TextView name,roll,batch,marks;
        public quizStudentHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            roll = itemView.findViewById(R.id.roll);
            batch = itemView.findViewById(R.id.batch);
            marks = itemView.findViewById(R.id.marks);
        }
    }
}
