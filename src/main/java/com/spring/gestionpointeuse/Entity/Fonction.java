package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"fonction"})
    private List<Fonctionalitie> fonctionalities = new ArrayList<>();


    public Fonction(String designation) {
        this.designation = designation;
    }
}
