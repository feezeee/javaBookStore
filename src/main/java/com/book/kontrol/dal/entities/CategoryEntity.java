package com.book.kontrol.dal.entities;

import java.util.Collection;

public class CategoryEntity {
    public int id;
    public String name;
    public Collection<BookCategoryEntity> bookCategories;
}
