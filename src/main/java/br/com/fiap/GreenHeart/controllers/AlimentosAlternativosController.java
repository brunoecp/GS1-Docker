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
import br.com.fiap.GreenHeart.models.AlimentosAlternativos;
import br.com.fiap.GreenHeart.repository.AlimentosAlternativosRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/alimentosalt")
@Slf4j
public class AlimentosAlternativosController {

    @Autowired
    AlimentosAlternativosRepository alimentosAlternativosRepository; 

    @GetMapping
    public Page<AlimentosAlternativos> index(Pageable pageable) {
        return alimentosAlternativosRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<AlimentosAlternativos>> create(
            @RequestBody @Valid AlimentosAlternativos alimento,
            BindingResult result) {
        log.info("cadastrando informação: " + alimento);
        alimentosAlternativosRepository.save(alimento);
        return ResponseEntity
            .created(alimento.toEntityModel().getRequiredLink("self").toUri())
            .body(alimento.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<AlimentosAlternativos> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getAlimentosAlternativos(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<AlimentosAlternativos> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        alimentosAlternativosRepository.delete(getAlimentosAlternativos(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<AlimentosAlternativos>> update(
            @PathVariable Long id,
            @RequestBody @Valid AlimentosAlternativos alimento) {
        log.info("atualizando informação: " + id);
        getAlimentosAlternativos(id);
        alimento.setId(id);
        alimentosAlternativosRepository.save(alimento);
        return ResponseEntity.ok(alimento.toEntityModel());
    }

    private AlimentosAlternativos getAlimentosAlternativos(Long id) {
        return alimentosAlternativosRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}

