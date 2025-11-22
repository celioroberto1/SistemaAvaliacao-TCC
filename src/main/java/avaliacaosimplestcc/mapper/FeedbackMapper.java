package avaliacaosimplestcc.mapper;

import avaliacaosimplestcc.DTO.FeedbackDTO;
import avaliacaosimplestcc.model.Feedback;
import avaliacaosimplestcc.model.TCC;
import avaliacaosimplestcc.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public FeedbackDTO toDTO(Feedback feedback) {
        return new FeedbackDTO(
                feedback.getId(),
                feedback.getComentario(),
                feedback.getAvaliador() != null ? feedback.getAvaliador().getId() : null,
                feedback.getTcc() != null ? feedback.getTcc().getId() : null
        );
    }

    public Feedback toEntity(FeedbackDTO dto) {
        Feedback feedback = new Feedback();
        feedback.setId(dto.getId());
        feedback.setComentario(dto.getComentario());

        Usuario avaliador = new Usuario();
        avaliador.setId(dto.getAvaliadorId());
        feedback.setAvaliador(avaliador);

        TCC tcc = new TCC();
        tcc.setId(dto.getTccId());
        feedback.setTcc(tcc);

        return feedback;
    }
}
