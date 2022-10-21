package com.book.kontrol.api.request.category_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PutCategoryRequest {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
}
