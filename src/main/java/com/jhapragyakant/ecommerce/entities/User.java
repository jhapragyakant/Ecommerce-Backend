package com.jhapragyakant.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String userId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, length = 50)
    private String userEmail;

    @Column(name = "password", nullable = false)
    private String userPassword;

    @Column(name = "first_name", nullable = false)
    private String userFirstName;

    @Column(name = "last_name")
    private String userLastName;

    @Column(name = "address", nullable = false)
    private String userAddress;

    @Column(name = "dob", nullable = false)
    private LocalDate userDateOfBirth;

    @Column(name = "phone_no", nullable = false)
    private String userPhone;

    @Column(name = "gender",nullable = false)
    private String userGender;
}
