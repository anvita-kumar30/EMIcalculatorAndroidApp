package com.example.myapplicationexp5.ui.theme;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationexp5.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPrincipal, editTextInterest, editTextTenure;
    private Button buttonCalculate;
    private TextView textViewResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextPrincipal = findViewById(R.id.editTextPrincipal);
        editTextInterest = findViewById(R.id.editTextInterest);
        editTextTenure = findViewById(R.id.editTextTenure);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Set click listener for the calculate button
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEMI();
            }
        });
    }

    // Calculate EMI based on user input
    public void calculateEMI() {
        // Get user input
        double principal = Double.parseDouble(editTextPrincipal.getText().toString());
        double interestRate = Double.parseDouble(editTextInterest.getText().toString());
        int numberOfPayments = Integer.parseInt(editTextTenure.getText().toString());

        // Calculate EMI
        double monthlyInterestRate = interestRate / (12 * 100);
        double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        // Display the result
        String result = String.format("EMI: %.2f", emi);
        textViewResult.setText(result);
    }
}
