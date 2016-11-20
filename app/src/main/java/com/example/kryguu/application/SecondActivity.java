package com.example.kryguu.application;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class SecondActivity extends AppCompatActivity {

    private ListView mListViewClients;
    private List<Client> mClientsList;
    private ClientListAdapter clientAdapter;
    private static final int REQUEST_CODE = 333;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mListViewClients = (ListView)findViewById(R.id.listViewClient);
    // Odbieranie danych ????
        //String[] elements = {"Pierwszy klient", "Drugi klient"};
        //ArrayAdapter<String> clientAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elements);
        mClientsList = new ArrayList<Client>();

        for (int i = 0; i<10;i++) {
            Client c1 = new Client("Jan", "Kowalski", "123123123123123123");
            mClientsList.add(c1);
        }

        clientAdapter = new ClientListAdapter(mClientsList);
        mListViewClients.setAdapter(clientAdapter);

        ButterKnife.bind(this);
    }

    public void onAddClientClick(View v) {
        Intent intent = new Intent(this, ClientFormActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE == requestCode && Activity.RESULT_OK == resultCode && data != null) {
            //Client client = data.getExtras().getParcelable(IntentExtras.CLIENT);
            Client client = new Client("Adam", "Nowak", "333333333");
            mClientsList.add(client);
            clientAdapter.notifyDataSetChanged();
        }
    }

    @OnItemClick(R.id.listViewClient)
    public void onListViewClientsItemClick(int position) {
        Client client = (Client)clientAdapter.getItem(position);

        Intent intent = new Intent(SecondActivity.this, DetailsActivity.class);
        intent.putExtra(IntentExtras.CLIENT, client);

        startActivity(intent);
    }
}
