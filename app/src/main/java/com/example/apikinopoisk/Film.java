package com.example.apikinopoisk;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private int total;
    private int totalPages;
    private ArrayList<Item> items;

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public class Item {
        private int kinopoiskId;
        private String imdbId;
        private String nameRu;
        private String nameEn;
        private String nameOriginal;
        private List<Country> countries;
        private List<Genre> genres;
        private double ratingKinopoisk;
        private Double ratingImdb;
        private int year;
        private String type;
        @SerializedName("posterUrl")
        private String posterUrl;
        @SerializedName("posterUrlPreview")
        private String posterUrlPreview;

        public int getKinopoiskId() {
            return kinopoiskId;
        }

        public String getImdbId() {
            return imdbId;
        }

        public String getNameRu() {
            return nameRu;
        }

        public String getNameEn() {
            return nameEn;
        }

        public String getNameOriginal() {
            return nameOriginal;
        }

        public List<Country> getCountries() {
            return countries;
        }

        public List<Genre> getGenres() {
            return genres;
        }

        public double getRatingKinopoisk() {
            return ratingKinopoisk;
        }

        public Double getRatingImdb() {
            return ratingImdb;
        }

        public int getYear() {
            return year;
        }

        public String getType() {
            return type;
        }

        public String getPosterUrl() {
            return posterUrl;
        }

        public String getPosterUrlPreview() {
            return posterUrlPreview;
        }
    }

    public class Country {
        private String country;

        public String getCountry() {
            return country;
        }
    }

    public class Genre {
        private String genre;

        public String getGenre() {
            return genre;
        }
    }
}