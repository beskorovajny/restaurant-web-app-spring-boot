package com.app.web.restaurant.service;

import com.app.web.restaurant.entity.Contacts;

import java.util.List;

public interface ContactsService {
    boolean isExists(Contacts contacts);

    void save(Contacts contacts);

    Contacts update(Contacts contacts);

    Contacts findById(Long id);

    List<Contacts> findAll();

    void deleteById(Long id);
}
