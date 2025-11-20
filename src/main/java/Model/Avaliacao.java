package Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String parecer;
    private Double nota;
    private LocalDate dataAvaliacao;

    @ManyToOne
    @JoinColumn(name = "id_tcc")
    private Tcc tcc;

    @ManyToOne
    @JoinColumn(name = "id_avaliador")
    private Avaliador avaliador;
}
