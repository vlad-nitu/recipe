package vlad.springframework.recipe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import vlad.springframework.recipe.domain.Recipe;
import vlad.springframework.recipe.services.RecipeService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {
    @Mock
    private RecipeService recipeService;
    private MockMvc mockMvc;
    private Recipe recipe;
    private RecipeController controller;

    @BeforeEach
    void setUp(){
        controller = new RecipeController(recipeService);
        recipe = new Recipe();
        recipe.setId(1L);
    }
    @Test
    void showByIdTest() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(recipeService.findById(any(Long.class))).thenReturn(recipe);

        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));

    }
}
