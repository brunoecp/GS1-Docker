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
import br.com.fiap.GreenHeart.models.InfraestruturaRural;
import br.com.fiap.GreenHeart.repository.InfraestruturaRuralRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/infrarural")
@Slf4j
public class InfraestruturaRuralController {

    @Autowired
    InfraestruturaRuralRepository infraestruturaRuralRepository; 
    
    @GetMapping
    public Page<InfraestruturaRural> index(Pageable pageable) {
        return infraestruturaRuralRepository.findAll(pageable);
    }


    @PostMapping
    public ResponseEntity<EntityModel<InfraestruturaRural>> create(
            @RequestBody @Valid InfraestruturaRural infra,
            BindingResult result) {
        log.info("cadastrando informação: " + infra);
        infraestruturaRuralRepository.save(infra);
        return ResponseEntity
            .created(infra.toEntityModel().getRequiredLink("self").toUri())
            .body(infra.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<InfraestruturaRural> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getInfraestruturaRural(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<InfraestruturaRural> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        infraestruturaRuralRepository.delete(getInfraestruturaRural(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<InfraestruturaRural>> update(
            @PathVariable Long id,
            @RequestBody @Valid InfraestruturaRural infra) {
        log.info("atualizando informação: " + id);
        getInfraestruturaRural(id);
        infra.setId(id);
        infraestruturaRuralRepository.save(infra);
        return ResponseEntity.ok(infra.toEntityModel());
    }

    private InfraestruturaRural getInfraestruturaRural(Long id) {
        return infraestruturaRuralRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}
