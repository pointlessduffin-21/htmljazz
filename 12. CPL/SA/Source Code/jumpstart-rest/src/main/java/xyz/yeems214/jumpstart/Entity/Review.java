package xyz.yeems214.jumpstart.Entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String body;
    private Long rating;
    private String image_link;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Review() {
    }

    public Review(String title, String body, Long rating, String image_link, Product product) {
        this.title = title;
        this.body = body;
        this.rating = rating;
        this.image_link = image_link;
        this.product = product;
    }

    public Review setId(Long id) {
        this.id = id;
        return this;
    }

    public Review setTitle(String title) {
        this.title = title;
        return this;
    }

    public Review setBody(String body) {
        this.body = body;
        return this;
    }

    public Review setRating(Long rating) {
        this.rating = rating;
        return this;
    }

    public Review setImage_link(String image_link) {
        this.image_link = image_link;
        return this;
    }

    public Review setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Long getRating() {
        return rating;
    }

    public String getImage_link() {
        return image_link;
    }

    public Product getProduct() {
        return product;
    }
}
