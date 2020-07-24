package com.example.reconcile;

public class Group {

    private String Name;
    private int Thumbnail;

    public Group() {
    }

    public Group(String name, int thumbnail) {
        Name = name;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return Name;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

}
