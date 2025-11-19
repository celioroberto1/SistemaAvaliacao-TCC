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
public class VersaoTcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String caminhoArquivo;
    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "tcc_id")
    private Tcc tcc;
}
