package com.orders.cristmas.santa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class HoodEntity {
    @GeneratedValue
    @Id
    private Long ID;
    private String hoodCapacity;
    private String hoodWeights;

}
