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
public class Banca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataFormacao;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @OneToOne(mappedBy = "banca")
    private Tcc tcc;

    // Getters e setters
}
