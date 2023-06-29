package xyz.yeems214.xyzcars.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE " +
            "c.make LIKE %:key% OR " +
            "c.model LIKE %:key% OR " +
            "c.registration LIKE %:key% OR " +
            "c.price LIKE %:key%")
    public List<Car> search(@Param("key") String key);

    @Query(value = "SELECT c FROM Car c WHERE c.price BETWEEN :min AND :max")
    public List<Car> searchByPrice(@Param("min") String min, @Param("max") String max);

    void deleteById(Integer id);
}