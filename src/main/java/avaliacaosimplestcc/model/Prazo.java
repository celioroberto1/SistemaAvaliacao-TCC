package avaliacaosimplestcc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prazo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prazo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate dataEntrega;


    @ManyToOne
    @JoinColumn(name = "tcc_id")
    private TCC tcc;
}