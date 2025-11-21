package avaliacaosimplestcc.controller;
import avaliacaosimplestcc.DTO.UsuarioDTO;
import avaliacaosimplestcc.mapper.UsuarioMapper;
import avaliacaosimplestcc.model.Usuario;
import avaliacaosimplestcc.service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuarioMapper.toDTO(salvo));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> lista = usuarioService.listarTodos()
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscar(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuarioMapper.toDTO(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(
            @PathVariable Long id,
            @RequestBody UsuarioDTO dto) {

        Usuario usuarioAtualizado = usuarioMapper.toEntity(dto);
        Usuario atualizado = usuarioService.atualizar(id, usuarioAtualizado);

        return ResponseEntity.ok(usuarioMapper.toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
