package com.book.kontrol.bll.models.output.book;

import java.util.Collection;

public class GetBookOutput {
    public int id;
    public String name;
    public String description;
    public double price;
    public int count;
    public Collection<CategoryModelForGetBookOutput> categories;
}
