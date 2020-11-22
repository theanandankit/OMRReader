package com.Project.OMRReader.Models.RetrofitModels;

import com.google.gson.annotations.SerializedName;

public class StudentInfoResponse {
    @SerializedName("Token")
    private String token;
    @SerializedName("Id")
    private int id;

    public void setToken(String token){ this.token=token; }

    public void setId(int id) { this.id = id; }

    public String getToken(){ return token; }

    public int getId() {
        return id;
    }
}
