package com.example.demo.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllcustomer() ; 
    
    Optional<Customer> selectCustomerById(Integer id);
    void insertCustomer(Customer customer) ;
    boolean existsPersonWithEmail(String email ) ; 
    
    boolean existsPersonWithid(Integer id );
 void deleteCustomerById(Integer customerId ) ;  

   
    
}
