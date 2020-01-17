package de.smava.homework.customerservice.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    private Long id;

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
