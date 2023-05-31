package xyz.yeems214.kyn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.yeems214.kyn.Entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserName(String username);
    Users findByPassword(String password);
    Users findByEmail(String email);
    Users findByPhoneNumber(String phone);

    @Query("SELECT u FROM Users u WHERE " +
            "u.userName LIKE %:key% OR " +
            "u.password LIKE %:key% OR " +
            "u.email LIKE %:key% OR " +
            "u.phoneNumber LIKE %:key%")
    List<Users> search(@Param("key") String key);


    @Query(value = "SELECT * FROM Users WHERE email = :email AND password = :password", nativeQuery = true)
    public Users login(@Param("email") String email, @Param("password") String password);



    void deleteById(long id);


}