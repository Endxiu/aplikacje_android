package com.example.dicegame;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button ThrowDice;
    private TextView Dice_1;
    private TextView Dice_2;
    private TextView Dice_3;
    private TextView Dice_4;
    private TextView Dice_5;
    private TextView Roll_Result;
    private TextView Game_Result;
    private TextView Roll_Count;
    private TextView Reset_Result;
    private int random_Dice1;
    private int random_Dice2;
    private int random_Dice3;
    private int random_Dice4;
    private int random_Dice5;
    private int count;
    int NewScore;
    private int[] results = {random_Dice1,random_Dice2,random_Dice3,random_Dice4,random_Dice5};
    private int[] results2 = {random_Dice1,random_Dice2,random_Dice3,random_Dice4,random_Dice5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThrowDice = findViewById(R.id.ThrowDiceButton);
        Dice_1 = findViewById(R.id.Dice1);
        Dice_2 = findViewById(R.id.Dice2);
        Dice_3 = findViewById(R.id.Dice3);
        Dice_4 = findViewById(R.id.Dice4);
        Dice_5 = findViewById(R.id.Dice5);
        Roll_Result = findViewById(R.id.RollResult);
        Game_Result = findViewById(R.id.GameResult);
        Roll_Count = findViewById(R.id.RollCount);
        Reset_Result = findViewById(R.id.ResetResult);

        ThrowDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();

            }
        });
        Reset_Result.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ResetGame();
            }
        });
    }

    private void rollDice() {
        random_Dice1 = (int) (Math.random() * 6 + 1);
        Dice_1.setText(Integer.toString(random_Dice1));
        random_Dice2 = (int) (Math.random() * 6 + 1);
        Dice_2.setText(Integer.toString(random_Dice2));
        random_Dice3 = (int) (Math.random() * 6 + 1);
        Dice_3.setText(Integer.toString(random_Dice3));
        random_Dice4 = (int) (Math.random() * 6 + 1);
        Dice_4.setText(Integer.toString(random_Dice4));
        random_Dice5 = (int) (Math.random() * 6 + 1);
        Dice_5.setText(Integer.toString(random_Dice5));

        results[0] = random_Dice1;
        results[1] = random_Dice2;
        results[2] = random_Dice3;
        results[3] = random_Dice4;
        results[4] = random_Dice5;

        updateScore();
        updateRollCount();
    }

    void ResetGame(){
        Dice_1.setText("?");
        Dice_2.setText("?");
        Dice_3.setText("?");
        Dice_4.setText("?");
        Dice_5.setText("?");
        Roll_Result.setText("Wynik tego losowania: 0");
        Game_Result.setText("Wynik gry: 0");
        Roll_Count.setText("Liczba rzutów: 0");
        ;}

    void updateRollCount() {
        count++;
        Roll_Result.setText("Wynik tego losowania: " + NewScore);
        Roll_Count.setText("Liczba rzutów: " + count);
    }

    void updateScore() {
        for (int i = 0; i < 5; i++) {
           for (int j = 0; j < 5; j++) {
               if (results[i] == results2[j]) {
                   NewScore = results[i] + results[j];
               }
           }
        }
    }
}