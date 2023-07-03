package com.inditex.visibility.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SIZES")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "BACK_SOON")
    private boolean backSoon;

    @Column(name = "SPECIAL")
    private boolean special;

    @OneToOne(mappedBy = "size")
    private Stock stock;
}
