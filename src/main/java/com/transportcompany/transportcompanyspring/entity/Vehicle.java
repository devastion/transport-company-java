package com.transportcompany.transportcompanyspring.entity;

import com.transportcompany.transportcompanyspring.enums.License;
import com.transportcompany.transportcompanyspring.enums.TransportType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Vehicle {
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private Company company;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NonNull
    private License license;
    @Column(nullable = false)
    private TransportType type;
    @Column(nullable = false)
    private int capacity;

    public Vehicle(Company company, @NonNull License license, TransportType transportType, int capacity) {
        this.company = company;
        this.license = license;
        this.type = transportType;
        this.capacity = capacity;
    }
}
