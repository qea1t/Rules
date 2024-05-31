package com.example.trafficrules;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView, textTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titleTextView = findViewById(R.id.ruleItemTitle);
        textTextView = findViewById(R.id.ruleItemText);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String text = intent.getStringExtra("text");

            titleTextView.setText(title);

            // Розділити текст на речення та відобразити їх в TextView
            String[] sentences = text.split("\\|");
            StringBuilder formattedText = new StringBuilder();
            for (String sentence : sentences) {
                formattedText.append(sentence.trim()).append("\n"); // trim() для видалення зайвих пробілів
            }
            textTextView.setText(formattedText.toString());
        }
    }
}