package com.example.communityhealthhelperappp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator);

        EditText editTextWeight = findViewById(R.id.weight_input);
        EditText editTextHeight = findViewById(R.id.height_input);
        Button button = findViewById(R.id.calculate_bmi_button);
        TextView textView = findViewById(R.id.bmi_result);
        Button backToMainButton = findViewById(R.id.back_to_main_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String heightStr = editTextHeight.getText().toString();
                    String weightStr = editTextWeight.getText().toString();

                    if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
                        float height = Float.parseFloat(heightStr) / 100; // convert cm to meters
                        float weight = Float.parseFloat(weightStr);
                        float bmi = weight / (height * height);
                        textView.setText(String.format("Your BMI is: %.2f", bmi));
                    } else {
                        textView.setText("Please enter both height and weight");
                    }
                } catch (NumberFormatException e) {
                    textView.setText("Invalid input");
                }
            }
        });

        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BmiCalculator.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}