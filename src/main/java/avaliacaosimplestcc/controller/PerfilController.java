package avaliacaosimplestcc.controller;

import avaliacaosimplestcc.service.PerfilService;
import avaliacaosimplestcc.model.Perfil;
import avaliacaosimplestcc.DTO.PerfilDTO;
import avaliacaosimplestcc.mapper.PerfilMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/perfis")
public class PerfilController {

    private final PerfilService perfilService;
    private final PerfilMapper perfilMapper;

    public PerfilController(PerfilService perfilService, PerfilMapper perfilMapper) {
        this.perfilService = perfilService;
        this.perfilMapper = perfilMapper;
    }

    // POST - Criar Perfil
    @PostMapping
    public ResponseEntity<PerfilDTO> criar(@RequestBody PerfilDTO dto) {
        Perfil perfil = perfilMapper.toEntity(dto);
        Perfil salvo = perfilService.salvar(perfil);
        return ResponseEntity.ok(perfilMapper.toDTO(salvo));
    }

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<PerfilDTO>> listar() {
        List<PerfilDTO> lista = perfilService.listarTodos()
                .stream()
                .map(perfilMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> buscarPorId(@PathVariable Long id) {
        Perfil perfil = perfilService.buscarPorId(id);
        return ResponseEntity.ok(perfilMapper.toDTO(perfil));
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> atualizar(@PathVariable Long id, @RequestBody PerfilDTO dto) {
        Perfil perfilAtualizado = perfilMapper.toEntity(dto);
        Perfil atualizado = perfilService.atualizar(id, perfilAtualizado);
        return ResponseEntity.ok(perfilMapper.toDTO(atualizado));
    }

    // DELETE - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        perfilService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
