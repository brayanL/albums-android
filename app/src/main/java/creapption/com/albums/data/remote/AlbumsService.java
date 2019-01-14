package creapption.com.albums.data.remote;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by boma24 on 1/11/19.
 */

public interface AlbumsService {

    @GET("api/music_albums")
    Observable<List<AlbumsResponseModel>> getAlbums();
}
