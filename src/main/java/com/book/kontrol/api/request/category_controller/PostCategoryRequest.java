package com.book.kontrol.api.request.category_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostCategoryRequest {
    @JsonProperty("name")
    public String name;
}
