package br.com.fiap.GreenHeart.models;

import org.springframework.hateoas.EntityModel;
import br.com.fiap.GreenHeart.controllers.TecnologiasAgricolasController;
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
@Table(name = "T_GH_TEC_AGRICOLAS")
public class TecnologiasAgricolas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String equipamentos;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String monitoramento;

    public EntityModel<TecnologiasAgricolas> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(TecnologiasAgricolasController.class).show(id)).withSelfRel(),
            linkTo(methodOn(TecnologiasAgricolasController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(TecnologiasAgricolasController.class).index(null)).withRel("all")
        );
    }

}
