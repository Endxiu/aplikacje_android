package com.example.buttondisableapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonDisable;
    private Button buttonEnable;
    private TextView countText;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDisable = findViewById(R.id.ButtonDisable);
        buttonEnable = findViewById(R.id.ButtonEnable);
        countText = findViewById(R.id.textView2);

        buttonDisable.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                buttonDisable.setEnabled(false);
                count++;
                countText.setText("Counter: "+ count);
                Toast.makeText(MainActivity.this,"Przycisk został wyłączony!",Toast.LENGTH_SHORT).show();
            }
        });
        buttonEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDisable.setEnabled(true);
                Toast.makeText(MainActivity.this,"Przycisk został włączony!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}