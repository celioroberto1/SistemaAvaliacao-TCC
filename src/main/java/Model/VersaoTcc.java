package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @JoinColumn(name = "id_tcc")
    private Tcc tcc;

    // Getters e setters
}

