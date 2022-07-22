package vlad.springframework.recipe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vlad.springframework.recipe.domain.Recipe;
import vlad.springframework.recipe.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements  RecipeService{
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in RecipeServiceImpl");
        Set<Recipe> recipeSet = new HashSet<>();
       recipeRepository.findAll().forEach(recipe -> recipeSet.add(recipe));
       return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent())
            return optionalRecipe.get();
        else throw new RuntimeException("Recipe not found!");
    }
}
