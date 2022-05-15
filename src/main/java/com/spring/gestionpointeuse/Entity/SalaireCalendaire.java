package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.JourSemaine;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class SalaireCalendaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalaireCalendaire;


    private JourSemaine jourSemaine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfilCalendaire")
    @JsonIgnoreProperties({"salaireCalendaire"})
    private ProfilCalendaire profilCalendaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfilSalaire")
    @JsonIgnoreProperties({"salaireCalendaire"})
    private ProfilSalaire profilSalaire;

}
