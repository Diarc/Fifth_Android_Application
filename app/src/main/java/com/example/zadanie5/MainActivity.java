package com.example.zadanie5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText minNumber, maxNumber, playerNumber, tryNumber;
    int rndNumber;
    int showTryNumber;
    String stringTryNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minNumber = (EditText)findViewById(R.id.MinText);
        maxNumber = (EditText)findViewById(R.id.MaxText);
        playerNumber = (EditText)findViewById(R.id.PlayerNumberText);
        tryNumber = (EditText)findViewById(R.id.TryNumberText);
    }

    public void RandomNumberButton(View view){
        if(minNumber.getText().toString().equals("") || maxNumber.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Wpisz oba przedziały liczbowe.", Toast.LENGTH_SHORT).show();
        }
        else{
            int minimalNumber = Integer.valueOf(minNumber.getText().toString());
            int maximalNumber = Integer.valueOf(maxNumber.getText().toString());
            Random rand = new Random();
            rndNumber = rand.nextInt(maximalNumber - minimalNumber + 1) + minimalNumber;
        }
    }

    public void PlayButton(View view){
        int chosenNumber = Integer.valueOf(playerNumber.getText().toString());
        if(playerNumber.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Wpisz wybraną przez Siebie liczbę.", Toast.LENGTH_SHORT).show();
        }
        else if(chosenNumber > rndNumber){
            Toast.makeText(getApplicationContext(), "Poszukiwana liczba jest mniejsza.", Toast.LENGTH_SHORT).show();
            showTryNumber = Integer.valueOf(tryNumber.getText().toString());
            showTryNumber = showTryNumber + 1;
            stringTryNumber = String.valueOf(showTryNumber);
            tryNumber.setText(stringTryNumber);
        }
        else if(chosenNumber < rndNumber){
            Toast.makeText(getApplicationContext(), "Poszukiwana liczba jest większa.", Toast.LENGTH_SHORT).show();
            showTryNumber = Integer.valueOf(tryNumber.getText().toString());
            showTryNumber = showTryNumber + 1;
            stringTryNumber = String.valueOf(showTryNumber);
            tryNumber.setText(stringTryNumber);
        }
        else{
            Toast.makeText(getApplicationContext(), "GRATULACJE!!! ZNALAZŁEŚ POSZUKIWANĄ LICZBĘ!", Toast.LENGTH_SHORT).show();
            showTryNumber = Integer.valueOf(tryNumber.getText().toString());
            showTryNumber = showTryNumber + 1;
            stringTryNumber = String.valueOf(showTryNumber);
            tryNumber.setText(stringTryNumber);

            minNumber.getText().clear();
            maxNumber.getText().clear();
            playerNumber.getText().clear();
            tryNumber.getText().clear();
        }
    }
}