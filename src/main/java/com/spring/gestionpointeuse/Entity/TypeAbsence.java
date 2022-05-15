package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.TAbsence;
import com.spring.gestionpointeuse.Ennum.TypeContabilisation;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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


}
