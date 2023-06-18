package com.transportcompany.transportcompanyspring.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NonNull
    private String name;
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private Company company;

    public Client(@NonNull String name, Company company) {
        this.name = name;
        this.company = company;
    }
}
