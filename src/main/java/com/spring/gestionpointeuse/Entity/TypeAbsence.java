package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.TAbsence;
import com.spring.gestionpointeuse.Ennum.TypeContabilisation;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class TypeAbsence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeAbsence;

    private String couleur;
    private String designation;
    private TAbsence traiteAbsence;
    private TypeContabilisation typeContabilisation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCompany")
    @JsonIgnoreProperties({"typeAbsences"})
    private Company company;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTypeAbsence")
    @ApiModelProperty(hidden = true)
    @JsonIgnoreProperties({"typeAbsence"})
    private List<Absence> absences;


}
