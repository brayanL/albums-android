package creapption.com.albums.data;

import android.util.Log;

import java.util.List;


import creapption.com.albums.data.remote.AlbumsResponseModel;
import creapption.com.albums.data.remote.AlbumsService;
import io.reactivex.Observable;

/**
 * Created by boma24 on 1/10/19.
 */

public class DataManager {

    private AlbumsService albumsService;

    public DataManager(AlbumsService albumsService) {
        this.albumsService = albumsService;
    }

    public Observable<List<AlbumsResponseModel>> getAlbums() {
        Log.d("ALBUMS_TAG", "getAlbums DataManager: ");
        return albumsService.getAlbums();
    }
}
