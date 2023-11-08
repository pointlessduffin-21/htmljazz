package com.yeems214.assignment5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.yeems214.assignment5.entity.Store;
import com.yeems214.assignment5.repository.StoreRepository;


@RunWith(MockitoJUnitRunner.class)
public class StoreServiceTest {

    @InjectMocks
    StoreService storeService;

    @Mock
    StoreRepository storeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveStore() {
        Store store = new Store();
        store.setId((long) 1);
        store.setName("test_store");
        store.setPhone_number("01232411");
        store.setLocalities("KL");
        Mockito.when(storeRepository.save(store)).thenReturn(store);
        String storeResponse = storeService.saveStore(store);
        Assert.assertEquals("Store added successfully", storeResponse);
    }

    @Test
    public void testGetStoreByEmail() {
        Store store = new Store();
        store.setId((long) 1);
        store.setName("test_store");
        store.setPhone_number("01232411");
        store.setLocalities("KL");
        store.setEmail("test@gmail.com");
        List<Store> search_store = new ArrayList<Store>();
        search_store.add(store);

        Mockito.when(storeRepository.findByEmail(store.getEmail())).thenReturn(search_store);

        List<Store> storeResponse = storeService.searchStore(store.getEmail());
        Assert.assertEquals(store.getName(), storeResponse.stream().findAny().get().getName());
    }

}
