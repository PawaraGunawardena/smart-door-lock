package com.crystall.smartlockprototype;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crystall.smartlockprototype.authutil.firebase.AuthenticationUtility;
import com.crystall.smartlockprototype.beans.firebase.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Map;

public class Key extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button submit;
    private boolean accept  = false;
    private AuthenticationUtility authenticationUtility;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);

        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        submit = findViewById(R.id.btnLogIn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password_submit(v);
            }
        });

        try {
            authenticationUtility = new AuthenticationUtility();
        } catch (Exception e) {
            System.out.println("EXCEPTION OCCURRED!");
        }

//        authenticationUtility.write(new User("dasun", "dasun", "2018-08-08 10:10:10", "2018-08-09 10:10:11"));
    }

    /**
     *
     * @param v
     * @return
     */
    @SuppressLint("SetTextI18n")
    public void password_submit(View v){
        try {
            if(password.length() > 0 && username.length() > 0) {
                authenticationUtility.login(username.getText().toString(),
                        getApplicationContext(),
                        password.getText().toString()
                );
            } else {
                Toast.makeText(getApplicationContext(), "Please enter proper credentials!" ,
                        Toast.LENGTH_SHORT).show();
            }

        } catch(Exception e){
            Log.e("ERROR", "Message: "+ e.getMessage());
        }
    }


}
