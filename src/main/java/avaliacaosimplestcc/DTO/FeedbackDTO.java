package avaliacaosimplestcc.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FeedbackDTO {

    private Long id;
    private String comentario;
    private Long avaliadorId;
    private Long tccId;

    public FeedbackDTO() {}

    public FeedbackDTO(Long id, String comentario, Long avaliadorId, Long tccId) {
        this.id = id;
        this.comentario = comentario;
        this.avaliadorId = avaliadorId;
        this.tccId = tccId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getAvaliadorId() {
        return avaliadorId;
    }

    public void setAvaliadorId(Long avaliadorId) {
        this.avaliadorId = avaliadorId;
    }

    public Long getTccId() {
        return tccId;
    }

    public void setTccId(Long tccId) {
        this.tccId = tccId;
    }
}
