package avaliacaosimplestcc.mapper;

import avaliacaosimplestcc.DTO.CursoDTO;
import avaliacaosimplestcc.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNome()
        );
    }

    public Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNome(dto.getNome());
        return curso;
    }
}
