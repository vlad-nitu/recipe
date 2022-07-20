package vlad.springframework.recipe.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category category;

    @BeforeEach
    public void setup() {
    category = new Category();
    }

    @Test
    void getId() {
        Long id = 4L;
        category.setId(id);
        assertThat(category.getId()).isEqualTo(id);
    }

    @Test
    void getDescription() {
        String description = "Category description";
        category.setDescription(description);
        assertThat(category.getDescription()).isEqualTo(description);
    }


    @Test
    void getRecipes() {
        //TODO: to be implemented
    }
}