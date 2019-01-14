package creapption.com.albums.main.di;

import creapption.com.albums.application.DomainModule;
import creapption.com.albums.main.ui.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by boma24 on 1/13/19.
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, MainActivityViewModule.class,
            DomainModule.class})
    abstract MainActivity bindMainActivity();
}
