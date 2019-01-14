package creapption.com.albums.main.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import creapption.com.albums.R;
import creapption.com.albums.data.remote.AlbumsResponseModel;
import creapption.com.albums.main.MainActivityPresenter;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private static final String TAG = "ALBUMS_TAG";
    private AlbumsListAdapter adapter;

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.recyclerViewAlbums)
    RecyclerView recyclerViewAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupAdapter();

        mainActivityPresenter.getAlbums();
    }

    @Override
    public void showAlbums(List<AlbumsResponseModel> albumsList) {
        progressBar.setVisibility(View.GONE);
        adapter.updateAlbumList(albumsList);
    }

    /**
     * Config Adapter for RecyclerView
     * */
    private void setupAdapter() {
        adapter = new AlbumsListAdapter(new ArrayList<AlbumsResponseModel>());
        recyclerViewAlbums.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewAlbums.setAdapter(adapter);
    }
}
