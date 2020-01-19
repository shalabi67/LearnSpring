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

    public ResponseEntity<Customer> addCustomer(String token, Customer customer) {
        if (!validateInputData(customer)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            ResponseEntity<UserDTO> userResponse = userClient.getUser(token, customer.getUserId());
            if (userResponse == null || userResponse.getStatusCode() != HttpStatus.OK) {
                return new ResponseEntity("User does not exist", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity("User does not exist", HttpStatus.NOT_FOUND);
        }

        return saveCustomer(customer);
    }

    private boolean validateInputData(Customer customer) {
        return customer == null ||
                StringUtils.isEmpty(customer.getFirstName()) ||
                StringUtils.isEmpty(customer.getLastName()) ||
                StringUtils.isEmpty(customer.getEmail()) ||
                StringUtils.isEmpty(customer.getUserId());
    }

    private ResponseEntity<Customer> saveCustomer(Customer customer) {
        customer.setId(null);
        try {
            return ResponseEntity.ok(customerRepository.save(customer));
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
