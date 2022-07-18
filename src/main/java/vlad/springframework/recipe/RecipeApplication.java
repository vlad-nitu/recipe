package vlad.springframework.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RecipeApplication {

    public static void main(String[] args) {
        ApplicationContext cxt = SpringApplication.run(RecipeApplication.class, args);
    }

}
