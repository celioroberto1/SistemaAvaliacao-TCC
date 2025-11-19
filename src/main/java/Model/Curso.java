package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // teste
    private String nome;
    private String descricao;

    // Coordenador é um usuário com perfil COORDENADOR
    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    private Usuario coordenador;

    @ManyToMany(mappedBy = "cursos")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "curso")
    private List<Tcc> tccs;

    @OneToMany(mappedBy = "curso")
    private List<Prazo> prazos;
}
