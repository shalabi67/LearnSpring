package de.smava.homework.customerservice.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.CUSTOMER_URL)
@RequiredArgsConstructor
public class CustomerController {
    public static final String CUSTOMER_URL = "/api/customers";

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody Customer customer) {
        return customerService.addCustomer(token, customer);
    }
}
