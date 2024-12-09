package com.example.SpringSecurityEx1;

import org.springframework.stereotype.Service;



//Denna klass används ej i detta exempel
@Service
public class RoleService {

    private final RoleRepository roleRepository;


    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public  Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
