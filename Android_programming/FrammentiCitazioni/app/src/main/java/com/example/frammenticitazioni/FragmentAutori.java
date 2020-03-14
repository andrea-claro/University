package com.example.frammenticitazioni;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentAutori extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    Communicator communicator;

    public FragmentAutori() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_autori, container, false);
        listView = (ListView) v.findViewById(R.id.listView);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.authors,
                android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return v;
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
        communicator.respond(i);
    }

    public interface Communicator {
        public void respond(int index);
    }
}
