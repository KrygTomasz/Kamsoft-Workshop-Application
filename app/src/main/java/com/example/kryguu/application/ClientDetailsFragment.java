package com.example.kryguu.application;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by kryguu on 19.11.2016.
 */

public class ClientDetailsFragment extends Fragment {

    private Client mClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mClient = bundle.getParcelable(IntentExtras.CLIENT);
        }
    }

    public static ClientDetailsFragment getInstance(Client client) {
        ClientDetailsFragment fragment = new ClientDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(IntentExtras.CLIENT, client);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View fragmentView = inflater.inflate(R.layout.client_details, container,false);
        ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }
}
