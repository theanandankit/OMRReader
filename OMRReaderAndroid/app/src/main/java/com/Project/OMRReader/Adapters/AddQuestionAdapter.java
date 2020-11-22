package com.Project.OMRReader.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Project.OMRReader.Models.AddQuestionModel;
import com.Project.OMRReader.R;

import java.util.ArrayList;

public class AddQuestionAdapter extends RecyclerView.Adapter<AddQuestionAdapter.Addquestionholder> {

    Context context;
    ArrayList<AddQuestionModel> list;

    public AddQuestionAdapter(Context context, ArrayList<AddQuestionModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AddQuestionAdapter.Addquestionholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.questionitem, parent, false);
        return new Addquestionholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddQuestionAdapter.Addquestionholder holder, int position) {
        holder.questionNo.setText("Q.No. " + String.valueOf(list.get(position).getQuestionNo()));
        if (list.get(position).getAnswer().size() > 1) {
            holder.type.setText("Multiple Choice");
        } else
            holder.type.setText("Single Choice");

        String answer = "";
        for (int a = 0; a < list.get(position).getAnswer().size(); a++)
            answer = answer + " " + list.get(position).getAnswer().get(a);
        holder.answer.setText(answer);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Addquestionholder extends RecyclerView.ViewHolder {
        TextView questionNo, type, answer;

        public Addquestionholder(@NonNull View itemView) {
            super(itemView);

            questionNo = itemView.findViewById(R.id.questionNo);
            type = itemView.findViewById(R.id.Type);
            answer = itemView.findViewById(R.id.answer);
        }
    }
}
