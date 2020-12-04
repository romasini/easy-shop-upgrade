package ru.romasini.easy.shop.upgrade;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import ru.romasini.easy.shop.upgrade.entities.Category;
import ru.romasini.easy.shop.upgrade.entities.Product;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class JsonTests {

    @Autowired
    JacksonTester<Product> productJacksonTester;

    @Test
    public void jsonProductSerializationTest() throws IOException {
        Category category = new Category();
        category.setId(1l);
        category.setTitle("Category");

        Product product = new Product();
        product.setId(1l);
        product.setTitle("Product");
        product.setPrice(100);
        product.setCategory(category);

        assertThat(this.productJacksonTester.write(product)).hasJsonPathNumberValue("$.id");
        assertThat(this.productJacksonTester.write(product)).extractingJsonPathStringValue("$.title").isEqualTo("Product");
        assertThat(this.productJacksonTester.write(product)).hasJsonPathNumberValue("$.price");

    }

    @Test
    public void jsonProductDeserializationTest() throws IOException {
        String content = "{\"id\":1, \"title\":\"Product\", \"price\":100, \"category\":{\"id\":1, \"title\":\"Category\"}}";

        Category category = new Category();
        category.setId(1l);
        category.setTitle("Category");

        Product product = new Product();
        product.setId(1l);
        product.setTitle("Product");
        product.setPrice(100);
        product.setCategory(category);

        assertThat(this.productJacksonTester.parse(content)).isEqualTo(product);
        assertThat(this.productJacksonTester.parseObject(content).getTitle()).isEqualTo("Product");
    }

}
