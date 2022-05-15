package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.TypePause;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Pause implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPause;

    private String designation;
    private int  temps_obligatoire;
    private int  temps_remunerer;
    private TypePause typePause;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfilCalendaire")
    @JsonIgnoreProperties({"pauses"})
    private ProfilCalendaire profilCalendaire;


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idPause")
//    @ApiModelProperty(hidden = true)
//    @JsonIgnoreProperties({"pause"})
//    private List<Usager> usagers = new ArrayList<>();


    public Pause(String designation, int temps_obligatoire, int temps_remunerer, TypePause typePause) {
        this.designation = designation;
        this.temps_obligatoire = temps_obligatoire;
        this.temps_remunerer = temps_remunerer;
        this.typePause = typePause;
    }
}
