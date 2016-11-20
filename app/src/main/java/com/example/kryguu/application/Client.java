package com.example.kryguu.application;

import android.os.Parcel;
import android.os.Parcelable;

public class Client implements Parcelable {
    private long mId;
    public String name;
    public String surname;
    public String PESEL;

    public Client(String name, String surname, String PESEL) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
    }

    protected Client(Parcel in) {
        name = in.readString();
        surname = in.readString();
        PESEL = in.readString();
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

    public long getmId() {
        return mId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(PESEL);
    }
}
