package com.spring.gestionpointeuse.Service.Usager;

import com.spring.gestionpointeuse.Entity.MyUserDetails;
import com.spring.gestionpointeuse.Repository.UsagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceDetails implements UserDetailsService {
    @Autowired
    UsagerRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        log.info("LL STRING "+ s);
//        log.info("LL STRING "+ userRepository.findByEmail(s));
        return new MyUserDetails(userRepository.findByEmail(s));
    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}