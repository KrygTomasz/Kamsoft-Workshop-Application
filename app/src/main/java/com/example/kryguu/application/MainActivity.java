package com.example.kryguu.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLogIn;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUiComponents();

        buttonLogIn.setOnClickListener(getOnButtonLogInClick());
    }

    private View.OnClickListener getOnButtonLogInClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if(userName.isEmpty() || password.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("At least one field is empty.");
                    builder.setPositiveButton("Back", null);
                    builder.show();
                }
                else {
                    Intent menuIntent = new Intent(MainActivity.this, SecondActivity.class);
                    menuIntent.putExtra(IntentExtras.USERNAME, userName);
                    menuIntent.putExtra(IntentExtras.PASSWORD, password);
                    startActivity(menuIntent);

                    finish();
                }
            }
        };
    }

    private void initUiComponents () {
        editTextUsername = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogIn = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
    }
}
