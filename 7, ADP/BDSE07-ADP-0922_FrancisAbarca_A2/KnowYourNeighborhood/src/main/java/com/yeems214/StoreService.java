package com.yeems214;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	
	@Autowired
	private StoreDAO storedao;
	
	public Store saveStore(Store store) {
		return storedao.saveStore(store);
	}
	
	public List<Store> listAllStore(){
		return storedao.listAllStore();
	}

}
