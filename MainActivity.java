package com.example.gamedice1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewPlayerA;
    private TextView textViewPlayerB;
    private TextView textViewWinner;
    private Button buttonRoll;

    private int playerAScore;
    private int playerBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayerA = findViewById(R.id.textViewPlayerA);
        textViewPlayerB = findViewById(R.id.textViewPlayerB);
        textViewWinner = findViewById(R.id.textViewWinner);
        buttonRoll = findViewById(R.id.buttonRoll);

        if (savedInstanceState != null) {
            playerAScore = savedInstanceState.getInt("playerAScore", 0);
            playerBScore = savedInstanceState.getInt("playerBScore", 0);
            textViewPlayerA.setText("Player A: " + playerAScore);
            textViewPlayerB.setText("Player B: " + playerBScore);
        }

        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("playerAScore", playerAScore);
        outState.putInt("playerBScore", playerBScore);
    }

    private void rollDice() {
        Random random = new Random();
        playerAScore = random.nextInt(6) + 1;
        playerBScore = random.nextInt(6) + 1;

        textViewPlayerA.setText("Player A: " + playerAScore);
        textViewPlayerB.setText("Player B: " + playerBScore);

        determineWinner();
    }

    private void determineWinner() {
        if (playerAScore > playerBScore) {
            textViewWinner.setText("Player A WON!");
        } else if (playerBScore > playerAScore) {
            textViewWinner.setText("Player B WON!");
        } else {
            textViewWinner.setText("It's a tie!");
        }
    }
}
