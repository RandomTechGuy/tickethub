/*
Author: Jerry Henry
Date: 10/20/2019
*/

package com.example.tickethub;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double ticketCost = 59.99;
    double totalCost;
    double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //variable to access UI controls
        final EditText cost = (EditText) findViewById(R.id.howMany);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button calculate = (Button) findViewById(R.id.btnCost);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount = Double.parseDouble(cost.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if (amount <= 25) {
                    totalCost = amount * ticketCost;
                    result.setText("$" + tenth.format(totalCost));
                } else {
                    Toast.makeText(MainActivity.this, "Cannot Purchase More Than 25 Tickets at a time", Toast.LENGTH_LONG).show();
                }
            }
        }
        );}
}