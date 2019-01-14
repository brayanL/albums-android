package creapption.com.albums.main.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import creapption.com.albums.R;
import creapption.com.albums.data.remote.AlbumsResponseModel;


/**
 * Created by boma24 on 1/13/19.
 */

public class AlbumsListAdapter extends RecyclerView.Adapter<AlbumsListAdapter.CustomViewHolder> {

    private List<AlbumsResponseModel> albumsList;

    public AlbumsListAdapter(List<AlbumsResponseModel> albumsList) {
        this.albumsList = albumsList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_albums, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        AlbumsResponseModel album = albumsList.get(position);

        holder.titleTextView.setText(album.getTitle());
        holder.artistTextView.setText(album.getArtist());
        holder.buyButton.setOnClickListener(view ->
                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(album.getUrl()))));
        Picasso.get().load(album.getImage()).fit().into(holder.mainImageView);
        Picasso.get().load(album.getThumbnail_image()).fit().into(holder.thumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return albumsList.size();
    }

    public void updateAlbumList(List<AlbumsResponseModel> albumsList) {
        this.albumsList = albumsList;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.mainImageView)
        ImageView mainImageView;

        @BindView(R.id.thumbnailImageView)
        ImageView thumbnailImageView;

        @BindView(R.id.titleTextView)
        TextView titleTextView;

        @BindView(R.id.artistTextView)
        TextView artistTextView;

        @BindView(R.id.buy_button)
        Button buyButton;

        Unbinder unbinder;

        public CustomViewHolder(View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}
