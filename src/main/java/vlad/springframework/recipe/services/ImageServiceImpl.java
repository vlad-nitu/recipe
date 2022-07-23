package vlad.springframework.recipe.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vlad.springframework.recipe.domain.Recipe;
import vlad.springframework.recipe.repositories.RecipeRepository;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int k = 0;
            for (byte b : file.getBytes()){
                byteObjects[k++] = b;
            }
            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);
            log.info("An image of " + byteObjects.length + " bytes was successfully saved.");

        } catch (IOException e) {
            //TODO: handle exception
            log.error("Error occurred", e);
        }
    }
}
