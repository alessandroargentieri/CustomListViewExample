package info.androidhive.cardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlbumsAdapter extends ArrayAdapter<Album> {

    private Context mContext;
    private List<Album> albumList;
    /*
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }*/


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        super(mContext,R.layout.album_card,albumList);
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //1. Create inflater
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //2. Get the row View from inflater
        View rowView = inflater.inflate(R.layout.album_card, parent, false);
        //3. Get the elements of album_card_layout
        ImageView thumbImage = (ImageView) rowView.findViewById(R.id.thumbnail);
        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView countText = (TextView) rowView.findViewById(R.id.count);
        final ImageView dotsImage = (ImageView) rowView.findViewById(R.id.overflow);

        Album album = albumList.get(position);
        titleText.setText(album.getName());
        countText.setText(album.getNumOfSongs() + " songs");
        Glide.with(mContext).load(album.getLink()).into(thumbImage);
        dotsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(dotsImage);
            }
        });

        return rowView;
    }


    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }


    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    //@Override
    //public int getItemCount() {
  //      return albumList.size();
  //  }
}
