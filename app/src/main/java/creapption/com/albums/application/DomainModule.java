package creapption.com.albums.application;

import com.google.gson.GsonBuilder;

import creapption.com.albums.BuildConfig;
import creapption.com.albums.data.DataManager;
import creapption.com.albums.data.remote.AlbumsService;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by boma24 on 1/13/19.
 */

@Module
public class DomainModule {

    @Provides
    DataManager provideDataManager(AlbumsService albumsService) {
        return new DataManager(albumsService);
    }

    @Provides
    AlbumsService provideAlbumService() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();


        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);

        httpClientBuilder.addNetworkInterceptor(httpLoggingInterceptor);

        OkHttpClient customOkHttpClient = httpClientBuilder.build();

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation();

        return new Retrofit.Builder().baseUrl(BuildConfig.ALBUMS_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(customOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(AlbumsService.class);
    }
}
