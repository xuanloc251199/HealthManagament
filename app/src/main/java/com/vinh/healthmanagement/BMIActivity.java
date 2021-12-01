package com.vinh.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity {

    EditText edtHeightNb, edtWeightNb;
    TextView resultNb, resultLv;
    Button btnCaculate;

    double total;
    double convert;
    double underweight= 18.5;
    double normal =24.9;
    double overweight = 29.9;
    double obese =30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        onInit();

        onBtnClickListener();
    }

    private void onInit() {
        edtHeightNb = findViewById(R.id.editTextHeight);
        edtWeightNb = findViewById(R.id.editTextWeight);
        resultNb = findViewById(R.id.display1);
        resultLv = findViewById(R.id.display2);
        btnCaculate = findViewById(R.id.button);
    }

    private void onBtnClickListener() {
        btnCaculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtHeightNb.getText().toString().equals("")){
                    Toast.makeText(BMIActivity.this,
                            "Please enter your height",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if(edtWeightNb.getText().toString().equals("")){
                    Toast.makeText(BMIActivity.this,
                            "Please enter your weight",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                double height = Double.parseDouble(edtHeightNb.getText().toString());
                double weight = Double.parseDouble(edtWeightNb.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                convert= height/100;
                total= weight/ (convert*convert);

                if (total<= underweight){
                    resultNb.setText("Your Body Mass Index is "+tenth.format(total) );
                    resultLv.setText("This is considered underweight");
                }else if (total > underweight && total <=normal){
                    resultNb.setText("Your Body Mass Index is "+tenth.format(total) );
                    resultLv.setText("This is considered normal");
                }else if (total > normal && total <= overweight){
                    resultNb.setText("Your Body Mass Index is "+tenth.format(total) );
                    resultLv.setText("This is considered overweight");
                }else if (total >= obese){
                    resultNb.setText("Your Body Mass Index is "+tenth.format(total) );
                    resultLv.setText("This is considered obese");
                }
            }
        });
    }

}