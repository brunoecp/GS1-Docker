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
import br.com.fiap.GreenHeart.models.Variedades;
import br.com.fiap.GreenHeart.repository.VariedadesRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/variedades")
@Slf4j
public class VariedadesController {

    @Autowired
    VariedadesRepository variedadesRepository; 
    
    @GetMapping
    public Page<Variedades> index(Pageable pageable) {
        return variedadesRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Variedades>> create(
            @RequestBody @Valid Variedades variedade,
            BindingResult result) {
        log.info("cadastrando informação: " + variedade);
        variedadesRepository.save(variedade);
        return ResponseEntity
            .created(variedade.toEntityModel().getRequiredLink("self").toUri())
            .body(variedade.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<Variedades> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getVariedades(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Variedades> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        variedadesRepository.delete(getVariedades(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<Variedades>> update(
            @PathVariable Long id,
            @RequestBody @Valid Variedades variedade) {
        log.info("atualizando informação: " + id);
        getVariedades(id);
        variedade.setId(id);
        variedadesRepository.save(variedade);
        return ResponseEntity.ok(variedade.toEntityModel());
    }

    private Variedades getVariedades(Long id) {
        return variedadesRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}
