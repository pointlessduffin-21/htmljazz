package xyz.yeems214.jumpstart.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Stock {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;

    @ManyToOne
    @JoinColumn(name="productId", nullable=false)
    private Product product;

    @ManyToMany
    @JoinTable(
            name = "branch_stock",
            joinColumns = @JoinColumn(name = "stock_id"),
            inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    private Set<Branch> branches = new HashSet<>();
    private Long quantity_in_stock;

    public Stock() {
    }

public Stock(Product product, Long quantity_in_stock) {
        this.product = product;
        this.quantity_in_stock = quantity_in_stock;
    }

    public Stock setId(Long id) {
        this.id = id;
        return this;
    }

    public Stock setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Stock setQuantity_in_stock(Long quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
        return this;
    }

    public Stock setBranches(Set<Branch> branches) {
        this.branches = branches;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Long getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public Stock addBranch(Branch branch) {
        this.branches.add(branch);
        return this;
    }

    public Stock removeBranch(Branch branch) {
        this.branches.remove(branch);
        return this;
    }

    public Stock addQuantity(Long quantity) {
        this.quantity_in_stock += quantity;
        return this;
    }

    public Stock removeQuantity(Long quantity) {
        this.quantity_in_stock -= quantity;
        return this;
    }

    public Stock setQuantity(Long quantity) {
        this.quantity_in_stock = quantity;
        return this;
    }

    public Stock setBranches(Branch branch) {
        this.branches.add(branch);
        return this;
    }

    public Stock setBranches(Long branchId) {
        this.branches.add(new Branch().setId(branchId));
        return this;
    }

    public Stock setBranches(Long branchId, Long quantity) {
        this.branches.add(new Branch().setId(branchId));
        this.quantity_in_stock = quantity;
        return this;
    }

    
}
