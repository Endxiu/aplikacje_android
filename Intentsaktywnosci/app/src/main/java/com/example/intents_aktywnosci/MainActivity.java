package com.example.intents_aktywnosci;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView email = findViewById(R.id.email);
        String message = getIntent().getStringExtra("message");
        email.setText(message);
        Button buttonNewA = findViewById(R.id.newActivity);
        buttonNewA.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("message","mmemememe");
            startActivity(intent);
        });
        }
    }