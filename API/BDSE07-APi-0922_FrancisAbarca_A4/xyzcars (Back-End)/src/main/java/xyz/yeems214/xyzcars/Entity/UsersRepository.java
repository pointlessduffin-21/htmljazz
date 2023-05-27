package xyz.yeems214.xyzcars.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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