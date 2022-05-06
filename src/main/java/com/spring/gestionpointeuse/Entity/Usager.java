package com.spring.gestionpointeuse.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
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

    private Sexe sexe;
    private Date dateNaissance;
    private Date dateInscrit;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsager")
    @ApiModelProperty(hidden = true)
//    @JsonIgnoreProperties(value = {"produit"}, allowGetters = true)
    private List<Fonctionalitie> fonctionalities;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRole")
//    @JsonIgnoreProperties({"services"})
    private Role role;

    public Usager() {
        dateNaissance = new Date();
    }
}
