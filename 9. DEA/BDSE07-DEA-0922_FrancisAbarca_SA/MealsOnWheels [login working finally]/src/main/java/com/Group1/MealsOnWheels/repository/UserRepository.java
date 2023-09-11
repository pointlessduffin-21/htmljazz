package com.Group1.MealsOnWheels.repository;

import com.Group1.MealsOnWheels.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUserName(String name);

    @Query(value="SELECT * FROM user WHERE user_name = :email AND password = :password",
            nativeQuery = true)
    public User loginUser(String email, String password);

    @Query(value="SELECT * FROM user WHERE email = :email",
            nativeQuery = true)
    public User findByEmail(String email);

    @Query(value="SELECT * FROM user WHERE address = :address",
            nativeQuery = true)
    public User findUserByAddress(String address);

    @Query(value="SELECT * FROM user WHERE name = :name",
            nativeQuery = true)
    public User findUserByName(String name);

    /*
     * @Query(value="SELECT * FROM user WHERE user.user_name = :userName",
     * nativeQuery = true)
     */


    @Query(value="SELECT role.name FROM user JOIN user_role ON user.id = user_role.user_id JOIN role ON user_role.role_id = role.role_id WHERE user.id = :uid",
            nativeQuery = true)
    public String findRoleByUid(Long uid);

    @Query(value="SELECT user_role.role_id FROM user JOIN user_role ON user.id = user_role.user_id WHERE user.id = :uid",
            nativeQuery = true)
    public String findRoleIdByUid(Long uid);

    @Query(value="SELECT * FROM user JOIN user_role ON user.id = user_role.user_id JOIN role ON user_role.role_id = role.id WHERE role.name = :role",
            nativeQuery = true)
    public List<User> findUsersByRole(String role);


}

