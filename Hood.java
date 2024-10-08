package com.orders.cristmas.santa.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hood {

    @NotNull
    private String hoodCapacity;
    @NotEmpty
    private String[] presentWeights;

}
