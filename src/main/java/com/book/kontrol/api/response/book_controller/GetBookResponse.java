package com.book.kontrol.api.response.book_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class GetBookResponse {
    @JsonProperty("id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("desc")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int id;
    public String name;
    public String description;
}
