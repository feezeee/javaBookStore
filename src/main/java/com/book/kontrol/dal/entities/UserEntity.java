package com.book.kontrol.dal.entities;

import java.util.Collection;

public class UserEntity {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String login;
    public String password;
    public int userTypeId;
    public UserTypeEntity userType;
    public Collection<BasketEntity> baskets;
}
