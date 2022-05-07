package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;

    private String designation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCompany")
    @ApiModelProperty(hidden = true)
    @JsonIgnoreProperties({"company"})
    private List<Usager> usagers = new ArrayList<>();

    public Company(String designation) {
        this.designation = designation;
    }
}
