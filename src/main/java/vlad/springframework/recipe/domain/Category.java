package vlad.springframework.recipe.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "categories")
    @EqualsAndHashCode.Exclude
    private Set<Recipe> recipes;

}
