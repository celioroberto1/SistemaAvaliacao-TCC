package avaliacaosimplestcc.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "versao_tcc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VersaoTcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String arquivoUrl;


    private LocalDate dataEnvio;


    @ManyToOne
    @JoinColumn(name = "tcc_id")
    private TCC tcc;
}