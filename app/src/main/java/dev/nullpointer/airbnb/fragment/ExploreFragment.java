package dev.nullpointer.airbnb.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import dev.nullpointer.airbnb.R;
import dev.nullpointer.airbnb.adapter.ExploreAdapter;

public class ExploreFragment extends Fragment {

    View view;
    int[] thumbs = {R.drawable.italy, R.drawable.paris, R.drawable.indonesia, R.drawable.london, R.drawable.india};
    String[] city = {"Rome", "Paris", "Bali", "London", "New Delhi"};
    String[] country = {"Italy", "France", "Indonesia", "England", "India"};
    ListView lView;
    ExploreAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_explore, container, false);

        lView = view.findViewById(R.id.list_explore);
        adapter = new ExploreAdapter(getActivity(), city, country, thumbs);
        lView.setAdapter(adapter);
        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), city[i]+" Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
