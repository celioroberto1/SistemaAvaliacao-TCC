package avaliacaosimplestcc.DTO;
public class UsuarioPerfilDTO {

    private Long id;
    private Long usuarioId;
    private Long perfilId;

    public UsuarioPerfilDTO() {}

    public UsuarioPerfilDTO(Long id, Long usuarioId, Long perfilId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.perfilId = perfilId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }
}
