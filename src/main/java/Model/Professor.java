package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String tipo;

    @OneToMany(mappedBy = "orientador")
    private List<Tcc> tccs;

    @OneToMany(mappedBy = "professor")
    private List<Banca> bancas;

    @OneToMany(mappedBy = "coordenador")
    private List<Prazo> prazos;

    // Getters e setters
}
