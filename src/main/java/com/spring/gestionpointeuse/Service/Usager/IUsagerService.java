package com.spring.gestionpointeuse.Service.Usager;

import com.spring.gestionpointeuse.Entity.Usager;

public interface IUsagerService {
    Usager findByEmail(String email);
}
