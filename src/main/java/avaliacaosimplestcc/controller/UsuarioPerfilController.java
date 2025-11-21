package avaliacaosimplestcc.controller;

import avaliacaosimplestcc.DTO.UsuarioPerfilDTO;
import avaliacaosimplestcc.mapper.UsuarioPerfilMapper;
import avaliacaosimplestcc.model.UsuarioPerfil;
import avaliacaosimplestcc.service.UsuarioPerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario-perfis")
public class UsuarioPerfilController {

    private final UsuarioPerfilService service;
    private final UsuarioPerfilMapper mapper;

    public UsuarioPerfilController(UsuarioPerfilService service, UsuarioPerfilMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // POST - Criar
    @PostMapping
    public ResponseEntity<UsuarioPerfilDTO> criar(@RequestBody UsuarioPerfilDTO dto) {
        UsuarioPerfil entity = mapper.toEntity(dto);
        UsuarioPerfil salvo = service.salvar(entity);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<UsuarioPerfilDTO>> listar() {
        List<UsuarioPerfilDTO> lista = service.listarTodos()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioPerfilDTO> buscarPorId(@PathVariable Long id) {
        UsuarioPerfil entity = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toDTO(entity));
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioPerfilDTO> atualizar(@PathVariable Long id, @RequestBody UsuarioPerfilDTO dto) {
        UsuarioPerfil atualizado = mapper.toEntity(dto);
        UsuarioPerfil salvo = service.atualizar(id, atualizado);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }

    // DELETE - Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
