package com.spring.gestionpointeuse.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Fonction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFonction;

    private String designation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFonction")
    @ApiModelProperty(hidden = true)
//    @JsonIgnoreProperties(value = {"produit"}, allowGetters = true)
    private List<Fonctionalitie> fonctionalities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCompany")
//    @JsonIgnoreProperties({"services"})
    private Company company;


}
