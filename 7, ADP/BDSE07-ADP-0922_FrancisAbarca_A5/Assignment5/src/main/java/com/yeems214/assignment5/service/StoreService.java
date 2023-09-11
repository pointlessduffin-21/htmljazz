package com.yeems214.assignment5.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeems214.assignment5.entity.Store;
import com.yeems214.assignment5.exception.StoreNotFoundException;
import com.yeems214.assignment5.repository.StoreRepository;

@Service
@Transactional
public class StoreService {

    @Autowired
    private StoreRepository storerepository;

    public String saveStore(Store store) {
        storerepository.save(store);

        return "Store added successfully";
    }

    public List<Store> listAllStore(){

        List<Store> userResponse = storerepository.findAll();
        if(userResponse.isEmpty()) {
            throw new StoreNotFoundException("No store available at this moment");
        }

        return userResponse;
    }

    public Optional<Store> getStoreInfo(long sid){

        Optional<Store> store_info = storerepository.findById(sid);
        return store_info;
    }

    public void deleteStore(long sid) {
        storerepository.deleteById(sid);
    }

    public List<Store> searchStore(String email) {

        List<Store> userResponse = storerepository.findByEmail(email);
        if(userResponse.isEmpty()) {
            throw new StoreNotFoundException("No store found for " + email + " entered");
        }

        return userResponse;
    }

}
