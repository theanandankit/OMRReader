package com.Project.OMRReader.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Project.OMRReader.R;

public class WelcomeScreen extends AppCompatActivity {

    Button loginTeacher,loginStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        loginTeacher= (Button) findViewById(R.id.loginTeacher);
        loginStudent= (Button) findViewById(R.id.loginStudent);

        loginTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginTeacher();
            }
        });
        loginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginStudent();
            }
        });
    }

    public void openLoginTeacher(){
        Intent intent=new Intent(WelcomeScreen.this,loginActivity.class);
        startActivity(intent);
    }
    public void openLoginStudent(){
        Intent intent=new Intent(WelcomeScreen.this,StudentLoginActivity.class);
        startActivity(intent);
    }

}