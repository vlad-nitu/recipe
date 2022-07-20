package vlad.springframework.recipe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import vlad.springframework.recipe.domain.Recipe;
import vlad.springframework.recipe.services.RecipeService;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

    private IndexController indexController;
    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = Set.of(recipe);
        when(recipeService.getRecipes()).thenReturn(recipesData);
        String viewPage = indexController.getIndexPage(model); //Call method under test
        assertThat(viewPage).isEqualTo("index");
        verify(model).addAttribute("recipes", recipesData);
    }
}