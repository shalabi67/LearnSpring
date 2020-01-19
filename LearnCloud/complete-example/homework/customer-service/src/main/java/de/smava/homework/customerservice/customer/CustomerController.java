package de.smava.homework.customerservice.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.CUSTOMER_URL)
public class CustomerController {
    public static final String CUSTOMER_URL = "/api/customers";

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody Customer customer) {
        return customerService.addCustomer(token, customer);
    }
}
