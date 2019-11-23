package com.famio.made.submission2.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class DaftarTayang implements Parcelable {
    private int poster;
    private String name;
    private String rating;
    private String language;
    private String runtime;
    private String budget;
    private String revenue;
    private String crew;
    private String genre;
    private String keyword;
    private String description;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.name);
        dest.writeString(this.rating);
        dest.writeString(this.language);
        dest.writeString(this.runtime);
        dest.writeString(this.budget);
        dest.writeString(this.revenue);
        dest.writeString(this.crew);
        dest.writeString(this.genre);
        dest.writeString(this.keyword);
        dest.writeString(this.description);
    }

    public DaftarTayang() {
    }

    protected DaftarTayang(Parcel in) {
        this.poster = in.readInt();
        this.name = in.readString();
        this.rating = in.readString();
        this.language = in.readString();
        this.runtime = in.readString();
        this.budget = in.readString();
        this.revenue = in.readString();
        this.crew = in.readString();
        this.genre = in.readString();
        this.keyword = in.readString();
        this.description = in.readString();
    }

    public static final Creator<DaftarTayang> CREATOR = new Creator<DaftarTayang>() {
        @Override
        public DaftarTayang createFromParcel(Parcel source) {
            return new DaftarTayang(source);
        }

        @Override
        public DaftarTayang[] newArray(int size) {
            return new DaftarTayang[size];
        }
    };
}
