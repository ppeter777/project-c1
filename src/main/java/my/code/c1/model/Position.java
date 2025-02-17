package my.code.c1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(min = 3, max = 1000)
    private String fen;
}
