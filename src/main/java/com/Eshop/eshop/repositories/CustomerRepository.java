package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByemail(String categoryName);

    List<Customer> findAllByIsActive(Boolean isActive);

}
