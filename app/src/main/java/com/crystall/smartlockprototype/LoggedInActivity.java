package com.crystall.smartlockprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.crystall.smartlockprototype.beans.firebase.User;

public class LoggedInActivity extends AppCompatActivity {

    private TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        // Set up the component IDs.
        label = findViewById(R.id.txtLoggedIn);

        // Set up the global user.
        Intent i = getIntent();
        User currentUser = (User) i.getSerializableExtra("USER");
        label.setText(currentUser.getUsername());
    }
}
