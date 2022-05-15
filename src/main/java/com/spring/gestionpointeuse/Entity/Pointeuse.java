package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.TypeHandKey;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Pointeuse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPointeuse;

    private String designation;
    private String adresseIp;
    private TypeHandKey type;
    private Long port;
    private boolean etat;
    private boolean connexion;
    private boolean principale;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Pointeuses_PControleAccess", joinColumns = {
            @JoinColumn(name = "idPointeuse") }, inverseJoinColumns = {
            @JoinColumn(name = "idPControleAccess") })
    @JsonIgnoreProperties({"pointeuses"})
    private Set<PControleAccess> pControleAccesses ;


}
