package creapption.com.albums.data.remote;

import com.google.gson.annotations.Expose;

/**
 * Created by boma24 on 1/11/19.
 */

public class AlbumsResponseModel {
    @Expose
    private String title;
    @Expose
    private String artist;
    @Expose
    private String url;
    @Expose
    private String image;
    @Expose
    private String thumbnail_image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail_image() {
        return thumbnail_image;
    }

    public void setThumbnail_image(String thumbnail_image) {
        this.thumbnail_image = thumbnail_image;
    }
}
