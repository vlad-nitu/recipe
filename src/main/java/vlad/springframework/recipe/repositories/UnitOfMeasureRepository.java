package vlad.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vlad.springframework.recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
