package de.smava.webapp.service;

import de.smava.webapp.entity.LoanEntity;
import de.smava.webapp.entity.CustomerEntity;
import de.smava.webapp.exception.CustomerNotFoundException;
import de.smava.webapp.model.CustomerDTO;
import de.smava.webapp.model.LoanDTO;
import de.smava.webapp.model.LoanStatus;
import de.smava.webapp.repository.LoanRepository;
import de.smava.webapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public LoanDTO create(LoanDTO loanDTO, CustomerDTO customerDto) {
        Optional<CustomerEntity> customerOpt = customerRepository.findById(customerDto.getId());
        if (!customerOpt.isPresent()) {
            throw new CustomerNotFoundException();
        }
        loanDTO.setId(UUID.randomUUID().toString());
        loanDTO.setStatus(LoanStatus.CREATED);
        LoanEntity loan = new LoanEntity();
        BeanUtils.copyProperties(loanDTO, loan);
        loan.setCustomer(customerOpt.get());
        loanRepository.save(loan);
        log.info("Saved loan with id: {}", loan.getId());
        return loanDTO;
    }
}
