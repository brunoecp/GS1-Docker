package br.com.fiap.GreenHeart.models;

import org.springframework.hateoas.EntityModel;
import br.com.fiap.GreenHeart.controllers.PraticasAgricolasController;
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
@Table(name = "T_GH_PRATICAS_AGRICOLAS")
public class PraticasAgricolas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String metodosCultivo;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String tecnicasSolo;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String tecnicasIrrigacao;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String fertilizantes;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String tiposAgricultura;

    public EntityModel<PraticasAgricolas> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(PraticasAgricolasController.class).show(id)).withSelfRel(),
            linkTo(methodOn(PraticasAgricolasController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(PraticasAgricolasController.class).index(null)).withRel("all")
        );
    }

}
