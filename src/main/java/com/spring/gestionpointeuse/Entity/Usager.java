package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.SEXE;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Usager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsager;

    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String password;
    private String proffession;
    private String empreinte;
    private String badge;
    private String numero;
    private SEXE sexe;


    private LocalDate dateNaissance;

    private Date dateInscrit;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsager")
    @ApiModelProperty(hidden = true)
    @JsonIgnoreProperties({"usager"})
    private List<Fonctionalitie> fonctionalities;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsager")
    @ApiModelProperty(hidden = true)
    @JsonIgnoreProperties({"usager"})
    private List<Evenement> evenements;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "usager")
    private Details details;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRole")
    @JsonIgnoreProperties({"usagers"})
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCompany")
    @JsonIgnoreProperties({"usagers"})
    private Company company;

    public Usager() {
        fonctionalities = new ArrayList<>();
        dateInscrit = new Date();
    }

    public Usager(String nom, String prenom, String username, String email, String password, SEXE sexe, LocalDate  dateNaissance, Role role, Company company) {
        fonctionalities = new ArrayList<>();
        dateInscrit = new Date();
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.company = company;
    }
}
