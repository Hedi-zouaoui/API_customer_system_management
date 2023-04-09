package com.example.demo.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
    // read from the DB // 

List<Customer> findByEmail(String email);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email = :email")
    boolean existsPersonWithEmail(String email);
   
  
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.id = :customerId")
    boolean    existsPersonWithid(Integer customerId);

    @Modifying
    @Query("DELETE FROM Customer c WHERE c.id = :customerId")
    void deleteById(Long customerId);
    
}
