package com.Project.OMRReader.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.Project.OMRReader.Fragments.StudentHomeFragment;
import com.Project.OMRReader.Fragments.StudentLeaderboardFragment;
import com.Project.OMRReader.R;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudentHomeScreenActivity extends AppCompatActivity {
    BottomNavigationView studentBottomNavigationView;
    TextView title;
    private StudentHomeFragment studentHomeFragment;
    private StudentLeaderboardFragment studentLeaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_screen);
        Bundle loginData= getIntent().getExtras();
        int studentId= loginData.getInt("id");
        Log.d("ID from login activity",Integer.toString(studentId));
        Bundle bundle_id= new Bundle();
        bundle_id.putInt("id",studentId);
        studentHomeFragment=new StudentHomeFragment();
        studentLeaderboard=new StudentLeaderboardFragment();
        studentHomeFragment.setArguments(bundle_id);
        getViews();
        setDefault();
        studentBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.student_home:
                        title.setText("Home");
                        selectedFragment=studentHomeFragment;
                        break;
                    case R.id.student_leaderboard:
                        title.setText("Leaderboard");
                        selectedFragment=studentLeaderboard;
                        break;
                }


                getSupportFragmentManager().beginTransaction().replace(R.id.student_screen_frame,selectedFragment).commit();


                return true;
            }
        });
    }

    private void getViews()
    {
        studentBottomNavigationView = findViewById(R.id.student_bottom_nav);
        title= findViewById(R.id.student_screen_title);
        title.setText("Home");
    }
    private void setDefault()
    {
     getSupportFragmentManager().beginTransaction().add(R.id.student_screen_frame, studentHomeFragment).commit();
    }


}