package com.threezfashions.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class home extends AppCompatActivity {

    private EditText ed1, ed2, ed3, ed4, ed5;
    private Button button, button2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        //Click button 1 to upload data to Firebase-Database

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              // Write a message to the database
              FirebaseDatabase database = FirebaseDatabase.getInstance();
              DatabaseReference myRef = database.getReference("Storage");
                 //
              myRef.setValue("Name : " + ed1 + "Email : " + ed2 + "Phone : " + ed3 + "Password : " + ed4 + "description : " + ed5);
          }
      });
      //Click button 2 to Go data Activity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this , data.class);
                startActivity(intent);
            }
        });
    }
}