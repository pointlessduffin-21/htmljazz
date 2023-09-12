package xyz.yeems214.jumpstart.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String store;
    private long price;
    private String description;
    private String image_link;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String store, long price, String description, String image_link, Category category) {
        this.name = name;
        this.store = store;
        this.price = price;
        this.description = description;
        this.image_link = image_link;
        this.category = category;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setStore(String store) {
        this.store = store;
        return this;
    }

    public Product setPrice(long price) {
        this.price = price;
        return this;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product setImage_link(String image_link) {
        this.image_link = image_link;
        return this;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStore() {
        return store;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_link() {
        return image_link;
    }

    public Category getCategory() {
        return category;
    }

    // Getter and setter for reviews
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
