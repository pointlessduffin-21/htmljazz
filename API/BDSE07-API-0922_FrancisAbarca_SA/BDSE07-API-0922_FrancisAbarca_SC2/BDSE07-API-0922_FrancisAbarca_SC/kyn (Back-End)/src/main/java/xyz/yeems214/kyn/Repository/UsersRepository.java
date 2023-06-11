package xyz.yeems214.kyn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.yeems214.kyn.Entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserName(String userName);

    @Query("SELECT u FROM Users u WHERE " +
            "u.firstName LIKE %:key% OR " +
            "u.lastName LIKE %:key% OR " +
            "u.address LIKE %:key% OR " +
            "u.userName LIKE %:key% OR " +
            "u.userEmail LIKE %:key% OR " +
            "u.phoneNumber LIKE %:key%")
    List<Users> search(@Param("key") String key);

    void deleteById(Integer id);
}