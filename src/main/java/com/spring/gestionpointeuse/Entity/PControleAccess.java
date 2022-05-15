package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class PControleAccess implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPControleAccess;

    private String designation;
    private String autorisation;
    private int seuilRejet;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPControleAccess")
    @ApiModelProperty(hidden = true)
    @JsonIgnoreProperties({"pControleAccess"})
    private List<Usager> usagers = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Pointeuses_PControleAccess", joinColumns = {
            @JoinColumn(name = "idPointeuse") }, inverseJoinColumns = {
            @JoinColumn(name = "idPControleAccess") })
    @JsonIgnoreProperties({"pointeuses"})
    private Set<Pointeuse> pointeuses ;
}
