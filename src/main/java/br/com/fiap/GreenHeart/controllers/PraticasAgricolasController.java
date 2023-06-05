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
import br.com.fiap.GreenHeart.models.PraticasAgricolas;
import br.com.fiap.GreenHeart.repository.PraticasAgricolasRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/praticas")
@Slf4j
public class PraticasAgricolasController {

    @Autowired
    PraticasAgricolasRepository praticasAgricolasRepository; 
    
    @GetMapping
    public Page<PraticasAgricolas> index(Pageable pageable) {
        return praticasAgricolasRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<PraticasAgricolas>> create(
            @RequestBody @Valid PraticasAgricolas pratica,
            BindingResult result) {
        log.info("cadastrando informação: " + pratica);
        praticasAgricolasRepository.save(pratica);
        return ResponseEntity
            .created(pratica.toEntityModel().getRequiredLink("self").toUri())
            .body(pratica.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<PraticasAgricolas> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getPraticasAgricolas(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<PraticasAgricolas> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        praticasAgricolasRepository.delete(getPraticasAgricolas(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<PraticasAgricolas>> update(
            @PathVariable Long id,
            @RequestBody @Valid PraticasAgricolas pratica) {
        log.info("atualizando informação: " + id);
        getPraticasAgricolas(id);
        pratica.setId(id);
        praticasAgricolasRepository.save(pratica);
        return ResponseEntity.ok(pratica.toEntityModel());
    }

    private PraticasAgricolas getPraticasAgricolas(Long id) {
        return praticasAgricolasRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}
