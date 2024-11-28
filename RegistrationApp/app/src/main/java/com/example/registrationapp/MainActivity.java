package com.example.registrationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Patterns;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText EmailText;
    private EditText PasswordText;
    private EditText RepPasswordText;
    private TextView NotifText;
    private Button SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmailText = findViewById(R.id.emailEdit);
        PasswordText = findViewById(R.id.passwordEdit);
        RepPasswordText = findViewById(R.id.passwordrepeatEdit);
        NotifText = findViewById(R.id.NotificationText);
        SubmitButton = findViewById(R.id.submitButton);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check();
            }
        });
    }

    void Check() {
        String email = EmailText.getText().toString().trim();
        String password = PasswordText.getText().toString().trim();
        String reppassword = RepPasswordText.getText().toString().trim();

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            NotifText.setText("Nieprawidłowy adres e-mail!");
        }
        else if(!reppassword.equals(password)) {
            NotifText.setText("Hasła się różnią!");
        } else {
            NotifText.setText("Witaj " + email);
        }
    }
}