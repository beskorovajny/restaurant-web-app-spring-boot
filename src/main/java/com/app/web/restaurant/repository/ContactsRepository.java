package com.app.web.restaurant.repository;

import com.app.web.restaurant.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ContactsRepository extends JpaRepository<Contacts, Long>, PagingAndSortingRepository<Contacts, Long> {
    @Override
    Optional<Contacts> findById(Long id);

}
