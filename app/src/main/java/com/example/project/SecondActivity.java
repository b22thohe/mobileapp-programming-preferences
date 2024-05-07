package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() {
            @NonNull
            @Override
            public WindowInsetsCompat onApplyWindowInsets(@NonNull View v, @NonNull WindowInsetsCompat insets) {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            }
        });

        // Create SharedPreference object
        myPreferenceRef = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);
        // Create SharedPreference Editor
        myPreferenceEditor = myPreferenceRef.edit();
    }

    // Method to save text to shared preferences
    public void savePref(View v) {
        // Get the text from EditText
        EditText newPrefText = (EditText)findViewById(R.id.settingsText);

        // Store the new preference text
        myPreferenceEditor.putString("MyPreferenceString", newPrefText.getText().toString());
        myPreferenceEditor.apply();

        Log.d("-->SecondActivity", "Saved value: " + newPrefText.getText().toString());

        // Start the MainActivity again
        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
        startActivity(intent);

        // Clear the EditText
        newPrefText.setText("");

        // Finish the SecondActivity
        finish();
    }
}