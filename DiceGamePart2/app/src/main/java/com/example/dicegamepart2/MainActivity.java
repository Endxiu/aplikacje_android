package com.example.dicegamepart2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private TextView Kostka1;
    private TextView Kostka2;
    private TextView Kostka3;
    private TextView Kostka4;
    private TextView Kostka5;
    private int rkosc1;
    private int rkosc2;
    private int rkosc3;
    private int rkosc4;
    private int rkosc5;
    private Button roll_dices;
    private Button reset;
    private TextView liczba_rzutow;
    private TextView wynik_losowania;
    private TextView wynik_gry;
    private int iwynikt;
    private int iwynikp;
    private final int[] wyniki = {rkosc1,rkosc2,rkosc3,rkosc4,rkosc5};
    private int count;
    private int amount1;
    private int amount2;
    private int[] tabimgs;
    private ImageView[] tabplcs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liczba_rzutow = findViewById(R.id.liczba_rzutow);
        wynik_losowania = findViewById(R.id.wynik_losowania);
        wynik_gry = findViewById(R.id.wynik_gry);
        roll_dices = findViewById(R.id.roll_dices);
        Kostka1 = findViewById(R.id.Kostka1);
        Kostka2 = findViewById(R.id.Kostka2);
        Kostka3 = findViewById(R.id.Kostka3);
        Kostka4 = findViewById(R.id.Kostka4);
        Kostka5 = findViewById(R.id.Kostka5);
        reset = findViewById(R.id.reset);
        tabimgs = new int[]{R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
        tabplcs = new ImageView[]{findViewById(R.id.imgdice1), findViewById(R.id.imgdice2), findViewById(R.id.imgdice3), findViewById(R.id.imgdice4), findViewById(R.id.imgdice5)};
        roll_dices = findViewById(R.id.roll_dices);
        roll_dices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
                UpdateScore();
            }

        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetCount();
                for (int i=0; i<tabplcs.length; i++) {
                    tabplcs[i].setImageResource(R.drawable.blank);    };
            }
        });
    }
    private void rollDice() {
        iwynikt=0;
        count++;
        wynik_losowania.setText("Wynik losowania: 0");
        liczba_rzutow.setText("Liczba rzutów: " + count);
        rkosc1 = (int) (Math.random() * 6 + 1);
        Kostka1.setText(Integer.toString(rkosc1));
        rkosc2 = (int) (Math.random() * 6 + 1);
        Kostka2.setText(Integer.toString(rkosc2));
        rkosc3 = (int) (Math.random() * 6 + 1);
        Kostka3.setText(Integer.toString(rkosc3));
        rkosc4 = (int) (Math.random() * 6 + 1);
        Kostka4.setText(Integer.toString(rkosc4));
        rkosc5 = (int) (Math.random() * 6 + 1);
        Kostka5.setText(Integer.toString(rkosc5));
        wyniki[0] = rkosc1;
        wyniki[1] = rkosc2;
        wyniki[2] = rkosc3;
        wyniki[3] = rkosc4;
        wyniki[4] = rkosc5;
        for(int i=0; i<tabplcs.length;i++) {
            tabplcs[i].setImageResource(tabimgs[wyniki[i]-1]);    }
        iwynikt=rkosc1+rkosc2;
    }

    void ResetCount(){
        liczba_rzutow.setText("Liczba rzutów: 0");
        wynik_losowania.setText("Wynik losowania: 0");
        wynik_gry.setText("Wynik gry: 0");
        Kostka1.setText("?");
        Kostka2.setText("?");
        Kostka3.setText("?");
        Kostka4.setText("?");
        Kostka5.setText("?");
        ;}
    void UpdateScore() {
        int[] czestosc = new int[7];
        for (int wartosc : wyniki) {
            czestosc[wartosc]++;
        }
        iwynikt = 0;
        for (int i = 1; i <= 6; i++) {
            if (czestosc[i] > 1) {
                iwynikt += i * czestosc[i];
            }
        }
        iwynikp += iwynikt;
        wynik_losowania.setText("Wynik losowania: " + iwynikt);
        wynik_gry.setText("Wynik gry: " + iwynikp);
    }
}