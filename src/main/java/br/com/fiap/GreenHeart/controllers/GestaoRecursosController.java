package br.com.fiap.GreenHeart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.GreenHeart.exception.RestNotFoundException;
import br.com.fiap.GreenHeart.models.GestaoRecursos;
import br.com.fiap.GreenHeart.repository.GestaoRecursosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/gestao")
@Slf4j
public class GestaoRecursosController {

    @Autowired
    GestaoRecursosRepository gestaoRecursosRepository; 

    @GetMapping
    public Page<GestaoRecursos> index(Pageable pageable) {
        return gestaoRecursosRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<GestaoRecursos>> create(
            @RequestBody @Valid GestaoRecursos gestao,
            BindingResult result) {
        log.info("cadastrando informação: " + gestao);
        gestaoRecursosRepository.save(gestao);
        return ResponseEntity
            .created(gestao.toEntityModel().getRequiredLink("self").toUri())
            .body(gestao.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<GestaoRecursos> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getGestaoRecursos(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<GestaoRecursos> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        gestaoRecursosRepository.delete(getGestaoRecursos(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<GestaoRecursos>> update(
            @PathVariable Long id,
            @RequestBody @Valid GestaoRecursos gestao) {
        log.info("atualizando informação: " + id);
        getGestaoRecursos(id);
        gestao.setId(id);
        gestaoRecursosRepository.save(gestao);
        return ResponseEntity.ok(gestao.toEntityModel());
    }

    private GestaoRecursos getGestaoRecursos(Long id) {
        return gestaoRecursosRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}
