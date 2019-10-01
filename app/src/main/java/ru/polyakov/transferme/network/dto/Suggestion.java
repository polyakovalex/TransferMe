package ru.polyakov.transferme.network.dto;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "iata",
        "type_id",
        "region",
        "country",
        "country_iata"
})
public class Suggestion {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("iata")
    private Object iata;
    @JsonProperty("type_id")
    private String typeId;
    @JsonProperty("region")
    private Object region;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_iata")
    private String countryIata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("iata")
    public Object getIata() {
        return iata;
    }

    @JsonProperty("iata")
    public void setIata(Object iata) {
        this.iata = iata;
    }

    @JsonProperty("type_id")
    public String getTypeId() {
        return typeId;
    }

    @JsonProperty("type_id")
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("region")
    public Object getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(Object region) {
        this.region = region;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country_iata")
    public String getCountryIata() {
        return countryIata;
    }

    @JsonProperty("country_iata")
    public void setCountryIata(String countryIata) {
        this.countryIata = countryIata;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}