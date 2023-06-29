package xyz.yeems214.kyn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xyz.yeems214.kyn.Entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByName(String name);
    Store findByAddress(String address);
    Store findByCity(String city);
    Store findByState(String state);
    Store findByZip(String zip);
    Store findByPhone(String phone);

    void deleteById(long id);
}