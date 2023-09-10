package com.learning.bms.service;

import com.learning.bms.entity.Customer;
import com.learning.bms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Customer service.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Gets all customers.
     *
     * @return the all customers
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Gets customer by id.
     *
     * @param customerId the customer id
     * @return the customer by id
     */
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    /**
     * Save customer customer.
     *
     * @param customer the customer
     * @return the customer
     */
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Delete customer.
     *
     * @param customerId the customer id
     */
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    /**
     * Update customer customer.
     *
     * @param customerId      the customer id
     * @param updatedCustomer the updated customer
     * @return the customer
     */
    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer == null) {
            return null; // Or throw an exception indicating customer not found
        }

        // Update fields based on the updatedCustomer object
        existingCustomer.setFirstName(updatedCustomer.getFirstName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        // Update other fields as needed

        return customerRepository.save(existingCustomer);
    }





}
