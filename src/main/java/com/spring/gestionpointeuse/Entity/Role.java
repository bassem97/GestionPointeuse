package com.spring.gestionpointeuse.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRole")
    @ApiModelProperty(hidden = true)
//    @JsonIgnoreProperties(value = {"produit"}, allowGetters = true)
    private List<Usager> usagers = new ArrayList<>();

    public Role(String role) {
        this.role = role;
    }
}
