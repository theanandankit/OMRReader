package com.Project.OMRReader.Models.RetrofitModels;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class QuizResponse implements Parcelable {

    String id;

    String date;

    String answer;

    String answerType;

    boolean negative;

    String description;

    String topic;

    String initiatedBy;

    protected QuizResponse(Parcel in) {
        id = in.readString();
        date = in.readString();
        answer = in.readString();
        answerType = in.readString();
        negative = in.readByte() != 0;
        description = in.readString();
        topic = in.readString();
        initiatedBy = in.readString();
    }

    public static final Creator<QuizResponse> CREATOR = new Creator<QuizResponse>() {
        @Override
        public QuizResponse createFromParcel(Parcel in) {
            return new QuizResponse(in);
        }

        @Override
        public QuizResponse[] newArray(int size) {
            return new QuizResponse[size];
        }
    };

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public boolean isNegative() {
        return negative;
    }

    public void setNegative(boolean negative) {
        this.negative = negative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(date);
        parcel.writeString(answer);
        parcel.writeString(answerType);
        parcel.writeByte((byte) (negative ? 1 : 0));
        parcel.writeString(description);
        parcel.writeString(topic);
        parcel.writeString(initiatedBy);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();

    }
}
