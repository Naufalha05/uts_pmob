//BookmarkAdapter.java
package com.example.maps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder> {

    private ArrayList<Bookmark> bookmarkList;
    private OnBookmarkClickListener listener;

    public interface OnBookmarkClickListener {
        void onDeleteClick(int position);
        void onFavoriteClick(int position);
    }

    public BookmarkAdapter(ArrayList<Bookmark> list, OnBookmarkClickListener listener) {
        this.bookmarkList = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bookmark, parent, false);
        return new BookmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        Bookmark bookmark = bookmarkList.get(position);
        holder.title.setText(bookmark.getName());
        holder.subtitle.setText(bookmark.getLocation());

        // Click listener
        holder.deleteIcon.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteClick(position);
            }
        });

        holder.favoriteIcon.setOnClickListener(v -> {
            if (listener != null) {
                listener.onFavoriteClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookmarkList.size();
    }

    public static class BookmarkViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        ImageView deleteIcon, favoriteIcon;

        public BookmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.bookmarkItemTitle);
            subtitle = itemView.findViewById(R.id.bookmarkItemSubtitle);
            deleteIcon = itemView.findViewById(R.id.bookmarkDeleteIcon);
            favoriteIcon = itemView.findViewById(R.id.bookmarkFavoriteIcon);
        }
    }

    public void updateList(ArrayList<Bookmark> newList) {
        bookmarkList = newList;
        notifyDataSetChanged();
    }
}