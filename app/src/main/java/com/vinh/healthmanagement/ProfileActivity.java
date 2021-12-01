package com.vinh.healthmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vinh.healthmanagement.helper.DBHelper;

public class ProfileActivity extends AppCompatActivity {

    ImageButton btnBackMyAccount;
    Button btnEditProfile;
    TextView txtFullName, txtUsername, txtEmail, txtDoB;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        linkViews();
        addEvents();
        setData();
    }

    private void linkViews() {
        btnBackMyAccount=findViewById(R.id.btnBackMyAccount);
        txtFullName=findViewById(R.id.txtPfFullName);
        txtUsername=findViewById(R.id.txtPfUsername);
        txtEmail=findViewById(R.id.txtPfEmail);
        txtDoB=findViewById(R.id.txtPfDoB);
    }

    private void setData() {
        Intent receiveIntent = getIntent();
        DB = new DBHelper(this);

        Cursor res = DB.getdata(receiveIntent.getStringExtra("keyUsername"));
        if(res.getCount()==0){
            Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();
        }
        while(res.moveToNext()){
            String pfUsername = res.getString(0);
            String pfFullName = res.getString(1);
            String pfEmail = res.getString(2);
            String pfDob = res.getString(4);

            txtUsername.setText(pfUsername);
            txtFullName.setText(pfFullName);
            txtEmail.setText(pfEmail);
            txtDoB.setText(pfDob);

        }

    }

    private void addEvents() {
        btnBackMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ProfileActivity.this,HomeActivity.class);
                String user = getIntent().getStringExtra("keyUsername");
                intent.putExtra("keyUsername", user);
                startActivity(intent);
            }
        });
    }
}