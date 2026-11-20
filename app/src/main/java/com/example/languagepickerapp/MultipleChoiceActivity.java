package com.example.languagepickerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MultipleChoiceActivity extends AppCompatActivity {

    private CheckBox checkJava, checkJavaScript, checkDart, checkPython, checkCSharp, checkCpp;
    private Button confirmMultipleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);

        checkJava = findViewById(R.id.checkJava);
        checkJavaScript = findViewById(R.id.checkJavaScript);
        checkDart = findViewById(R.id.checkDart);
        checkPython = findViewById(R.id.checkPython);
        checkCSharp = findViewById(R.id.checkCSharp);
        checkCpp = findViewById(R.id.checkCpp);
        confirmMultipleBtn = findViewById(R.id.confirmMultipleBtn);

        confirmMultipleBtn.setOnClickListener(v -> {
            StringBuilder selectedLanguages = new StringBuilder();
            int count = 0;

            if (checkJava.isChecked()) { selectedLanguages.append("Java, "); count++; }
            if (checkJavaScript.isChecked()) { selectedLanguages.append("JavaScript, "); count++; }
            if (checkDart.isChecked()) { selectedLanguages.append("Dart, "); count++; }
            if (checkPython.isChecked()) { selectedLanguages.append("Python, "); count++; }
            if (checkCSharp.isChecked()) { selectedLanguages.append("C#, "); count++; }
            if (checkCpp.isChecked()) { selectedLanguages.append("C++, "); count++; }

            if (count == 0) {
                Toast.makeText(this, R.string.error_select_at_least_one, Toast.LENGTH_SHORT).show();
                return;
            }

            String finalResult = selectedLanguages.toString();
            if (finalResult.endsWith(", ")) {
                finalResult = finalResult.substring(0, finalResult.length() - 2);
            }

            Intent intent = new Intent(MultipleChoiceActivity.this, ResultActivity.class);
            intent.putExtra("LANGUAGE_KEY", finalResult);
            intent.putExtra("IS_MULTIPLE", true);
            startActivity(intent);
        });
    }
}