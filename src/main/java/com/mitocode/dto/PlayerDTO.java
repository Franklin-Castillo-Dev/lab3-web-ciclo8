package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PlayerDTO {

    @EqualsAndHashCode.Include
    private Integer idPlayer;

    @NotEmpty
    @Size(min = 3, message = "{name.size}")
    private String name;

    private Integer number;


    private PositionDTO positionDTO;
}
