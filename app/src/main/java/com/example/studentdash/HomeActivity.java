package com.example.studentdash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {
    DatabaseReference reference;
    TextView topTextView;
    public void toGraph(View view){
        MainActivity.isviewingGraph = true;
        Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent1);

    }
    public void toCourses(View view){
        Intent intent2 = new Intent(getApplicationContext(),CourseActivity.class);
        startActivity(intent2);
    }

    public void toprofile(View view){
        Intent intent3 = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(intent3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        reference = FirebaseDatabase.getInstance().getReference().child("Student");
        topTextView = findViewById(R.id.topTextView);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot dss: snapshot.getChildren()){
                        //if condition needs to be added for user that has signed in or it will iterate and add all the users available in the
                        //database
                        String userName = dss.getValue().toString();
                        topTextView.setText(userName);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}