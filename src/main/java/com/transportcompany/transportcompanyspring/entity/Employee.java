package com.transportcompany.transportcompanyspring.entity;

import com.transportcompany.transportcompanyspring.enums.License;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NonNull
    private String name;
    @Column(nullable = false)
    @NonNull
    private License license;
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private Company company;
    @Column(nullable = false)
    private BigDecimal salary;

    public Employee(@NonNull String name, @NonNull License license, Company company, BigDecimal salary) {
        this.name = name;
        this.license = license;
        this.company = company;
        this.salary = salary;
    }
}
