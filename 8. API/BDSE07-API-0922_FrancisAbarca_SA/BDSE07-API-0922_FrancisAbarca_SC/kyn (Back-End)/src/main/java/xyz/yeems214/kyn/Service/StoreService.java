package xyz.yeems214.kyn.Service;

import xyz.yeems214.kyn.Entity.Store;
import java.util.List;
import java.util.Optional;

public interface StoreService {

    List<Store> getAllStores();

    Optional<Store> getStoreById(Long id);

    Store createStore(Store store);

    Optional<Store> updateStore(Long id, Store store);

    boolean deleteStore(Long id);
}
