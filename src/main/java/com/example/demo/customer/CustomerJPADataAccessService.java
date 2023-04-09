package com.example.demo.customer;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Repository;
@Repository

public class CustomerJPADataAccessService implements CustomerDao {
private final CustomerRepository customerRepository ; 

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
}

    @Override
    public List<Customer> selectAllcustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
    return customerRepository.findById(id) ; 
    }

    @Override
    public void insertCustomer(Customer customer) {
      customerRepository.save(customer) ; 
    }
    
 
    @Override
    public boolean existsPersonWithEmail(String email) {
       return  customerRepository.existsPersonWithEmail(email) ; 
   
    }


    @Override
    public void deleteCustomerById(Integer customerId) {
      customerRepository.deleteById(customerId);
    }

    @Override
    public boolean existsPersonWithid(Integer id) {
      return customerRepository.existsPersonWithid(id);
    }
    
}
