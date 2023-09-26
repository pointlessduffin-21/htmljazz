package com.Group1.MealsOnWheels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.MealsOnWheels.Entity.Role;
import com.Group1.MealsOnWheels.Entity.User;
import com.Group1.MealsOnWheels.repository.RoleRepository;
import com.Group1.MealsOnWheels.repository.UserRepository;

@Service
@Transactional
public class RoleService {


    @Autowired
    public RoleRepository roleRepo;

    public Role findByRId(Long RId) {
        return roleRepo.findByRId(RId);
    }

    public String findRoleByRId(Long RId) {
        return roleRepo.findRoleByRId(RId);
    }


}
