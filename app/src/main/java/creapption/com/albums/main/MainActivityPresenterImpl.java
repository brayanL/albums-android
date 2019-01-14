package creapption.com.albums.main;

import android.util.Log;

import java.util.List;

import creapption.com.albums.data.DataManager;
import creapption.com.albums.data.remote.AlbumsResponseModel;
import creapption.com.albums.main.ui.MainActivityView;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by boma24 on 1/12/19.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    public static final String ALBUMS_TAG = "ALBUMS_TAG";
    private MainActivityView mainActivityView;
    private DataManager dataManager;

    public MainActivityPresenterImpl(MainActivityView mainActivityView, DataManager dataManager) {
        this.mainActivityView = mainActivityView;
        this.dataManager = dataManager;
    }

    @Override
    public void getAlbums() {
        Log.d(ALBUMS_TAG, "getAlbums MainActivityPresenterImpl: ");
        dataManager.getAlbums()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<AlbumsResponseModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(ALBUMS_TAG, "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(List<AlbumsResponseModel> albumsResponseModels) {
                        Log.d(ALBUMS_TAG, "onNext: "+albumsResponseModels);
                        mainActivityView.showAlbums(albumsResponseModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(ALBUMS_TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(ALBUMS_TAG, "onComplete: ");

                    }
                });
        //mainActivityView.showMessages();
    }
}
