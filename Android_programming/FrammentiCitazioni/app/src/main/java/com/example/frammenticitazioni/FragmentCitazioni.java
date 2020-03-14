package com.example.frammenticitazioni;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCitazioni extends Fragment {

    TextView textView;

    public FragmentCitazioni() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_citazioni, container, false);
        textView = (TextView) v.findViewById(R.id.textViewCitazione);
        return v;
    }

    public void mostraCitazione(int index) {
        String[] citazioni = getResources().getStringArray(R.array.quotes);
        textView.setText(citazioni[index]);
    }
}
