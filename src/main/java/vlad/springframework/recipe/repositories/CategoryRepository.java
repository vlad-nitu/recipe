package vlad.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.recipe.domain.Category;
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
