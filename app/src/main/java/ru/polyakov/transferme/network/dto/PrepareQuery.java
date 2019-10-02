package ru.polyakov.transferme.network.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PrepareQuery {
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("suggestions")
    @Expose
    private List<Suggestion> suggestions = null;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

}
