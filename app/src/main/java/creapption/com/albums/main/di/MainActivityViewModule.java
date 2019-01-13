package creapption.com.albums.main.di;

import creapption.com.albums.main.ui.MainActivity;
import creapption.com.albums.main.ui.MainActivityView;
import dagger.Binds;
import dagger.Module;

/**
 * Created by boma24 on 1/13/19.
 */

@Module
public abstract class MainActivityViewModule {

    /**
     * Provide MainActivityView instance.
     * */
    @Binds
    public abstract MainActivityView bindMainActivity(MainActivity mainActivity);
}
