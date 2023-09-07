package com.excel.database.repository;

import com.excel.database.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customer,Integer> {

}
