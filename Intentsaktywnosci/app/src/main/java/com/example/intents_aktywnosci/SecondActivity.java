package com.example.intents_aktywnosci;

import android.os.Bundle;
import android.widget.Button;
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

        TextView notif = findViewById(R.id.notification);
        String message = getIntent().getStringExtra("message");
        notif.setText(message);
        Button buttonoldA = findViewById(R.id.SecActivityButton);
        buttonoldA.setOnClickListener(v -> {finish();});
    }
}