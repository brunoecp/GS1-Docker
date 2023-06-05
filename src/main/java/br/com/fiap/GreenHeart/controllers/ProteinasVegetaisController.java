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
import br.com.fiap.GreenHeart.models.ProteinasVegetais;
import br.com.fiap.GreenHeart.repository.ProteinasVegetaisRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/proteinas")
@Slf4j
public class ProteinasVegetaisController {

    @Autowired
    ProteinasVegetaisRepository proteinasVegetaisRepository; 
    
    @GetMapping
    public Page<ProteinasVegetais> index(Pageable pageable) {
        return proteinasVegetaisRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ProteinasVegetais>> create(
            @RequestBody @Valid ProteinasVegetais proteina,
            BindingResult result) {
        log.info("cadastrando informação: " + proteina);
        proteinasVegetaisRepository.save(proteina);
        return ResponseEntity
            .created(proteina.toEntityModel().getRequiredLink("self").toUri())
            .body(proteina.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<ProteinasVegetais> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getProteinasVegetais(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProteinasVegetais> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        proteinasVegetaisRepository.delete(getProteinasVegetais(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<ProteinasVegetais>> update(
            @PathVariable Long id,
            @RequestBody @Valid ProteinasVegetais proteina) {
        log.info("atualizando informação: " + id);
        getProteinasVegetais(id);
        proteina.setId(id);
        proteinasVegetaisRepository.save(proteina);
        return ResponseEntity.ok(proteina.toEntityModel());
    }

    private ProteinasVegetais getProteinasVegetais(Long id) {
        return proteinasVegetaisRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}
