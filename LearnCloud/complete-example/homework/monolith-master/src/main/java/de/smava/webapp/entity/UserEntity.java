package de.smava.webapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String id;
    private String email;
    private String password;
    private String role;
}
