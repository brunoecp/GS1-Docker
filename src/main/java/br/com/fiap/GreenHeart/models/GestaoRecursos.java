package br.com.fiap.GreenHeart.models;

import org.springframework.hateoas.EntityModel;
import br.com.fiap.GreenHeart.controllers.GestaoRecursosController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "T_GH_GESTAO_RECURSOS")
public class GestaoRecursos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String importanciaGestao;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String praticasConservacao;

    public EntityModel<GestaoRecursos> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(GestaoRecursosController.class).show(id)).withSelfRel(),
            linkTo(methodOn(GestaoRecursosController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(GestaoRecursosController.class).index(null)).withRel("all")
        );
    }

}