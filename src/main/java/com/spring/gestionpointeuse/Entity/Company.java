package com.spring.gestionpointeuse.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;

    private String designation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCompany")
    @ApiModelProperty(hidden = true)
//    @JsonIgnoreProperties(value = {"produit"}, allowGetters = true)
    private List<Usager> usagers = new ArrayList<>();

    public Company(String designation) {
        this.designation = designation;
    }
}
