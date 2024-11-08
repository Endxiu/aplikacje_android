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
    private int GameScore;
    private int[] Results = {0,0,0,0,0};
    private int[] Results2 = {0,0,0,0,0};
    private int Countnumber = 1;
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

        Results[0] = random_Dice1;
        Results[1] = random_Dice2;
        Results[2] = random_Dice3;
        Results[3] = random_Dice4;
        Results[4] = random_Dice5;

        updateScore();
        updateRollCount();
    }

    void ResetGame(){
        count = 0;
        NewScore = 0;
        GameScore = 0;
        Dice_1.setText("?");
        Dice_2.setText("?");
        Dice_3.setText("?");
        Dice_4.setText("?");
        Dice_5.setText("?");
        Roll_Result.setText("Wynik tego losowania: " + NewScore);
        Game_Result.setText("Wynik gry: " + GameScore);
        Roll_Count.setText("Liczba rzutów: " + count);
        ;}

    void updateRollCount() {
        count++;
        Roll_Result.setText("Wynik tego losowania: " + NewScore);
        Game_Result.setText("Wynik gry: " + GameScore);
        Roll_Count.setText("Liczba rzutów: " + count);
    }

    void updateScore() {
        for(int i=0; i<5; i++){
            Countnumber = 1;
            for(int j=i+1; j<5; j++){
                if(Results[i] == Results[j] && Results2[j] == 0){
                    if(Countnumber == 1){
                        NewScore += Results[i] + Results[j];
                    } else {
                        NewScore += Results[j];
                    };

                    Results2[j] = Results[j];
                    Countnumber++;
                };
            };
        };

        GameScore += NewScore;
    }
}