package com.book.kontrol.bll.entities;

import java.util.Optional;

public class BookEntity{
    public int id;
    public String name;
    public String description;
    public BookEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public BookEntity() {
    }
}
