package com.example.myspringdata.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Logging")
@Data

public class Logging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "balans")
    private Integer balans;

    public Logging() {
    }
    public Logging(Integer id, Integer balans) {
        this.id = id;
        this.balans = balans;
    }
}
