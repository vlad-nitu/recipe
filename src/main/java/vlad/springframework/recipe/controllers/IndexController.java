package vlad.springframework.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vlad.springframework.recipe.domain.Category;
import vlad.springframework.recipe.domain.UnitOfMeasure;
import vlad.springframework.recipe.repositories.CategoryRepository;
import vlad.springframework.recipe.repositories.UnitOfMeasureRepository;
import vlad.springframework.recipe.services.RecipeService;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
       model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
