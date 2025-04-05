package xyz.yeems214.kyn.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import xyz.yeems214.kyn.Entity.Store;
import xyz.yeems214.kyn.Repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    @Transactional
    public Optional<Store> updateStore(Long id, Store store) {
        return storeRepository.findById(id)
                .map(existingStore -> {
                    existingStore.setName(store.getName());
                    existingStore.setAddress(store.getAddress());
                    existingStore.setCity(store.getCity());
                    existingStore.setState(store.getState());
                    existingStore.setZip(store.getZip());
                    existingStore.setPhone(store.getPhone());
                    return storeRepository.save(existingStore);
                });
    }

    @Override
    public boolean deleteStore(Long id) {
        if(storeRepository.existsById(id)) {
            storeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
