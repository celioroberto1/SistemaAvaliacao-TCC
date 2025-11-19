package Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Banca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataFormacao;
    private String status;

    // Professores da banca: usuários com perfil AVALIADOR
    @ManyToMany
    @JoinTable(
            name = "banca_professor",
            joinColumns = @JoinColumn(name = "banca_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> avaliadores;

    @ManyToOne
    @JoinColumn(name = "tcc_id")
    private Tcc tcc;
}
