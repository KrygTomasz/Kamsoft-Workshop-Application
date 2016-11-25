package com.example.kryguu.application;

import android.os.Parcel;
import android.os.Parcelable;

public class Client implements Parcelable {
    private long mId;
    private String mName;
    private String mSurname;
    private String mPhone;
    private String mEmail;

    public Client(String name, String surname, String PESEL, String email) {
        this.mName = name;
        this.mSurname = surname;
        this.mPhone = PESEL;
        this.mEmail = email;
    }

    protected Client(Parcel in) {
        mId = in.readLong();
        mName = in.readString();
        mSurname = in.readString();
        mPhone = in.readString();
        mEmail = in.readString();
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mId);
        parcel.writeString(mName);
        parcel.writeString(mSurname);
        parcel.writeString(mPhone);
        parcel.writeString(mEmail);
    }

    public long getmId() {
        return mId;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmSurname() {
        return mSurname;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }
}
