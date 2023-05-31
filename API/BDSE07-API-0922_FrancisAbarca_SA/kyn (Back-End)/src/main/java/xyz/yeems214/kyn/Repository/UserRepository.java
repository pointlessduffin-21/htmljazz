package xyz.yeems214.kyn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.yeems214.kyn.Entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    User findByPassword(String password);
    User findByEmail(String email);
    User findByPhoneNumber(String phone);

    @Query("SELECT u FROM User u WHERE " +
            "u.userName LIKE %:key% OR " +
            "u.password LIKE %:key% OR " +
            "u.email LIKE %:key% OR " +
            "u.phoneNumber LIKE %:key%")
    List<User> search(@Param("key") String key);


    @Query(value = "SELECT * FROM User WHERE email = :email AND password = :password", nativeQuery = true)
    public User login(@Param("email") String email, @Param("password") String password);



    void deleteById(long id);


}