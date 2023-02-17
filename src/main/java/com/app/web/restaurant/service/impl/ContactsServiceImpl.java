package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.entity.Contacts;
import com.app.web.restaurant.repository.ContactsRepository;
import com.app.web.restaurant.service.ContactsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContactsServiceImpl implements ContactsService {
    private final ContactsRepository contactsRepository;

    @Override
    public boolean isExists(Contacts contacts) {
        return contactsRepository.exists(Example.of(contacts));
    }

    @Override
    public void save(Contacts contacts) {
        contactsRepository.save(contacts);
    }

    @Override
    public Contacts update(Contacts contacts) {
        return null;
    }

    @Override
    public Contacts findById(Long id) {
        return contactsRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Contacts> findAll() {
        return contactsRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        contactsRepository.deleteById(id);
    }
}
