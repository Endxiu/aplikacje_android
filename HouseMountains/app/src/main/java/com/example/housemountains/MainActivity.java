package com.example.housemountains;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button Like;
    private Button Delete;
    private Button Save;
    private TextView LikeText;
    private int LikeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Like = findViewById(R.id.likeButton);
        Delete = findViewById(R.id.deleteButton);
        Save = findViewById(R.id.saveButton);
        LikeText = findViewById(R.id.likeText);
        Like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LikeCounter();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteCounter();
            }
        });
}

    void LikeCounter() {
        LikeCount++;
        LikeText.setText(LikeCount + " polubień");
    }

    void DeleteCounter() {
        if(LikeCount != 0) {
            LikeCount--;
            LikeText.setText(LikeCount + " polubień");
        }
    }
}