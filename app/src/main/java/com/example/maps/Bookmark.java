package com.example.maps;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookmarks")
public class Bookmark {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String location;

    public Bookmark(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getter & Setter wajib untuk Room
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
}