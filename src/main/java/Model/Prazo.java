package Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Prazo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "tcc_id")
    private Tcc tcc;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Coordenador responsável pelo prazo
    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private Usuario coordenador;
}
