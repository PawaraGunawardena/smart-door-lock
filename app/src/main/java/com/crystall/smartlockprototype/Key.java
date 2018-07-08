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

public class Key extends AppCompatActivity {

    private String password;
    private EditText editText_password;
    private Button btn_submit;
    private String txt_password;
    private TextView textView;
    private boolean accept  = false;
    public String TAG = "MEEEET";

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);

        editText_password = (EditText) findViewById(R.id.txt_typing_password);
        btn_submit = (Button)findViewById(R.id.btn_submit);
        textView = (TextView)findViewById(R.id.txt_password);

    }

    /**
     *
     * @param v
     * @return
     */
    @SuppressLint("SetTextI18n")
    public boolean password_submit(View v){
        try {
            password = editText_password.getText().toString();

            /*
             * DB can be accessed here.
             * if db query matches, then success - else failure.
             * NodeMCU Documentation - https://nodemcu.readthedocs.io/en/master/en/modules/sqlite3/
             */

            if(password.length() > 0) {
                if (password.toLowerCase().equals(getApplicationContext().getString(R.string.pass))) {
                    accept = true;
                    Toast.makeText(getApplicationContext(), "Successfull Authentication!",
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Key.this, LoggedInActivity.class));
                    textView.setText(R.string.success);
                    return accept;
                } else {
                    accept = false;
                    Toast.makeText(getApplicationContext(), "Successfull Authentication!",
                            Toast.LENGTH_LONG).show();
                    textView.setText(R.string.failure);
                    return accept;
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please enter some text!" ,
                        Toast.LENGTH_SHORT).show();
            }

        } catch(Exception e){
            Log.i(TAG, "Message: "+e.getMessage());
        }
        return accept;
    }


}
