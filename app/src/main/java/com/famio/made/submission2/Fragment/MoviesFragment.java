x`package com.famio.made.submission2.Fragment;

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

public class MoviesFragment extends Fragment {
    private RecyclerView rvCategory;
    private ArrayList<DaftarTayang> movies = new ArrayList<>();

    private String [] dataName;
    private String [] dataDescription;
    private String [] dataRating;
    private String [] dataLanguage;
    private String [] dataRuntime;
    private String [] dataCrew;
    private String [] dataGenre;
    private String [] dataKeyword;
    private TypedArray dataPoster;

    public MoviesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        prepare();
        addItem();
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        rvCategory = view.findViewById(R.id.rv_category_movie);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCategory.setHasFixedSize(true);
        showRecyclerCardView();
        return view;
    }



    private void showRecyclerCardView(){
        CardViewAdapter cardViewMovieAdapter = new CardViewAdapter(getActivity());
        cardViewMovieAdapter.setListDaftarTayang(movies);
        rvCategory.setAdapter(cardViewMovieAdapter);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name_movies);
        dataDescription = getResources().getStringArray(R.array.data_description_movies);
        dataRating = getResources().getStringArray(R.array.data_rating_movies);
        dataLanguage = getResources().getStringArray(R.array.data_language_movies);
        dataRuntime = getResources().getStringArray(R.array.data_runtime_movies);
        dataCrew = getResources().getStringArray(R.array.data_crew_movies);
        dataGenre = getResources().getStringArray(R.array.data_genres_movies);
        dataKeyword = getResources().getStringArray(R.array.data_keywords_movies);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_movies);
    }

    private void addItem() {
        for (int i = 0; i < dataName.length; i++) {
            DaftarTayang movie = new DaftarTayang();
            movie.setName(dataName[i]);
            movie.setDescription(dataDescription[i]);
            movie.setRating(dataRating[i]);
            movie.setLanguage(dataLanguage[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setCrew(dataCrew[i]);
            movie.setGenre(dataGenre[i]);
            movie.setKeyword(dataKeyword[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movies.add(movie);
        }
    }
}
