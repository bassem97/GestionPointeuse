package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.TraitementRtt;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProfilSalaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfilSalaire;

    private String designation;

    private Time horraireSoir;
    private Time horraireMatin;

    private Date jourDebutAnnee;
    private TraitementRtt traitementRtt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProfilSalaire")
    @ApiModelProperty(hidden = true)
    @JsonIgnoreProperties({"profilCalendaire"})
    private List<SalaireCalendaire> salaireCalendaires = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCompany")
    @JsonIgnoreProperties({"profilSalaires"})
    private Company company;
}
