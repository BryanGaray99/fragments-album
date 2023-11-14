package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.bgaray.fragmentsalbum.R;

import java.util.List;
import models.Album;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> albums;
    private Context context;

    public AlbumAdapter(List<Album> albums, Context context) {
        this.albums = albums;
        this.context = context;
    }

    @Nullable
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.album_item, parent, false);
        return new ViewHolder(view);


    }
    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder,int position){
        Album album = albums.get(position);
        holder.setAlbumData(album);
    }

    @Override
    public int getItemCount () {
        return albums.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCover;
        private TextView tvTitle, tvArtist, tcGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.albumCover);
            tvArtist = itemView.findViewById(R.id.albumArtist);
            tvTitle = itemView.findViewById(R.id.albumTitle);
            tcGenre = itemView.findViewById(R.id.albumGenre);
        }

        public void setAlbumData(Album album) {
            // Usamos Glide para traer imágenes de internet y devolverlas a imgCover
            Glide.with(context).load(album.getImageUrl()).into(imgCover);

            tvTitle.setText(album.getTitle());
            tvArtist.setText(album.getArtist());
            tcGenre.setText(album.getGenre());
        }
    }
}
