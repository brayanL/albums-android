package creapption.com.albums.main.di;

import javax.inject.Singleton;

import creapption.com.albums.AlbumsApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by boma24 on 1/12/19.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class, BuildersModule.class})
public interface MainActivityComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(AlbumsApplication application);
        MainActivityComponent build();
    }
    void inject(AlbumsApplication albumsApplication);
}
