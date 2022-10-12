package com.book.kontrol.api.request.book_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class PostBookRequest {
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

    public String name;
    public String description;
}
