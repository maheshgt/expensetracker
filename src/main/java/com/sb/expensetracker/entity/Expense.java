package com.sb.expensetracker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_name")
    @NotNull(message = "name should not be null!")
    @Size(min = 3, message = "min three characters!")
    @NotBlank(message = "name should not be blank!")
    private String name;

    @NotNull(message = "description should not be null!")
    @NotBlank(message = "name should not be blank!")
    private String description;

    @Column(name = "expense_amount")
    private BigDecimal amount;

    @NotNull(message = "category should not be null!")
    @Size(min = 3, message = "min three characters!")
    @NotBlank(message = "category should not be blank!")
    private String category;

    private Date date;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

}
