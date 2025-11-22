package avaliacaosimplestcc.mapper;

import avaliacaosimplestcc.DTO.CursoUsuarioDTO;
import avaliacaosimplestcc.model.CursoUsuario;
import avaliacaosimplestcc.model.Curso;
import avaliacaosimplestcc.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class CursoUsuarioMapper {

    public CursoUsuario toEntity(CursoUsuarioDTO dto) {
        if (dto == null) return null;

        CursoUsuario entity = new CursoUsuario();
        entity.setId(dto.getId());

        if (dto.getCursoId() != null) {
            Curso curso = new Curso();
            curso.setId(dto.getCursoId());
            entity.setCurso(curso);
        }

        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            entity.setUsuario(usuario);
        }

        return entity;
    }


    public CursoUsuarioDTO toDTO(CursoUsuario entity) {
        if (entity == null) return null;

        return new CursoUsuarioDTO(
                entity.getId(),
                entity.getCurso() != null ? entity.getCurso().getId() : null,
                entity.getUsuario() != null ? entity.getUsuario().getId() : null
        );
    }
}
