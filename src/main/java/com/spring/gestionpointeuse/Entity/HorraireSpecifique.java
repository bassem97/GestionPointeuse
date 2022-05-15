package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.Traitement_Erreur;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class HorraireSpecifique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorraireSpecifique;

    private Time horaireSpec;
    private Time definition;
    private int montant;
    private Time reprisePointage;

    private Traitement_Erreur traitement;

    private boolean typeHoraire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfilCalendaire")
    @JsonIgnoreProperties({"horraireSpecifiques"})
    private ProfilCalendaire profilCalendaire;

    public HorraireSpecifique(Time horaireSpec, Time definition, int montant, Time reprisePointage, Traitement_Erreur traitement, boolean typeHoraire) {
        this.horaireSpec = horaireSpec;
        this.definition = definition;
        this.montant = montant;
        this.reprisePointage = reprisePointage;
        this.traitement = traitement;
        this.typeHoraire = typeHoraire;
    }
}
