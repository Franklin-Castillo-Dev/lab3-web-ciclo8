package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PositionDTO {
    @EqualsAndHashCode.Include
    private Integer idPosition;

    @NotEmpty
    @Size(min = 3, message = "{name.size}")
    private String name;
}
