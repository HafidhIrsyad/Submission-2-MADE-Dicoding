package com.famio.made.submission2.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.famio.made.submission2.Pojo.DaftarTayang;
import com.famio.made.submission2.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_SHOW = "extra_show";
    private TextView txtName;
    private TextView txtRating;
    private TextView txtLanguage;
    private TextView txtRuntime;
    private TextView txtCrew;
    private TextView txtGenre;
    private TextView txtKeyword;
    private TextView txtDescrption;
    private ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        prepare();
        DaftarTayang mDaftarTayang = getIntent().getParcelableExtra(EXTRA_SHOW);
        setData(mDaftarTayang);
    }

    private void prepare() {
        txtName = findViewById(R.id.txt_detail_name);
        txtRating = findViewById(R.id.txt_detail_rating);
        txtLanguage = findViewById(R.id.txt_detail_language);
        txtRuntime = findViewById(R.id.txt_detail_runtime);
        txtCrew = findViewById(R.id.txt_detail_crew);
        txtGenre = findViewById(R.id.txt_detail_genre);
        txtKeyword = findViewById(R.id.txt_detail_keyword);
        txtDescrption = findViewById(R.id.txt_detail_overview);
        imgPoster = findViewById(R.id.img_detail_poster);
    }

    private void setData(DaftarTayang daftarTayang) {
        imgPoster.setImageResource(daftarTayang.getPoster());
        txtName.setText(daftarTayang.getName());
        txtRating.setText(daftarTayang.getRating());
        txtLanguage.setText(daftarTayang.getLanguage());
        txtRuntime.setText(daftarTayang.getRuntime());
        txtDescrption.setText(daftarTayang.getDescription());
        txtCrew.setText(daftarTayang.getCrew());
        txtGenre.setText(daftarTayang.getGenre());
        txtKeyword.setText(daftarTayang.getKeyword());
    }
}
