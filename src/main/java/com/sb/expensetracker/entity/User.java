package com.sb.expensetracker.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    @NotNull(message = "name should not be null!")
    @Size(min = 3, message = "min three characters!")
    @NotBlank(message = "name should not be blank!")
    private String name;


    @Column(name = "user_pwd")
    @NotNull(message = "password should not be null!")
    @Size(min = 4, message = "min four characters!")
    @NotBlank(message = "password should not be blank!")
    private String password;


    @Email
    @Column(name = "user_email", unique = true)
    @NotNull(message = "name should not be null!")
    @Size(min = 3, message = "min three characters!")
    @NotBlank(message = "name should not be blank!")
    private String email;

    @NotNull(message = "age should not be null!")
    @Size(min = 15, max = 100)
    private Long age;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

}
