package com.example.o_o.class2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Leandro Leonardo | 2018.
 */

public class person implements Parcelable {

    private String name;
    private String about;
    private String email;
    private int repos;
    private int stars;
    private int projects;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRepos() {
        return repos;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getProjects() {
        return projects;
    }

    public void setProjects(int projects) {
        this.projects = projects;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.about);
        dest.writeString(this.email);
        dest.writeInt(this.repos);
        dest.writeInt(this.stars);
        dest.writeInt(this.projects);
    }

    public person() {
    }

    protected person(Parcel in) {
        this.name = in.readString();
        this.about = in.readString();
        this.email = in.readString();
        this.repos = in.readInt();
        this.stars = in.readInt();
        this.projects = in.readInt();
    }

    public static final Creator<person> CREATOR = new Creator<person>() {
        @Override
        public person createFromParcel(Parcel source) {
            return new person(source);
        }

        @Override
        public person[] newArray(int size) {
            return new person[size];
        }
    };
}
