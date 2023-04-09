package com.example.demo.customer;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
// send data to the server 
private final customerService customerService ; 

    public CustomerController(customerService customerService) {
    this.customerService = customerService;
}

    @GetMapping(path = "api/customer")
    public List<Customer> getrCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "api/customer/{id}")
    public Customer getrCustomer(@PathVariable("id") Integer id) {
        
 return customerService.getCustomerById(id) ; 
       
    }  
    @PostMapping(path = "api/customer")
    public void registerCustomer(@RequestBody customerRegistrationRequest request ) {
        customerService.addCustomer(request);
    } 
@DeleteMapping("api/customer/delete/{customerId}")
        public void deleteCustomer (
        
        @PathVariable("customerId") Integer customerId ) {
        customerService.deleteCustomerById(customerId) ;
        }
      
    
}
