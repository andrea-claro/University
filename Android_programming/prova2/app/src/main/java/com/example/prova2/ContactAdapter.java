package com.example.prova2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contatto> {

    private int resource;
    private LayoutInflater inflater;

    public ContactAdapter(Context ctx, int resourceId, List<Contatto> obj){
        super(ctx, resourceId, obj);
        resource = resourceId;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = inflater.inflate(resource, null);
        }

        Contatto c = getItem(position);

        TextView nameTextView;
        TextView telTextView;
        ImageView fotoImageView;

        nameTextView = (TextView) v.findViewById(R.id.nome);

        Log.d("DEBUG","nameTextView="+nameTextView);

        telTextView = (TextView) v.findViewById(R.id.cellphone);
        fotoImageView = (ImageView) v.findViewById(R.id.immagine);

        fotoImageView.setImageDrawable(c.getImage());
        nameTextView.setText(c.getName());
        telTextView.setText(c.getCellphone());

        return v;
    }
}
