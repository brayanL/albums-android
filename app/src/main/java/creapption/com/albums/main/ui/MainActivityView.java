package creapption.com.albums.main.ui;

import java.util.List;

import creapption.com.albums.data.remote.AlbumsResponseModel;

/**
 * Created by boma24 on 1/12/19.
 */

public interface MainActivityView {
    void showAlbums(List<AlbumsResponseModel> albumsList);
}
