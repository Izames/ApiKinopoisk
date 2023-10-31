package com.example.apikinopoisk;

import java.util.List;

public class FilmIdClass {
    public int getKinopoiskId() {
        return kinopoiskId;
    }

    public String getKinopoiskHDId() {
        return kinopoiskHDId;
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

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getPosterUrlPreview() {
        return posterUrlPreview;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public double getRatingGoodReview() {
        return ratingGoodReview;
    }

    public int getRatingGoodReviewVoteCount() {
        return ratingGoodReviewVoteCount;
    }

    public double getRatingKinopoisk() {
        return ratingKinopoisk;
    }

    public int getRatingKinopoiskVoteCount() {
        return ratingKinopoiskVoteCount;
    }

    public double getRatingImdb() {
        return ratingImdb;
    }

    public int getRatingImdbVoteCount() {
        return ratingImdbVoteCount;
    }

    public double getRatingFilmCritics() {
        return ratingFilmCritics;
    }

    public int getRatingFilmCriticsVoteCount() {
        return ratingFilmCriticsVoteCount;
    }

    public double getRatingAwait() {
        return ratingAwait;
    }

    public int getRatingAwaitCount() {
        return ratingAwaitCount;
    }

    public double getRatingRfCritics() {
        return ratingRfCritics;
    }

    public int getRatingRfCriticsVoteCount() {
        return ratingRfCriticsVoteCount;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public int getYear() {
        return year;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getEditorAnnotation() {
        return editorAnnotation;
    }

    public boolean isTicketsAvailable() {
        return isTicketsAvailable;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public String getType() {
        return type;
    }

    public String getRatingMpaa() {
        return ratingMpaa;
    }

    public String getRatingAgeLimits() {
        return ratingAgeLimits;
    }

    public boolean isHasImax() {
        return hasImax;
    }

    public boolean isHas3D() {
        return has3D;
    }

    public String getLastSync() {
        return lastSync;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public boolean isSerial() {
        return serial;
    }

    public boolean isShortFilm() {
        return shortFilm;
    }

    public boolean isCompleted() {
        return completed;
    }

    private int kinopoiskId;
    private String kinopoiskHDId;
    private String imdbId;
    private String nameRu;
    private String nameEn;
    private String nameOriginal;
    private String posterUrl;
    private String posterUrlPreview;
    private String coverUrl;
    private String logoUrl;
    private int reviewsCount;
    private double ratingGoodReview;
    private int ratingGoodReviewVoteCount;
    private double ratingKinopoisk;
    private int ratingKinopoiskVoteCount;
    private double ratingImdb;
    private int ratingImdbVoteCount;
    private double ratingFilmCritics;
    private int ratingFilmCriticsVoteCount;
    private double ratingAwait;
    private int ratingAwaitCount;
    private double ratingRfCritics;
    private int ratingRfCriticsVoteCount;
    private String webUrl;
    private int year;
    private int filmLength;
    private String slogan;
    private String description;
    private String shortDescription;
    private String editorAnnotation;
    private boolean isTicketsAvailable;
    private String productionStatus;
    private String type;
    private String ratingMpaa;
    private String ratingAgeLimits;
    private boolean hasImax;
    private boolean has3D;
    private String lastSync;
    private List<Country> countries;
    private List<Genre> genres;
    private int startYear;
    private int endYear;
    private boolean serial;
    private boolean shortFilm;
    private boolean completed;
    public class Country {
        private String country;
        public String getCountry() {
            return country;
        }

        // Конструкторы, геттеры и сеттеры
    }

    public class Genre {
        private String genre;
        public String getGenre() {
            return genre;
        }

        // Конструкторы, геттеры и сеттеры
    }
}