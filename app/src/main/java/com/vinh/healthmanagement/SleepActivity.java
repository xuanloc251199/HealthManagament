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

public class SleepActivity extends AppCompatActivity {
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        EditText txtTime = (EditText) findViewById(R.id.editTimeSleep);
        TextView result = (TextView) findViewById(R.id.sleepResult);

        Button btnSave = (Button) findViewById(R.id.btnSleep);

        final SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);


        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                time = txtTime.getText().toString();


                if (time.equals("")) {
                    Toast.makeText(SleepActivity.this,
                            "Please enter amount of time",
                            Toast.LENGTH_LONG).show();
                } else {
                    result.setText("Sleep for " + time + " hour(s)");
                }
                SharedPreferences.Editor editor = sf.edit();
                editor.putString("txtTime", time);
                editor.commit();
                startActivity(new Intent(SleepActivity.this, HomeActivity.class));

            }
        });
    }
}