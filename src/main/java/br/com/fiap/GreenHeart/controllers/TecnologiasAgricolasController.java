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
import br.com.fiap.GreenHeart.models.TecnologiasAgricolas;
import br.com.fiap.GreenHeart.repository.TecnologiasAgricolasRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/tecnologias")
@Slf4j
public class TecnologiasAgricolasController {

    @Autowired
    TecnologiasAgricolasRepository tecnologiasAgricolasRepository; 

    @GetMapping
    public Page<TecnologiasAgricolas> index(Pageable pageable) {
        return tecnologiasAgricolasRepository.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<TecnologiasAgricolas>> create(
            @RequestBody @Valid TecnologiasAgricolas tecnologia,
            BindingResult result) {
        log.info("cadastrando informação: " + tecnologia);
        tecnologiasAgricolasRepository.save(tecnologia);
        return ResponseEntity
            .created(tecnologia.toEntityModel().getRequiredLink("self").toUri())
            .body(tecnologia.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<TecnologiasAgricolas> show(@PathVariable Long id) {
        log.info("buscando informação: " + id);
        return getTecnologiasAgricolas(id).toEntityModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<TecnologiasAgricolas> destroy(@PathVariable Long id){
        log.info("apagando informação: " + id);
        tecnologiasAgricolasRepository.delete(getTecnologiasAgricolas(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EntityModel<TecnologiasAgricolas>> update(
            @PathVariable Long id,
            @RequestBody @Valid TecnologiasAgricolas tecnologia) {
        log.info("atualizando informação: " + id);
        getTecnologiasAgricolas(id);
        tecnologia.setId(id);
        tecnologiasAgricolasRepository.save(tecnologia);
        return ResponseEntity.ok(tecnologia.toEntityModel());
    }

    private TecnologiasAgricolas getTecnologiasAgricolas(Long id) {
        return tecnologiasAgricolasRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("informação não encontrada"));
    }
}
