package de.smava.homework.customerservice.customer;

import de.smava.homework.customerservice.user.UserClient;
import de.smava.homework.customerservice.user.UserDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
/*
eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsibWljcm8iXSwidXNlcl9uYW1lIjoiam9obiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJleHAiOjE1Nzk0NTEyNTksImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI3OWIwMmU2Ny04ZjVhLTRiMDQtYWIxZC1jNWZkZDQwOGQxMzMiLCJjbGllbnRfaWQiOiJjbGllbnQifQ.HqJ5wXLOdOZC-c2txzJxqDzdGGgai2tzehRv5j_GvHNA3T0rUFn-S6fbmgD1PcuNO4vDiZEG6tyvRJKxqnRJ3YjLE7G-ri0FxwlyeCsgl-apLoO-DqhR7lJIsH3xJ_shj8qkimyzBaaa4AwF_0Tl3Prf-uakXNUNqdpOIKezcO6Q6QzDtDwmbhT8VC5QWwMWYpruT6QKgM_MsrRyer44Syz6ogBLCklmNQ9xkiMNlCsOLVgegx-kYwaMBaX74IGCLHsHf4vslUmIeGqRZaD7bV44BSmui618dOB7xABZqZ3LfwJho6gE1BHNnTqks0FQwqf-HuxWdSLtCmqhgw_n9Q
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final UserClient userClient;

    public ResponseEntity<Customer> addCustomer(String token, Customer customer) {
        if (hasInvalidInputData(customer)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ResponseEntity userResponse = getUser(token, customer);
        if(userResponse.getStatusCode() != HttpStatus.OK) {
            return userResponse;
        }

        return saveCustomer(customer);
    }

    private ResponseEntity<UserDTO> getUser(String token, Customer customer){
        try {
            ResponseEntity<UserDTO> userResponse = userClient.getUser(token, customer.getUserId());
            if (userResponse == null || userResponse.getStatusCode() != HttpStatus.OK) {
                return getUserDoesNotExistResponse();
            }
            return userResponse;
        } catch(FeignException feignException) {
            if(feignException.status() == 401) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            return getUserDoesNotExistResponse();
        } catch (Exception e) {
            return getUserDoesNotExistResponse();
        }

    }
    private boolean hasInvalidInputData(Customer customer) {
        return customer == null ||
                StringUtils.isEmpty(customer.getFirstName()) ||
                StringUtils.isEmpty(customer.getLastName()) ||
                StringUtils.isEmpty(customer.getEmail()) ||
                StringUtils.isEmpty(customer.getUserId());
    }

    private ResponseEntity getUserDoesNotExistResponse() {
        return new ResponseEntity("User does not exist", HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Customer> saveCustomer(Customer customer) {
        customer.setId(null);
        try {
            Customer newCustomer =  customerRepository.save(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
