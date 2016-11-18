package com.example.kryguu.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ListView listViewClients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listViewClients = (ListView)findViewById(R.id.listViewClient);
// Odbieranie danych ????
        //String[] elements = {"Pierwszy klient", "Drugi klient"};
        //ArrayAdapter<String> clientAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elements);
        List<Client> clients = new ArrayList<Client>();

        for (int i = 0; i<20;i++) {
            Client c1 = new Client("Jan", "Kowalski", "123123123123123123");
            clients.add(c1);
        }

        ClientListAdapter clientAdapter = new ClientListAdapter(clients);
        listViewClients.setAdapter(clientAdapter);
    }
}
