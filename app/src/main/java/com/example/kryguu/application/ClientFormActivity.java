package com.example.kryguu.application;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClientFormActivity extends AppCompatActivity {

    @BindView(R.id.editTextName)
    EditText name;
    @BindView(R.id.editTextSurname)
    EditText surname;
    @BindView(R.id.editTextPhone)
    EditText phone;
    @BindView(R.id.editTextEmail)
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_form);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonAddClient)
    public void addClient() {
        Client client = new Client(
                name.getText().toString(),
                surname.getText().toString(),
                phone.getText().toString(),
                email.getText().toString());
        Intent intent = new Intent();
        intent.putExtra(IntentExtras.CLIENT, client);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
