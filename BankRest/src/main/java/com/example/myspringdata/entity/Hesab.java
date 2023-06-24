package com.example.myspringdata.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="hesab")
@Data
public class Hesab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "balans")
    private Integer balans;
    @Column(name = "tranzaksiya")
    private Integer tranzaksiya;

       public Hesab() {
    }

}
