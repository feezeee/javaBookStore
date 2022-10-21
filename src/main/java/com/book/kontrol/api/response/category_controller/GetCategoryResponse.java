package com.book.kontrol.api.response.category_controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCategoryResponse {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
}
