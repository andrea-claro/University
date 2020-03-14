package com.example.visualizzamappa;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText indirizzo;
    final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        indirizzo = (EditText)findViewById(R.id.indirizzo);
    }

    public void cercaIndirizzoClicked(View v) {
        try {
            Log.d("DEBUG",ContactsContract.Contacts.CONTENT_URI.toString());
            Intent intent = new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, REQUEST_CODE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void visualizzaMappaClicked(View v) {
        String address = indirizzo.getText().toString();
        if (address != null) {
            address = address.replace(' ', '+');
            Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + address));
            startActivity(geoIntent);
        }
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        if (request == REQUEST_CODE  && result == Activity.RESULT_OK) {

            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(data.getData(), null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String where = ContactsContract.Data.CONTACT_ID
                        + " = ? AND "
                        + ContactsContract.Data.MIMETYPE
                        + " = ?";
                String[] whereParameters = new String[] { id,
                        ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE };
                Cursor addrCur = cr.query(ContactsContract.Data.CONTENT_URI, null, where,
                        whereParameters, null);

                if (null != addrCur && addrCur.moveToFirst()) {
                    String formattedAddress = addrCur
                            .getString(addrCur
                                    .getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS));

                    indirizzo.setText(formattedAddress);
                }
                if (null != addrCur)
                    addrCur.close();
            }
            if (null != cursor)
                cursor.close();
        }
    }
}
