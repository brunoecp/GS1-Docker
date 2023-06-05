package br.com.fiap.GreenHeart.models;

import org.springframework.hateoas.EntityModel;
import br.com.fiap.GreenHeart.controllers.InfraestruturaRuralController;
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
@Table(name = "T_GH_INFRA_RURAL")
public class InfraestruturaRural {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String infraAdequada;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String planejamentoRotas;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String controleTemperatura;

    @NotBlank @Size(min = 5, max = 3000, message = "deve ser uma descrição significativa")
    private String embalagensAdequadas;

    @NotBlank @Size(min = 5, max = 2000, message = "deve ser uma descrição significativa")
    private String controleQualidade;

    public EntityModel<InfraestruturaRural> toEntityModel() {
        return EntityModel.of(
            this, 
            linkTo(methodOn(InfraestruturaRuralController.class).show(id)).withSelfRel(),
            linkTo(methodOn(InfraestruturaRuralController.class).destroy(id)).withRel("delete"),
            linkTo(methodOn(InfraestruturaRuralController.class).index(null)).withRel("all")
        );
    }

}
