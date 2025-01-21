package com.example.intents_aktywnosci;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView notif = findViewById(R.id.notif);
        String message = getIntent().getStringExtra("message");
        notif.setText(message);
        Button buttonoldA = findViewById(R.id.backActivity);
        EditText email = findViewById(R.id.email);
        buttonoldA.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            intent.putExtra("message", email.getText().toString().trim());
            startActivity(intent);
    });
    }
}