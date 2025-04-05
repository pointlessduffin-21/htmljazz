package xyz.yeems214.jumpstart.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany
    private List<Product> products;
    private Long quantity;
    private Long total_price;

    public Order() {
    }

    public Order(User user, List<Product> products, Long quantity, Long total_price) {
        this.user = user;
        this.products = products;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public Order setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Order setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public Order setTotal_price(Long total_price) {
        this.total_price = total_price;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getTotal_price() {
        return total_price;
    }

}