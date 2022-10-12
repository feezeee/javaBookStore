package com.book.kontrol.api.request.book_controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Optional;

public class PutBookRequest {
    public int getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    @JsonProperty("desc")
    public void setDescription(String description) {
        this.description = description;
    }

    public int id;
    public String name;
    public String description;
}
