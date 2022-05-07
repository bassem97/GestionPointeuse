package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Details implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetails;

    private String adresse;
    private String webstite;
    private String github;
    private String linkedin;
    private String mobile;
    private String phone;
    private String profession;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsager", nullable = false)
    @JsonIgnore
    private Usager usager;

    public Details(Usager usager,String adresse, String webstite, String github, String linkedin, String mobile, String phone, String profession) {
        this.usager = usager;
        this.adresse = adresse;
        this.webstite = webstite;
        this.github = github;
        this.linkedin = linkedin;
        this.mobile = mobile;
        this.phone = phone;
        this.profession = profession;
    }
}
