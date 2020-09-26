package com.example.studentdash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    public void toGraph(View view){
        MainActivity.isviewingGraph = true;
        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent1);

    }
    public void toCourses(View view){
        Intent intent2 = new Intent(getApplicationContext(),CourseActivity.class);
        startActivity(intent2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}