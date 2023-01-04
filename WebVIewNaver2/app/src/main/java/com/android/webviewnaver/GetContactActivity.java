package com.android.webviewnaver;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GetContactActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getcontact);

        ArrayList<ContactVO> contactVO = getContactList();

        ListView listView = (ListView) findViewById((R.id.listview_contactList));
        final ContactAdapter contactAdapter = new ContactAdapter(this, contactVO);

        listView.setAdapter(contactAdapter);




//        getContactList();
//
//        List<ContactVO> getContactList = getContactList();
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getContactList);
//
//
//        ListView listView = (ListView) findViewById(R.id.list_contactList);
//        listView.setAdapter(adapter);

    }



    private ArrayList<ContactVO> getContactList() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        String[] projection = new String[] {
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};

        String[] selectionArgs = null;

        String sortOrder = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + "COLLATE LOCALIZED ASC";

        Cursor contactCursor = getContentResolver().query(uri, projection, null, selectionArgs, null);

        ArrayList<ContactVO> contactlist = new ArrayList<ContactVO>();

        if (contactCursor.moveToFirst()) {
            do {
                String phonenumber = contactCursor.getString(1);

//                if (phonenumber.length() == 10) {
//                    phonenumber = phonenumber.substring(0, 3) + "-"
//                            + phonenumber.substring(3, 6) + "-"
//                            + phonenumber.substring(6);
//                } else if (phonenumber.length() > 8) {
//                    phonenumber = phonenumber.substring(0, 3) + "-"
//                            + phonenumber.substring(3, 7) + "-"
//                            + phonenumber.substring(7);
//                }

                ContactVO acontact = new ContactVO();
                acontact.setPhotoid((contactCursor.getLong(0)));
                acontact.setPhonenum(phonenumber);
                acontact.setName(contactCursor.getString(2));

                contactlist.add(acontact);
            } while (contactCursor.moveToNext());
        }
        return contactlist;
    }
}