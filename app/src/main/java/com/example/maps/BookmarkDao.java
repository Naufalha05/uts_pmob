package com.example.maps;

import androidx.room.*;
import java.util.List;

@Dao
public interface BookmarkDao {
    @Insert
    void insert(Bookmark bookmark);

    @Delete
    void delete(Bookmark bookmark);

    @Query("SELECT * FROM bookmarks")
    List<Bookmark> getAllBookmarks();
}