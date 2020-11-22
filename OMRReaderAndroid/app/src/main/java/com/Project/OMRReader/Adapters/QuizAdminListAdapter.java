package com.Project.OMRReader.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Project.OMRReader.Activity.QuizDetailsScreen;
import com.Project.OMRReader.Models.RetrofitModels.QuizResponse;
import com.Project.OMRReader.R;

import java.util.ArrayList;

public class QuizAdminListAdapter extends RecyclerView.Adapter<QuizAdminListAdapter.quizholder> {

    private Context context;
    private ArrayList<QuizResponse> responses;

    public QuizAdminListAdapter(Context context, ArrayList<QuizResponse> responses) {
        this.context = context;
        this.responses = responses;
    }

    @NonNull
    @Override
    public QuizAdminListAdapter.quizholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.quizadminitem, parent, false);
        return new quizholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull QuizAdminListAdapter.quizholder holder, final int position) {
        holder.id.setText(responses.get(position).getId());
        holder.date.setText(responses.get(position).getDate());
        if (responses.get(position).isNegative()) {
            holder.type.setText("Negative Multiple Correct");
        } else {
            holder.type.setText("Multiple Correct");
        }
        holder.total.setText("21");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startActivity(new Intent(context, QuizDetailsScreen.class));
                Intent quizDetailIntent = new Intent(context,QuizDetailsScreen.class);
                quizDetailIntent.putExtra("data",responses.get(position));
                context.startActivity(quizDetailIntent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return responses.size();
    }

    class quizholder extends RecyclerView.ViewHolder {

        TextView id, date, type, total;

        public quizholder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            date = itemView.findViewById(R.id.date);
            type = itemView.findViewById(R.id.type);
            total = itemView.findViewById(R.id.total);
        }
    }
}