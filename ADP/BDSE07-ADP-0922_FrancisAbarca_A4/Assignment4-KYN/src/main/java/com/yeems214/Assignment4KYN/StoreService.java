package com.yeems214.Assignment4KYN;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StoreService {
    @Autowired
    private StoreRepository storerepository;
    public void saveStore(Store store) {
        storerepository.save(store);
    }
    public List<Store> listAllStore(){
        return storerepository.findAll();
    }
    public Optional<Store> getStoreInfo(long sid){
        Optional<Store> store_info = storerepository.findById(sid);
        return store_info;
    }
    public void deleteStore(long sid) {
        storerepository.deleteById(sid);
    }

}
