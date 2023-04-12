package com.shoptee.shoptee;

import com.shoptee.shoptee.entity.Category;
import com.shoptee.shoptee.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreatCategory(){
        Category category = new Category();
        category.setName("Điện thoại");
        Category saveCategory = categoryRepository.save(category);
        assertThat(saveCategory.getId()).isGreaterThan(0);
    }
}
