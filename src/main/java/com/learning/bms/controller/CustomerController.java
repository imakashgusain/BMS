package com.learning.bms.controller;

import com.learning.bms.entity.Customer;
import com.learning.bms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    /**
     * Gets all customers.
     *
     * @return the all customers
     */
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Gets customer by id.
     *
     * @param customerId the customer id
     * @return the customer by id
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Create customer customer.
     *
     * @param customer the customer
     * @return the customer
     */
    @PostMapping("/{post}")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    /**
     * Update customer response entity.
     *
     * @param customerId      the customer id
     * @param updatedCustomer the updated customer
     * @return the response entity
     */
    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Long customerId,
            @RequestBody Customer updatedCustomer) {
        Customer updated = customerService.updateCustomer(customerId, updatedCustomer);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete customer response entity.
     *
     * @param customerId the customer id
     * @return the response entity
     */
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

}
