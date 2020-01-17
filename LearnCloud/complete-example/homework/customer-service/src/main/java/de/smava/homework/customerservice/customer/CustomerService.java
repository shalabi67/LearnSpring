package de.smava.homework.customerservice.customer;

import de.smava.homework.customerservice.user.UserClient;
import de.smava.homework.customerservice.user.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final UserClient userClient;

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        if(customer == null || StringUtils.isEmpty(customer.getUserId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        try {
            ResponseEntity<UserDTO> userResponse  = userClient.getUser(customer.getUserId());
            if(userResponse == null || userResponse.getStatusCode()!=HttpStatus.OK) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        customer.setId(null);
        return ResponseEntity.ok(customerRepository.save(customer));
    }
}
