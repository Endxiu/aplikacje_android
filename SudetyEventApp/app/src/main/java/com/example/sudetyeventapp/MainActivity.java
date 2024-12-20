package com.example.sudetyeventapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView counter;
    private TextView infotext;
    private Button likebutton;
    private Button removebutton;
    private Button seeuserbutton;
    private Button savebutton;
    private EditText emailedit;
    private EditText passwordedit;
    private EditText repeatpasswordedit;
    public int count=0;
    public String rightemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        likebutton = findViewById(R.id.LikeButton);
        removebutton = findViewById(R.id.RemoveButton);
        seeuserbutton = findViewById(R.id.SeeUserButton);
        savebutton = findViewById(R.id.SaveButton);
        counter = findViewById(R.id.counter);
        infotext = findViewById(R.id.InfoText);
        emailedit = findViewById(R.id.EmailEdit);
        passwordedit = findViewById(R.id.PasswordEdit);
        repeatpasswordedit = findViewById(R.id.RepeatPasswordEdit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        likebutton.setOnClickListener(v -> addLike());
        removebutton.setOnClickListener(v -> removeLike());
        savebutton.setOnClickListener(v -> saveinfo());
        seeuserbutton.setOnClickListener(v -> showinfo());
    }
    void addLike(){
        count += 1;
        counter.setText(count + " polubień");
    }
    void removeLike(){
        if (count>0) {
            count -= 1;
            counter.setText(count + " polubień");
        }
    }
    void saveinfo(){
        if(emailedit.getText().toString().contains("@")){
            if(passwordedit.getText().toString().equals(repeatpasswordedit.getText().toString())){
                infotext.setText("Zarejestrowano " + emailedit.getText().toString());
                rightemail = emailedit.getText().toString();
            }
            else{
                infotext.setText("Hasła się różnią");
            };
        }else{
            infotext.setText("Nieprawidłowy adres e-mail");
        }
    }
    void showinfo(){
        infotext.setText(rightemail);
    }
}