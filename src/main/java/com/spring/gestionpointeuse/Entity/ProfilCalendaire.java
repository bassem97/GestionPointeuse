package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class ProfilCalendaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfilCalendaire;
    private String designation;

    private Time couvrant;
    private Time definition;
    private Time enrcetee;
    private boolean usePointeuse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCompany")
    @JsonIgnoreProperties({"profilCalendaire"})
    private Company company;


    public ProfilCalendaire(String designation, Time couvrant, Time definition, Time enrcetee, boolean usePointeuse, Company company) {
        this.designation = designation;
        this.couvrant = couvrant;
        this.definition = definition;
        this.enrcetee = enrcetee;
        this.usePointeuse = usePointeuse;
        this.company = company;
    }


}
