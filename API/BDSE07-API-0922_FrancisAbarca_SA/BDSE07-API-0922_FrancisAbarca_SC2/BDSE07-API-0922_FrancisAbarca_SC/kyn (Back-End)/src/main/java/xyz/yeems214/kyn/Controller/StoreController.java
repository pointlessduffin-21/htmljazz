package xyz.yeems214.kyn.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.yeems214.kyn.Entity.Store;
import xyz.yeems214.kyn.Service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/getAllStores")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/getStore/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id)
                .map(store -> ResponseEntity.ok().body(store))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/addStore")
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @PutMapping("/updateStore/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store store) {
        return storeService.updateStore(id, store)
                .map(updatedStore -> ResponseEntity.ok().body(updatedStore))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteStore/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable Long id) {
        return storeService.deleteStore(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
