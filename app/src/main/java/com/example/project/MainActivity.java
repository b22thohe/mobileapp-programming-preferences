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
        myPreferenceRef = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);
        // Create SharedPreference Editor
        myPreferenceEditor = myPreferenceRef.edit();

        // Read data from SharedPreference
        loadStringFromPreferences();


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

    @Override
    protected void onResume() {
        Log.d("-->", "Inside onResume!");
        super.onResume();
        loadStringFromPreferences();
    }

    // Method to load string from shared preferences and display in textview
    private void loadStringFromPreferences() {
        String preferenceString = myPreferenceRef.getString("MyPreferenceString", "No preference string found!");

        Log.d("MainActivity", "Loaded value: " + preferenceString);

        // Read data from SharedPreference
        TextView prefTextRef = (TextView)findViewById(R.id.myTextView);
        prefTextRef.setText(myPreferenceRef.getString("MyPreferenceString", "No preference string found!"));
    }
}
