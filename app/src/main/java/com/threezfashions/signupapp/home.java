package com.threezfashions.signupapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class home extends AppCompatActivity {
 public DatabaseReference dbr;
    private EditText ed1, ed2, ed3, ed4, ed5;
    private Button button, button2;
    private TextView Data_text_view;
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
        Data_text_view = findViewById(R.id.Data_text_view);

        //Click button 1 to upload data to Firebase-Database

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              // Write a message to the database
              FirebaseDatabase database = FirebaseDatabase.getInstance();
               dbr = database.getReference("Storage");
                 //
              dbr.setValue("Name : " + ed1 + "Email : " + ed2 + "Phone : " + ed3 + "Password : " + ed4 + "description : " + ed5);
          }
      });

      button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              // Read from the database
              dbr.addValueEventListener(new ValueEventListener() {
                  @Override
                  public void onDataChange(DataSnapshot dataSnapshot) {
                      // This method is called once with the initial value and again
                      // whenever data at this location is updated.
                      String value = dataSnapshot.getValue(String.class);
                      Log.d(TAG, "This is Data :  " + Data_text_view);
                  }



                  @Override
                  public void onCancelled(DatabaseError error) {
                      // Failed to read value
                      Log.w(TAG, "Failed to read value.", error.toException());
                  }
              });
          }
      });

    }
}