package com.famio.made.submission2.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.famio.made.submission2.Adapter.CardViewAdapter;
import com.famio.made.submission2.Pojo.DaftarTayang;
import com.famio.made.submission2.R;

import java.util.ArrayList;

public class TVShowsFragment extends Fragment {
    private RecyclerView rvCategory;
    private ArrayList<DaftarTayang> tvShows = new ArrayList<>();

    private String [] dataName;
    private String [] dataDescription;
    private String [] dataRating;
    private String [] dataLanguage;
    private String [] dataRuntime;
    private String [] dataCrew;
    private String [] dataGenre;
    private String [] dataKeyword;
    private TypedArray dataPoster;

    public TVShowsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prepare();
        addItem();
        View view = inflater.inflate(R.layout.fragment_tvshows, container, false);
        rvCategory = view.findViewById(R.id.rv_category_tvshow);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategory.setHasFixedSize(true);
        showRecyclerCardView();
        // Inflate the layout for this fragment
        return view;
    }

    private void showRecyclerCardView(){
        CardViewAdapter cardViewTVShowAdapter = new CardViewAdapter(getActivity());
        cardViewTVShowAdapter.setListDaftarTayang(tvShows);
        rvCategory.setAdapter(cardViewTVShowAdapter);

    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name_tvshows);
        dataDescription = getResources().getStringArray(R.array.data_description_tvshows);
        dataRating = getResources().getStringArray(R.array.data_rating_tvshows);
        dataLanguage = getResources().getStringArray(R.array.data_language_tvshows);
        dataRuntime = getResources().getStringArray(R.array.data_runtime_tvshows);
        dataCrew = getResources().getStringArray(R.array.data_crew_tvshows);
        dataGenre = getResources().getStringArray(R.array.data_genres_tvshows);
        dataKeyword = getResources().getStringArray(R.array.data_keywords_tvshows);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_tvshows);
    }

    private void addItem() {
        for (int i = 0; i < dataName.length; i++) {
            DaftarTayang tvShow = new DaftarTayang();
            tvShow.setName(dataName[i]);
            tvShow.setDescription(dataDescription[i]);
            tvShow.setRating(dataRating[i]);
            tvShow.setLanguage(dataLanguage[i]);
            tvShow.setRuntime(dataRuntime[i]);
            tvShow.setCrew(dataCrew[i]);
            tvShow.setGenre(dataGenre[i]);
            tvShow.setKeyword(dataKeyword[i]);
            tvShow.setPoster(dataPoster.getResourceId(i, -1));
            tvShows.add(tvShow);
        }
    }
}
