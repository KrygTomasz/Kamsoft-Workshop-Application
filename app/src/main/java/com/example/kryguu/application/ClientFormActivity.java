package com.example.kryguu.application;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;

public class ClientFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_form);
    }

    public void addButtonClick(View v) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(IntentExtras.NAME,"Adam");
        resultIntent.putExtra(IntentExtras.SURNAME,"Nowak");
        resultIntent.putExtra(IntentExtras.PESEL,"3333333333");
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }


}
