package com.example.apikinopoisk;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideoClass {
    @SerializedName("total")
    private int total;

    @SerializedName("items")
    private ArrayList<Item> items;

    public int getTotal() {
        return total;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public class Item {
        @SerializedName("url")
        private String url;

        @SerializedName("name")
        private String name;

        @SerializedName("site")
        private String site;

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        public String getSite() {
            return site;
        }
    }
}