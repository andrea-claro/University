package com.example.listacustom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contact> {

    private int resource;
    private LayoutInflater inflater;

    public CustomAdapter(Context ctx, int resourceId, List<Contact> obj){
        super(ctx, resourceId, obj);
        resource = resourceId;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            Log.d("DEBUG","Inflating view");
            v = inflater.inflate(resource, null);
        }

        Contact c = getItem(position);

        Log.d("DEBUG","contact c="+c);

        TextView nameTextView;
        TextView telTextView;
        ImageView fotoImageView;

        nameTextView = (TextView) v.findViewById(R.id.elem_lista_nome);

        Log.d("DEBUG","nameTextView="+nameTextView);

        telTextView = (TextView) v.findViewById(R.id.elem_lista_telefono);
        fotoImageView = (ImageView) v.findViewById(R.id.elem_lista_foto);

        fotoImageView.setImageDrawable(c.getPicture());
        nameTextView.setText(c.getName());
        telTextView.setText(c.getTel());

        return v;
    }
}
