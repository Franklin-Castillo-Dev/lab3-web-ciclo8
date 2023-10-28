package com.mitocode.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlayer;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Integer number;

    @ManyToOne // Establece lsa relación Many-to-One con Position
    @JoinColumn(name = "position_id") // Nombre de la columna de clave foránea en Player
    private Position position;

}
