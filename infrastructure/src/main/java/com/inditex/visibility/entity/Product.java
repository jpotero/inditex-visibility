package com.inditex.visibility.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SEQUENCE")
    private int sequence;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Size> sizeList;
}
