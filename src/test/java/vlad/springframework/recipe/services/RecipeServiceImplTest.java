package vlad.springframework.recipe.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vlad.springframework.recipe.converters.RecipeCommandToRecipe;
import vlad.springframework.recipe.converters.RecipeToRecipeCommand;
import vlad.springframework.recipe.domain.Recipe;
import vlad.springframework.recipe.exceptions.NotFoundException;
import vlad.springframework.recipe.repositories.RecipeRepository;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    private RecipeServiceImpl recipeService;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    void setUp() {
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(any(Long.class))).thenReturn(optionalRecipe);

        Recipe recipeReturned = recipeService.findById(1L);
        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository).findById(any(Long.class));
        verify(recipeRepository, never()).findAll();
    }
    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = Set.of(recipe);
        when(recipeRepository.findAll()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertThat(recipes).hasSize(1);
        verify(recipeRepository).findAll();
    }
    @Test
    void getRecipeByIdNotFound() {
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThatExceptionOfType(NotFoundException.class).isThrownBy(() -> recipeService.findById(1L));
    }
}