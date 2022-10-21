package com.book.kontrol.api.request.book_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryModelForPostBookRequest {
    @JsonProperty("id")
    public int id;
}
