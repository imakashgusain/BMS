package com.learning.bms.entity;

import com.learning.bms.config.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.util.Date;

/**
 * The type Customer.
 */
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String gender;

    private String address;

    private String phoneNumber;

    private String panNumber;

    private String nationality;


}
