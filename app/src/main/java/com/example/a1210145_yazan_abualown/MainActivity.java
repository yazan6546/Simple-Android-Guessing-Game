package com.example.a1210145_yazan_abualown;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button startGame = findViewById(R.id.button_play);
        EditText editTextFirstName = (EditText) findViewById(R.id.edit_text_fname);
        EditText editTextLastName = (EditText) findViewById(R.id.edit_text_lname);
        Spinner spinnerGender = (Spinner) findViewById(R.id.spinner_gender);

        startGame.setOnClickListener(v -> {
            // Start the game activity
            String firstName = editTextFirstName.getText().toString();

            if (firstName.isEmpty()) {
                editTextFirstName.setError("Please enter your first name");
                return;
            }
            String lastName = editTextLastName.getText().toString();

            if (lastName.isEmpty()) {
                editTextLastName.setError("Please enter your last name");
                return;
            }

            String gender = spinnerGender.getSelectedItem().toString();

            Player.currentPlayer = new Player(firstName, lastName, gender);
            startActivity(new Intent(MainActivity.this, PlayActivity.class));
            finish();
        });
    }
}
