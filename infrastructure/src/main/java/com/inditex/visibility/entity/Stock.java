package com.inditex.visibility.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "STOCKS")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "SIZE_ID", referencedColumnName = "ID")
    private Size size;

    @Column(name = "QUANTITY")
    private int quantity;
}
