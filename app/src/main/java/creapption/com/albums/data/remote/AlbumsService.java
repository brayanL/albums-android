package creapption.com.albums.data.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by boma24 on 1/11/19.
 */

public interface AlbumsService {

    @GET("api/music_albums")
    Observable<AlbumsResponseModel> getAlbums();
}
