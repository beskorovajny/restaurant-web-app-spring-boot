package com.app.web.restaurant.repository;

import com.app.web.restaurant.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long>, PagingAndSortingRepository<Receipt, Long> {
    @Override
    Optional<Receipt> findById(Long id);
    Optional<List<Receipt>> findAllByCustomer_Id(Long id);
    @Override
    void deleteById(Long id);
}
