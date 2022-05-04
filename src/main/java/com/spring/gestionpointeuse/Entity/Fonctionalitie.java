package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Fonctionalitie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFonctionalities;

    private Boolean lecture ;
    private Boolean ajout ;
    private Boolean modification ;
    private Boolean suppression ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsager")
//    @JsonIgnoreProperties({"services"})
    private Usager usager;

    public Fonctionalitie(Boolean lecture, Boolean ajout, Boolean modif, Boolean supprime) {
        this.lecture = lecture;
        this.ajout = ajout;
        this.modification = modif;
        this.suppression = supprime;
    }
}
