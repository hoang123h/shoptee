package com.shoptee.shoptee;

import com.shoptee.shoptee.entity.Category;
import com.shoptee.shoptee.entity.Product;
import com.shoptee.shoptee.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreatProduct() {
        Category category = testEntityManager.find(Category.class, 7);
        Product product = new Product();
        product.setAvailable(true);
        product.setCreateDate(new Date());
        product.setImage("jp5.jpg");
        product.setName("Iphone5");
        product.setPrice(5.000);
        product.setCategory(category);
        Product saveProduct = productRepository.save(product);
        assertThat(saveProduct).isNotNull();
        assertThat(saveProduct.getId()).isGreaterThan(0);
    }
}
