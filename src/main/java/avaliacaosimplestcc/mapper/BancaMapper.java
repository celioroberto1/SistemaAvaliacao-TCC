package avaliacaosimplestcc.mapper;
import avaliacaosimplestcc.DTO.BancaDTO;
import avaliacaosimplestcc.model.Banca;
import avaliacaosimplestcc.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class BancaMapper {

    public BancaDTO toDTO(Banca banca) {
        if (banca == null) return null;

        return BancaDTO.builder()
                .id(banca.getId())
                .descricao(banca.getDescricao())
                .cursoId(banca.getCurso() != null ? banca.getCurso().getId() : null)
                .build();
    }

    public Banca toEntity(BancaDTO dto) {
        if (dto == null) return null;

        Banca banca = Banca.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .build();

        if (dto.getCursoId() != null) {
            Curso curso = new Curso();
            curso.setId(dto.getCursoId());
            banca.setCurso(curso);
        }

        return banca;
    }
}
