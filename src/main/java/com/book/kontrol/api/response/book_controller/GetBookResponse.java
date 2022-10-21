package com.book.kontrol.api.response.book_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetBookResponse {
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
    public List<CategoryModelForGetBookResponse> categories;
}
