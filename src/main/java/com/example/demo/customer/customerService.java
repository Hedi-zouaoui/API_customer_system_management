package com.example.demo.customer;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFound;
@Service
public class customerService {
    // gets data from the DAo
    // class of buissness logic
    private final CustomerDao customerDao ; 
    
  
    
    public customerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public List<Customer> getAllCustomers() {
        
        return customerDao.selectAllcustomer() ; 

    }
    

    public Customer  getCustomerById(Integer id) {
        return customerDao.selectCustomerById(id).orElseThrow(
                        () -> new ResourceNotFound("customer [%s] not found".formatted(id)));
         

    }
    
    public void addCustomer ( customerRegistrationRequest customerRegistrationRequest) {
        // check if email exist
        String email = customerRegistrationRequest.email() ; 
        if (customerDao.existsPersonWithEmail(email)) {
           
            // check if email exists // 
            throw new DuplicateResourceException("email [%s] already taken".formatted(email)) ; 
        }

        //// add -else - /// 
        Customer customer = new Customer(   customerRegistrationRequest.name() , customerRegistrationRequest.email() , customerRegistrationRequest.age() );
        customerDao.insertCustomer(customer); 
        
    }  
    public void deleteCustomerById(Integer customerId) {
        if (!customerDao.existsPersonWithid(customerId)) {
            throw new ResourceNotFound("customer with id [%s] not found ".formatted(customerId)) ; 
        }
        customerDao.deleteCustomerById(customerId) ; 
    }  
}
