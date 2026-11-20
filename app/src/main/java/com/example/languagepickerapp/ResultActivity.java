package com.example.languagepickerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultText;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultText = findViewById(R.id.resultText);
        backBtn = findViewById(R.id.backBtn);

        String language = getIntent().getStringExtra("LANGUAGE_KEY");
        boolean isMultiple = getIntent().getBooleanExtra("IS_MULTIPLE", false);

        if (language != null) {
            if (isMultiple) {
                resultText.setText(getString(R.string.result_multiple_prefix) + language);
            } else {
                resultText.setText(getString(R.string.result_prefix) + language);
            }
        }

        backBtn.setOnClickListener(v -> {
            finish();
        });
    }
}