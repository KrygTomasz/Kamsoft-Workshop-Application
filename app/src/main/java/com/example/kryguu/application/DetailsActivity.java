package com.example.kryguu.application;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.StringDef;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsActivity extends AppCompatActivity {

    private Client mClient;


    @BindView(R.id.view_pager_client_details)
    ViewPager mViewPagerClientAdapter;
    @BindView(R.id.tab_layout_client_details)
    TabLayout mTabLayoutClientDetails;

//    @BindView(R.id.button_call)
//    Button mButtonCall;
//    @BindView(R.id.button_locate)
//    Button mButtonLocate;
//    @BindView(R.id.button_mail)
//    Button mButtonMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        mClient = getIntent().getExtras().getParcelable(IntentExtras.CLIENT);
        //mClient = new Client("Seba","Seba","666");
        ClientDetailsPagerAdapter clientDetailsPagerAdapter = new ClientDetailsPagerAdapter(getSupportFragmentManager(),this,mClient);
        mViewPagerClientAdapter.setAdapter(clientDetailsPagerAdapter);
        mTabLayoutClientDetails.setupWithViewPager(mViewPagerClientAdapter);

    }

//    @OnClick(R.id.button_call)
//    public void onButtonCallClick() {
//        String url = String.format("tel:%s", "123456789");
//        Intent callIntent = new Intent("android.intent.action.CALL", Uri.parse(url));
//        startActivity(callIntent);
//    }
}
