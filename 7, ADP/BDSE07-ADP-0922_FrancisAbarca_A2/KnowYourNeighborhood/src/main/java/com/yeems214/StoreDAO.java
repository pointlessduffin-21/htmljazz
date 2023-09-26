package com.yeems214;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO {
	
	List<Store> stores = new ArrayList<Store>();
	
	public Store saveStore (Store store) {
		stores.add(store);
		return store;
	}
	
	public List<Store> listAllStore(){
		return stores;
	}

}
