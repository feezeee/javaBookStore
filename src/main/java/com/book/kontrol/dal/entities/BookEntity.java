package com.book.kontrol.dal.entities;

import java.util.Collection;

public class BookEntity{
    public int id;
    public String name;
    public String description;
    public double price;
    public int count;

    public Collection<BasketEntity> baskets;
    public Collection<BookCategoryEntity> bookCategories;
}
