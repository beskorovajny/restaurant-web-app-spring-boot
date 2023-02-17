package com.app.web.restaurant.repository;

import com.app.web.restaurant.entity.ReceiptHasDish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReceiptHasDishRepository extends CrudRepository<ReceiptHasDish, Long> {
    Optional<List<ReceiptHasDish>> findAllByReceiptId(Long id);
}
