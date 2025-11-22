package avaliacaosimplestcc.mapper;

import avaliacaosimplestcc.DTO.BancaUsuarioDTO;
import avaliacaosimplestcc.model.BancaUsuario;
import avaliacaosimplestcc.model.Banca;
import avaliacaosimplestcc.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class BancaUsuarioMapper {

    public BancaUsuario toEntity(BancaUsuarioDTO dto) {
        if (dto == null) return null;

        Banca banca = null;
        if (dto.getBancaId() != null) {
            banca = Banca.builder().id(dto.getBancaId()).build();  // usa builder com apenas o ID
        }

        Usuario usuario = null;
        if (dto.getUsuarioId() != null) {
            usuario = Usuario.builder().id(dto.getUsuarioId()).build();  // usa builder com apenas o ID
        }

        return BancaUsuario.builder()
                .id(dto.getId())
                .banca(banca)
                .usuario(usuario)
                .build();
    }

    public BancaUsuarioDTO toDTO(BancaUsuario entity) {
        if (entity == null) return null;

        return BancaUsuarioDTO.builder()
                .id(entity.getId())
                .bancaId(entity.getBanca() != null ? entity.getBanca().getId() : null)
                .usuarioId(entity.getUsuario() != null ? entity.getUsuario().getId() : null)
                .build();
    }
}
