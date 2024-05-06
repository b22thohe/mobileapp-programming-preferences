package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    // Member variables
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    private String myPreferenceData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create SharedPreference object
        myPreferenceRef = getPreferences(MODE_PRIVATE);
        // Create SharedPreference Editor
        myPreferenceEditor = myPreferenceRef.edit();

        // Read data from SharedPreference
        TextView prefTextRef = new TextView(this);
        prefTextRef = (TextView)findViewById(R.id.myTextView);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference string found!"));


        // Add button object
        Button myButton = findViewById(R.id.myButton);
        // Add click listener to button
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("-->", "myButton in MainActivity was pressed!");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    // Getter for myPreferenceData
    public String getMyPreferenceData() {
        return myPreferenceData;
    }

    // Setter for myPreferenceData
    public void setMyPreferenceData(String str) {
        myPreferenceData = str;
        Log.d("--> myPreferenceData: ", str);
    }
}
