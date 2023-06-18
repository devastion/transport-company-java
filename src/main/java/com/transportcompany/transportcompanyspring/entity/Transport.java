package com.transportcompany.transportcompanyspring.entity;

import com.transportcompany.transportcompanyspring.enums.TransportType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "transports")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NonNull
    private String departure;
    @Column(nullable = false)
    @NonNull
    private String arrival;
    @Column(nullable = false)
    @NonNull
    private BigDecimal price;
    @Column(nullable = false)
    @NonNull
    private TransportType transport;
    @Column(nullable = false)
    private int size;
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(nullable = false)
    private boolean status;
    @Column
    @OneToMany
    private List<Client> clients;

    public Transport(@NonNull String departure, @NonNull String arrival, @NonNull BigDecimal price, @NonNull TransportType transport, int size, Company company, Employee employee, boolean status, List<Client> clients) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.transport = transport;
        this.size = size;
        this.company = company;
        this.employee = employee;
        this.status = status;
        this.clients = clients;
    }
}
