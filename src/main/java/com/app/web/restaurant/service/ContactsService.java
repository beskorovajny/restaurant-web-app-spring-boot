package com.app.web.restaurant.service;

import com.app.web.restaurant.entity.Contacts;

import java.util.List;

public interface ContactsService {
    boolean isExists(Contacts contacts);
    void saveContacts(Contacts contacts);
    Contacts updateContacts(Contacts contacts);
    Contacts findContactsById(Long id);
    List<Contacts> findAllContacts();
    void deleteContactsById(Long id);
}
