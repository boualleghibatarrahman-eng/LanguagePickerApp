package com.example.languagepickerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup languageRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageRadioGroup = findViewById(R.id.languageRadioGroup);
        Button confirmBtn = findViewById(R.id.confirmBtn);
        Button goMultipleBtn = findViewById(R.id.goMultipleBtn);

        confirmBtn.setOnClickListener(v -> {
            int selectedId = languageRadioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, R.string.error_no_selection, Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedRadio = findViewById(selectedId);
            String selectedLanguage = selectedRadio.getText().toString();

            Toast.makeText(this, "You chose: " + selectedLanguage, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("LANGUAGE_KEY", selectedLanguage);
            startActivity(intent);
        });

        goMultipleBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MultipleChoiceActivity.class);
            startActivity(intent);
        });
    }
}