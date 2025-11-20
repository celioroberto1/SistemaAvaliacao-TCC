package Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "id_tcc")
    private Tcc tcc;
}
