package com.book.kontrol.api.response.book_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryModelForGetBookResponse {

    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
}
