package vlad.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
