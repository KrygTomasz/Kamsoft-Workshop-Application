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
        String[] elements = {"Pierwszy klient", "Drugi klient"};
        //ArrayAdapter<String> clientAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elements);
        List<Client> clients = new ArrayList<Client>();
        Client c1 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c1);
        Client c2 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c2);
        Client c3 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c3);
        Client c4 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c4);
        Client c5 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c5);
        Client c6 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c6);
        Client c7 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c7);
        Client c8 = new Client("Jan", "Kowalski", "123456789");
        clients.add(c8);


        ClientListAdapter clientAdapter = new ClientListAdapter(clients);
        listViewClients.setAdapter(clientAdapter);
    }
}
