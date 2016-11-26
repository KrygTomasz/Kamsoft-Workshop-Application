package com.example.kryguu.application;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kryguu on 26.11.2016.
 */

public class ClientDao extends BaseDao<Client> {

    private static final String TABLE_NAME = "clients";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SURNAME = "surname";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL = "email";

    public ClientDao() {
        super(TABLE_NAME);
    }

    @Override
    public Client getObjectFromCursor(Cursor cursor) {
        Client client = new Client();
        client.setId(getLong(cursor, COLUMN_ID));
        client.setmName(getString(cursor, COLUMN_NAME));
        client.setmName(getString(cursor, COLUMN_SURNAME));
        client.setmName(getString(cursor, COLUMN_PHONE));
        client.setmName(getString(cursor, COLUMN_EMAIL));
        return client;
    }

    @Override
    public ContentValues getObjectContentValues(Client object) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, object.getmName());
        contentValues.put(COLUMN_SURNAME, object.getmSurname());
        contentValues.put(COLUMN_PHONE, object.getmPhone());
        contentValues.put(COLUMN_EMAIL, object.getmEmail());
        return contentValues;
    }

    public List<Client> getClientsList() {
        String sql = FirstAppApplication.getsInstance().getmDbHelper().getSql(R.string.sql_dao_client_get_clients);
        Cursor cursor = openRawQueryCursor(sql);
        try {
            List<Client> clientList = new ArrayList<>();

            while (cursor.moveToNext()) {
                Client client = getObjectFromCursor(cursor);
                clientList.add(client);
            }

            return clientList;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            closeCursor(cursor);
        }
    }

    private Cursor openRawQueryCursor(String sql) {
        SQLiteDatabase database = FirstAppApplication.getsInstance().getmDbHelper().getReadableDatabase();
        Cursor cursor = database.rawQuery(sql,null);
        return cursor;
    }

    private void closeCursor(Cursor cursor) {
        if (cursor!=null){
            cursor.close();
        }
    }
}
