package com.example.trafficrules;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    private Button button;
    private TextView textQuestion,textViewA,textViewB,textViewC;
    private EditText editText;

    private String[] question = {"На гірських дорогах і крутих спусках, де зустрічний роз'їзд утруднено, дати дорогу повинен",
            "Адміністративне затримання особи, яка вчинила адміністративне правопорушення, може тривати не більше ніж:",
            "За дотримання яких з умов дозволяється експлуатація транспортних составів у складі автомобіля і причепа?",
            "Чи обов'язкове встановлення знака аварійної зупинки у випадку ДТП?",
            };
    private String[] VariantA = {"a) Водій транспортного засобу з найбільшими габаритами.",
            "a) П'ять годин.",
            "a) За наявності гальмової системи у причепа",
            "a) Обов'язкове у будь-якому випадку."};
    private String[] VariantB = {"b) Водій транспортного засобу, що рухається на підйом.",
            "b) Три години.",
            "b) За умови відповідності причепа тягачу і виконання вимог щодо їхньої експлуатації.",
            "b) Обов'язкове, тільки поза населених пунктів."};
    private String[] VariantC = {"c) Водій транспортного засобу, що рухається на спуск.",
            "c) Чотири години.",
            "c) За дотримання всіх перерахованих вище умов.",
            "c) Обов'язкове, тільки якщо є постраждалі."};

    private String[] answer = {"c","b","c","b"};


    private int i = 0;

    private int rating = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test);

        button = findViewById(R.id.button);
        textQuestion = findViewById(R.id.textQuestion);
        textViewA = findViewById(R.id.textView7);
        textViewB = findViewById(R.id.textView8);
        textViewC = findViewById(R.id.textView9);
        editText = findViewById(R.id.editTextText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 0){
                    button.setText("Next Question");
                }

                textQuestion.setText(question[i]);
                textViewA.setText(VariantA[i]);
                textViewB.setText(VariantB[i]);
                textViewC.setText(VariantC[i]);

                rating+=10;
                if(editText.getText().toString() == answer[i]){
                    rating+=1;
                }
                i++;

                if(i == 4){
                    startActivity(new Intent(TestActivity.this, ResultActivity.class));
                    Intent intent = new Intent(TestActivity.this, ResultActivity.class);
                    intent.putExtra("Point ",String.valueOf(rating));
                    startActivity(intent);
                }
                editText.setText("");


            }
        });






    }
}