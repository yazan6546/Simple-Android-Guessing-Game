package com.example.a1210145_yazan_abualown;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_play);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button buttonLower = findViewById(R.id.button_lower);
        Button buttonHigher = findViewById(R.id.button_higher);
        Button buttonEqual = findViewById(R.id.button_equal);
        TextView textView = findViewById(R.id.number);
        TextView textView_name = findViewById(R.id.textView_name);

        textView_name.setText("Welcome, " + Player.currentPlayer.getFirstName() + " " + Player.currentPlayer.getLastName());


        int number = getRandomNumber();
        final int[] guess = {Integer.parseInt(textView.getText().toString())};

        buttonLower.setOnClickListener(v -> {
            if (getResult(number, guess[0], "lower")) {
                guess[0]--;
                textView.setText(String.valueOf(guess[0]));
                buttonLower.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_green));
                buttonHigher.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonEqual.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
            }
            else {
                buttonLower.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_red));
                buttonHigher.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonEqual.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
            }
        });

        buttonHigher.setOnClickListener(v -> {
            if (getResult(number, guess[0], "higher")) {
                guess[0]++;
                textView.setText(String.valueOf(guess[0]));
                buttonHigher.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_green));
                buttonLower.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonEqual.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
            }
            else {
                buttonHigher.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_red));
                buttonLower.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonEqual.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
            }
        });


        buttonEqual.setOnClickListener(v -> {
            if (getResult(number, guess[0], "equal")) {
                buttonLower.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonHigher.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonEqual.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_green));

                startActivity(new Intent(PlayActivity.this, MainActivity.class));
                finish();
            }
            else {
                buttonLower.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonHigher.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_orange));
                buttonEqual.setBackgroundTintList(this.getResources().getColorStateList(R.color.my_red));
            }
        });
    }




    public static int getRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }


    public static Boolean getResult(int number, int currentGuess, String button) {
        if (button.equals("lower") && currentGuess > number) {
            return true;
        }
        else if (button.equals("higher") && currentGuess < number) {
            return true;
        }
        else if (button.equals("equal") && currentGuess == number) {
            return true;
        }
        return false;
    }


}