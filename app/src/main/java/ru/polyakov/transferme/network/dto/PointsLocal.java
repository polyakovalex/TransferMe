package ru.polyakov.transferme.network.dto;

import com.google.gson.annotations.SerializedName;

public class PointsLocal {
    @SerializedName("name") private String Name;

    public String getName() {
        return Name;
    }
}
