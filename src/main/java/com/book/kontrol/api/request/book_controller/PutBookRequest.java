package com.book.kontrol.api.request.book_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class PutBookRequest {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("price")
    public double price;
    @JsonProperty("count")
    public int count;

    @JsonProperty("categories")
    public Collection<CategoryModelForPutBookRequest> categories;
}
