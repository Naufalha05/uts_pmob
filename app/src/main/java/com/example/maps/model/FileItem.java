package com.example.maps.model;

public class FileItem {
    private String name;  // Faculty name
    private boolean isFolder;
    private String size;  // Type/category of content
    private String date;  // Date info
    private int iconResId;
    private int cardId;
    private String description;  // Faculty description

    public FileItem(String name, boolean isFolder, String size, String date, int iconResId, int cardId, String description) {
        this.name = name;
        this.isFolder = isFolder;
        this.size = size;
        this.date = date;
        this.iconResId = iconResId;
        this.cardId = cardId;
        this.description = description;
    }

    public FileItem(String name, boolean isFolder) {
        this(name, isFolder, "", "", isFolder ?
                com.example.maps.R.drawable.ic_folder :
                com.example.maps.R.drawable.ic_file, -1, "");
    }

    public String getName() {
        return name;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public String getSize() {
        return size;
    }

    public String getDate() {
        return date;
    }

    public int getIconResId() {
        return iconResId;
    }

    public int getCardId() {
        return cardId;
    }

    public String getDescription() {
        return description;
    }
}