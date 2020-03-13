package de.smava.webapp.service;

import de.smava.webapp.entity.CustomerEntity;
import de.smava.webapp.entity.UserEntity;
import de.smava.webapp.exception.UserNotFoundException;
import de.smava.webapp.model.CustomerDTO;
import de.smava.webapp.model.UserDTO;
import de.smava.webapp.repository.CustomerRepository;
import de.smava.webapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    @Transactional
    public CustomerDTO create(CustomerDTO customerDTO, UserDTO userDTO) {
        Optional<UserEntity> optionalUser = userRepository.findById(userDTO.getId());
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException();
        }
        CustomerEntity customer = new CustomerEntity();
        BeanUtils.copyProperties(customerDTO, customer);
        customer.setUser(optionalUser.get());
        customerRepository.save(customer);
        log.info("Saved customer with id: {}", customer.getId());
        customerDTO.setId(customer.getId());
        return customerDTO;
    }
}
