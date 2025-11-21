package avaliacaosimplestcc.mapper;


import avaliacaosimplestcc.model.Perfil;
import avaliacaosimplestcc.DTO.PerfilDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    public PerfilDTO toDTO(Perfil perfil) {
        return new PerfilDTO(
                perfil.getId(),
                perfil.getNome()
        );
    }

    public Perfil toEntity(PerfilDTO dto) {
        Perfil perfil = new Perfil();
        perfil.setId(dto.getId());
        perfil.setNome(dto.getNome());
        return perfil;
    }
}
