package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Absence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;

    private String designation;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsager")
    @JsonIgnoreProperties({"absence"})
    private Usager usager;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypeAbsence")
    @JsonIgnoreProperties({"absence"})
    private TypeAbsence typeAbsence;
}
