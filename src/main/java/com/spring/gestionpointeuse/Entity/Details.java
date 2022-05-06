package com.spring.gestionpointeuse.Entity;

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
    private Usager usager;







}
