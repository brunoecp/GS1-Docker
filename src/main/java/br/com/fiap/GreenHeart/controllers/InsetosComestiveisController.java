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
import br.com.fiap.GreenHeart.models.InsetosComestiveis;
import br.com.fiap.GreenHeart.repository.InsetosComestiveisRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/insetos")
@Slf4j
public class InsetosComestiveisController {

    @Autowired
    InsetosComestiveisRepository insetosComestiveisRepository; 
    
    @GetMapping
    public Page<InsetosComestiveis> index(Pageable pageable) {
        return insetosComestiveisRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<InsetosComestiveis>> create(
            @RequestBody @Valid InsetosComestiveis inseto,
            BindingResult result) {
        log.info("cadastrando informação: " + inseto);
        insetosComestiveisRepository.save(inseto);
        return ResponseEntity
            .created(inseto.toEntityModel().getRequiredLink("self").toUri())
            .body(inseto.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<InsetosComestiveis> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getInsetosComestiveis(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<InsetosComestiveis> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        insetosComestiveisRepository.delete(getInsetosComestiveis(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<InsetosComestiveis>> update(
            @PathVariable Long id,
            @RequestBody @Valid InsetosComestiveis inseto) {
        log.info("atualizando informação: " + id);
        getInsetosComestiveis(id);
        inseto.setId(id);
        insetosComestiveisRepository.save(inseto);
        return ResponseEntity.ok(inseto.toEntityModel());
    }

    private InsetosComestiveis getInsetosComestiveis(Long id) {
        return insetosComestiveisRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}
