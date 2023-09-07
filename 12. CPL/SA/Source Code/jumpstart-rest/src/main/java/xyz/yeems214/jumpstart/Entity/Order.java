package xyz.yeems214.jumpstart.Entity;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @OneToMany
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private Long quantity;
    private Long total_price;
    
    public Order() {
    }

    public Order(User user, Product product, Long quantity, Long total_price) {
        this.user = user;
        this.product = product;
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

    public Order setProduct(Product product) {
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                ", total_price=" + total_price +
                '}';
    }
}
