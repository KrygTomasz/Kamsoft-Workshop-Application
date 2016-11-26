package com.example.kryguu.application;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        if(name.getText().toString().isEmpty() || surname.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || email.getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ClientFormActivity.this);
            builder.setTitle("Error");
            builder.setMessage("At least one field is empty.");
            builder.setPositiveButton("Back", null);
            builder.show();
        }
        else {
            Client client = new Client(
                    name.getText().toString(),
                    surname.getText().toString(),
                    phone.getText().toString(),
                    email.getText().toString());
            ClientDao cd = new ClientDao();
            cd.insertObject(client);
            Intent intent = new Intent();
            intent.putExtra(IntentExtras.CLIENT, client);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_client, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                doSaveAction();
                break;
        }

        return true;
    }

    private void doSaveAction() {
    }

}
