package com.app.web.restaurant.repository;

import com.app.web.restaurant.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactsRepository extends JpaRepository<Contacts, Long>, PagingAndSortingRepository<Contacts, Long> {
}
