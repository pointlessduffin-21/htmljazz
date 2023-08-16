package com.Group1.MealsOnWheels.repository;


import com.Group1.MealsOnWheels.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    @Query( "select r from Role r where r.name in :roles" )
    Set<Role> findBySpecificRoles(@Param("roles") String role);

    @Query( "select r from Role r where r.id in :RId" )
    Role findByRId(@Param("RId") Long rId);

    @Query( "select r.name from Role r where r.id in :RId" )
    String findRoleByRId(@Param("RId") Long rId);
}