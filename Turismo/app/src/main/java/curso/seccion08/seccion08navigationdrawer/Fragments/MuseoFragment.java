package curso.seccion08.seccion08navigationdrawer.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import curso.seccion08.seccion08navigationdrawer.Activities.DetailsActivity;
import curso.seccion08.seccion08navigationdrawer.Models.Place;
import curso.seccion08.seccion08navigationdrawer.Adapters.MyAdapter;
import curso.seccion08.seccion08navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseoFragment extends Fragment {

    private List<Place> places;

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    private Context context;

    public MuseoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_places_list, container, false);
        places = this.getAllMovies();

        myRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        myLayoutManager = new LinearLayoutManager(getContext());
        context = getActivity().getApplicationContext();
        myAdapter = new MyAdapter(places, R.layout.recycler_view_item);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);
        return v;
    }

    private List<Place> getAllMovies(){
        return new ArrayList<Place>(){{
            add(new Place("The Nightmare Before Christmas", R.drawable.museo1));
            add(new Place("Beetlejuice", R.drawable.museo2));

        }};
    }

}
