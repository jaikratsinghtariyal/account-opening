package org.example.service;

import org.example.dao.CustomerRepository;
import org.example.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    final private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Boolean findDuplicate(Customer customer) {

        return !customerRepository.findDuplicate(customer.getCustomername(),
                customer.getDob(),
                customer.getMobilenumber(),
                customer.getEmailid(),
                customer.getPostcode()).isEmpty();
    }

    public Integer createCustomer(Customer customer){
         return customerRepository.save(customer).getCustomerid();
    }
}
