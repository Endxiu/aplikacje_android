package com.example.statemanagementextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import android.graphics.Color;
import android.widget.CompoundButton;


public class MainActivity extends AppCompatActivity {

    private CountViewModel countViewModel;
    private TextView textViewCount;
    private CheckBox checkbox;
    private Switch switchbutton;
    private ConstraintLayout layout;
    private TextView textchecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        updateCountText();
        checkbox = findViewById(R.id.Checkbox);
        switchbutton = findViewById(R.id.Switchbutton);
        layout = findViewById(R.id.main);
        textchecked = findViewById(R.id.TextChecked);

        switchbutton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                layout.setBackgroundColor(Color.GRAY);
            } else {
                layout.setBackgroundColor(Color.BLACK);
            }
        });

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked) {
                    textchecked.setVisibility(View.VISIBLE);
                } else {
                    textchecked.setVisibility(View.GONE);
                }
            }
        });

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countViewModel.incrementCount();
                updateCountText();
            }
        });
    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + countViewModel.getCount());
    }
}
