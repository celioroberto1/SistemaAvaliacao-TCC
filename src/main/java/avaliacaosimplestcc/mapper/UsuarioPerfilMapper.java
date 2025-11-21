package avaliacaosimplestcc.mapper;
import avaliacaosimplestcc.DTO.UsuarioPerfilDTO;
import avaliacaosimplestcc.model.UsuarioPerfil;
import avaliacaosimplestcc.model.Usuario;
import avaliacaosimplestcc.model.Perfil;
import org.springframework.stereotype.Component;

@Component
public class UsuarioPerfilMapper {

    public UsuarioPerfilDTO toDTO(UsuarioPerfil entity) {
        return new UsuarioPerfilDTO(
                entity.getId(),
                entity.getUsuario() != null ? entity.getUsuario().getId() : null,
                entity.getPerfil() != null ? entity.getPerfil().getId() : null
        );
    }

    public UsuarioPerfil toEntity(UsuarioPerfilDTO dto) {
        UsuarioPerfil up = new UsuarioPerfil();

        up.setId(dto.getId());

        // Apenas instanciamos os objetos com ID (boa prática p/ relacionamento)
        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuarioId());

        Perfil perfil = new Perfil();
        perfil.setId(dto.getPerfilId());

        up.setUsuario(usuario);
        up.setPerfil(perfil);

        return up;
    }
}

