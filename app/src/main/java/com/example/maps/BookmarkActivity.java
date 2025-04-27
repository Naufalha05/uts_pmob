package com.example.maps;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BookmarkActivity extends AppCompatActivity implements BookmarkAdapter.OnBookmarkClickListener {

    private EditText searchBar;

    private ImageView searchIcon;
    private RecyclerView recyclerView;
    private LinearLayout backButton;
    private BookmarkAdapter adapter;
    private ArrayList<Bookmark> bookmarkList;
    private BookmarkDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        searchBar = findViewById(R.id.searchBar);
        searchIcon = findViewById(R.id.searchIcon);
        recyclerView = findViewById(R.id.bookmarkRecyclerView);
        backButton = findViewById(R.id.backButton);

        db = BookmarkDatabase.getInstance(this);
        List<Bookmark> loadedBookmarks = db.bookmarkDao().getAllBookmarks();
        bookmarkList = new ArrayList<>(loadedBookmarks);

        adapter = new BookmarkAdapter(bookmarkList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(BookmarkActivity.this, Home.class);
            startActivity(intent);
            finish();
        });

        searchIcon.setOnClickListener(view -> {
            String query = searchBar.getText().toString().trim();
            filterList(query);
        });
    }

    private void filterList(String query) {
        ArrayList<Bookmark> filtered = new ArrayList<>();
        for (Bookmark item : bookmarkList) {
            if (item.getName().toLowerCase().contains(query.toLowerCase()) ||
                    item.getLocation().toLowerCase().contains(query.toLowerCase())) {
                filtered.add(item);
            }
        }

        if (filtered.isEmpty()) {
            Toast.makeText(this, "Tidak ditemukan", Toast.LENGTH_SHORT).show();
        }

        adapter.updateList(filtered);
    }

    @Override
    public void onDeleteClick(int position) {
        Bookmark toDelete = bookmarkList.get(position);
        db.bookmarkDao().delete(toDelete);
        bookmarkList.remove(position);
        adapter.updateList(bookmarkList);
    }

    @Override
    public void onFavoriteClick(int position) {
        Toast.makeText(this, "Favoritkan: " + bookmarkList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}