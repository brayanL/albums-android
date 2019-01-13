package creapption.com.albums.main.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import creapption.com.albums.R;
import creapption.com.albums.main.MainActivityPresenter;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private static final String TAG = "ALBUMS_TAG";

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter.getAlbums();
        // Log.d(TAG, "onCreate: mainActivityPresenter" + mainActivityPresenter);
    }

    @Override
    public void showMessages() {
        Log.d(TAG, "showMessages: Return from Presenter");
    }
}
