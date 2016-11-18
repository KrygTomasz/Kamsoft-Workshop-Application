package com.example.kryguu.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ClientListAdapter extends BaseAdapter {

    static class Holder {
        @BindView(R.id.textViewName)
        TextView name;
        @BindView(R.id.textViewSurname)
        TextView surname;
        @BindView(R.id.textViewPesel)
        TextView pesel;

        public Holder(View view){
            ButterKnife.bind(this,view);
        }
    }

    List<Client> mClientsList;// = new ArrayList<>();

    public ClientListAdapter(List<Client> clients) {
        mClientsList = clients;
    }

    @Override
    public int getCount() {
        return mClientsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mClientsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Client client = mClientsList.get(position);
        return client.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView != null){
            holder = (Holder) convertView.getTag();
        }
        else {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_layout, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        }

        Client client = mClientsList.get(position);
        holder.name.setText(client.name);
        holder.surname.setText(client.surname);
        holder.pesel.setText(client.PESEL);
        //if (convertView == null) {
        //    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_layout, parent, false);

        //    Client client = mClientsList.get(position);
        //    ((TextView)convertView.findViewById(R.id.textViewName)).setText(client.name);
        //    ((TextView)convertView.findViewById(R.id.textViewSurnameame)).setText(client.surname);
        //    ((TextView)convertView.findViewById(R.id.textViewPesel)).setText(client.PESEL);
        //}

        return convertView;
    }
}
