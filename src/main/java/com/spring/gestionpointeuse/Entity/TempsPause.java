package com.spring.gestionpointeuse.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.gestionpointeuse.Ennum.TypePause;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class TempsPause implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTempsPause;

    private Time dateDebut;
    private Time dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPause")
    @JsonIgnoreProperties({"tempsPauses"})
    private Pause pause;

}
