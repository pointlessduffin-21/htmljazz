package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yeems214.jumpstart.Repository.BranchRepository;
import xyz.yeems214.jumpstart.Repository.RoleRepository;
import xyz.yeems214.jumpstart.Repository.StockRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/all-branches")
    public String getAllBranches() {
        return branchRepository.findAll().toString();
    }

    @GetMapping("/all-stocks/{id}")
    public String getAllStocksByBranchId(Long id) {
        return stockRepository.findAll().toString();
    }

    @GetMapping("/all-roles")
    public String getAllRoles() {
        return roleRepository.findAll().toString();
    }

}
