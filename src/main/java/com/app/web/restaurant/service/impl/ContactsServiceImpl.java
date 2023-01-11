package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.model.Contacts;
import com.app.web.restaurant.service.ContactsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContactsServiceImpl implements ContactsService {
    @Override
    public boolean isExists(Contacts contacts) {
        return false;
    }

    @Override
    public void saveContacts(Contacts contacts) {

    }

    @Override
    public Contacts updateContacts(Contacts contacts) {
        return null;
    }

    @Override
    public Contacts findContactsById(Long id) {
        return null;
    }

    @Override
    public List<Contacts> findAllContacts() {
        return null;
    }

    @Override
    public void deleteContactsById(Long id) {

    }
}
