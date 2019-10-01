package ru.polyakov.transferme.network.dto;

import com.google.gson.annotations.SerializedName;

public class Points {
    @SerializedName("name") private String Name;

    public String getName() {
        return Name;
    }
}
