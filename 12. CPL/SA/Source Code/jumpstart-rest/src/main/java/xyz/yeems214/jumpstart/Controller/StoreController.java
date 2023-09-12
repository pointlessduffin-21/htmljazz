package xyz.yeems214.jumpstart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.yeems214.jumpstart.Entity.Category;
import xyz.yeems214.jumpstart.Entity.Product;
import xyz.yeems214.jumpstart.Repository.CategoryRepository;
import xyz.yeems214.jumpstart.Repository.ProductRepository;
import xyz.yeems214.jumpstart.Entity.Review;
import xyz.yeems214.jumpstart.Repository.ReviewRepository;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    @Value("src/main/resources/images")
    private String uploadPath;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add-category")
    public ResponseEntity<Category> addCategory(@RequestParam("name") String name) {
        Category category = new Category();
        category.setName(name);
        Category savedCategory = categoryRepository.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestParam("name") String name, @RequestParam("store") String store, @RequestParam("price") long price, @RequestParam("description") String description, @RequestParam("category_id") Long categoryId, @RequestParam("image") MultipartFile image) {
        // Fetch the Category entity using the provided ID
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(name);
        product.setStore(store);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);

        try {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());
            Path path = Paths.get(uploadPath + File.separator + fileName);
            Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            product.setImage_link(fileName);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Product Deleted with ID: " + id;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> viewProductByName(@RequestParam String name) {
        List<Product> products = productRepository.findByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/review/{id}")
    @Transactional
    public ResponseEntity<Product> addReview(@PathVariable Long id, @RequestParam("title") String title, @RequestParam("body") String body, @RequestParam("rating") Long rating, @RequestParam("image") MultipartFile image) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        Review review = new Review();
        review.setTitle(title);
        review.setBody(body);
        review.setRating(rating);
        review.setProduct(product);

        try {
            String fileName = StringUtils.cleanPath(image.getOriginalFilename());
            Path path = Paths.get(uploadPath + File.separator + fileName);
            Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            review.setImage_link(fileName);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        reviewRepository.save(review);

        product.getReviews().add(review);

        Product savedProduct = productRepository.save(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
