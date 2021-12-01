package com.vinh.healthmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class WaterActivity extends AppCompatActivity {

    String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        EditText txtWater = (EditText) findViewById(R.id.editWater);
        TextView result = (TextView) findViewById(R.id.waterResult);

        Button btnSave = (Button) findViewById(R.id.btnWater);

        final SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount = txtWater.getText().toString();

                if (amount.equals("")) {
                    Toast.makeText(WaterActivity.this,
                            "Please enter amount of water",
                            Toast.LENGTH_LONG).show();
                } else {
                    result.setText("Amount of water: " + amount + " (l)");
                }

                SharedPreferences.Editor editor = sf.edit();
                editor.putString("txtAmount", amount);
                editor.commit();
                startActivity(new Intent(WaterActivity.this, HomeActivity.class));
            }
        });
    }
}