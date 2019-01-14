package creapption.com.albums.main.di;

import creapption.com.albums.data.DataManager;
import creapption.com.albums.main.MainActivityPresenter;
import creapption.com.albums.main.MainActivityPresenterImpl;
import creapption.com.albums.main.ui.MainActivityView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by boma24 on 1/12/19.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter provideMainActivityPresenter(MainActivityView mainActivityView,
                                                       DataManager dataManager) {
        return new MainActivityPresenterImpl(mainActivityView, dataManager);
    }
}

