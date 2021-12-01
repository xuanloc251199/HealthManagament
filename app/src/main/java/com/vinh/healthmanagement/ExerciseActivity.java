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

public class ExerciseActivity extends AppCompatActivity {

    String time, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        EditText txtTimeForExercise = (EditText) findViewById(R.id.editTextTime);
        TextView txtActivityType = (TextView) findViewById(R.id.txtType);
        TextView result = (TextView) findViewById(R.id.exerciseResult);

        Button btnSave = (Button) findViewById(R.id.btnExercise);

        final SharedPreferences sf = PreferenceManager.getDefaultSharedPreferences(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = txtTimeForExercise.getText().toString();
                type = txtActivityType.getText().toString();

                if (time.equals("")) {
                    Toast.makeText(ExerciseActivity.this,
                            "Please enter amount of time",
                            Toast.LENGTH_LONG).show();
                }
                else if (type.equals("")) {
                    Toast.makeText(ExerciseActivity.this,
                            "Please enter activity",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    result.setText(type + " for " + time + " hour(s)");
                }

                SharedPreferences.Editor editor = sf.edit();
                editor.putString("txtTimeForExercise", time);
                editor.putString("txtActivityType", type);
                editor.commit();
                startActivity(new Intent(ExerciseActivity.this, HomeActivity.class));

            }
        });


    }
}