package br.com.fiap.GreenHeart.models;

import org.springframework.hateoas.EntityModel;
import br.com.fiap.GreenHeart.controllers.VariedadesController;
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
@Table(name = "T_GH_VARIEDADES")
public class Variedades {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String desenvolvimento;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String culturasClima;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String importanciaCulturas;

    public EntityModel<Variedades> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(VariedadesController.class).show(id)).withSelfRel(),
            linkTo(methodOn(VariedadesController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(VariedadesController.class).index(null)).withRel("all")
        );
    }

}

