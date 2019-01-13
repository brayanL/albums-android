package creapption.com.albums.main;

import creapption.com.albums.main.ui.MainActivityView;

/**
 * Created by boma24 on 1/12/19.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView mainActivityView;

    public MainActivityPresenterImpl(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    @Override
    public void getAlbums() {
        mainActivityView.showMessages();
    }
}
