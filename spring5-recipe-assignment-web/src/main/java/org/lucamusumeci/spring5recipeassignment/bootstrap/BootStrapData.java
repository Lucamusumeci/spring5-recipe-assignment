package org.lucamusumeci.spring5recipeassignment.bootstrap;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.lucamusumeci.spring5recipeassignment.domain.*;
import org.lucamusumeci.spring5recipeassignment.repositories.CategoryRepository;
import org.lucamusumeci.spring5recipeassignment.repositories.IngredientRepository;
import org.lucamusumeci.spring5recipeassignment.repositories.RecipeRepository;
import org.lucamusumeci.spring5recipeassignment.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Slf4j
@Component
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    //@Autowired
    public BootStrapData(RecipeRepository recipeRepository, CategoryRepository categoryRepository, IngredientRepository ingredientRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(this.getClass().getName() + " started");

        Optional<UnitOfMeasure> cupUnitOfMeasure = unitOfMeasureRepository.findByName("cup");
        Optional<UnitOfMeasure> gramUnitOfMeasure = unitOfMeasureRepository.findByName("gram");
        Optional<UnitOfMeasure> teaspoonUnitOfMeasure = unitOfMeasureRepository.findByName("teaspoon");
        Optional<Category> sweetCategory = categoryRepository.findByName("Sweet");

        Ingredient mascarponeIngredient = new Ingredient();
        mascarponeIngredient.setName("Mascarpone Cheese");
        if(cupUnitOfMeasure.isPresent()){
            mascarponeIngredient.setAmount(1L);
            mascarponeIngredient.setUnitOfMeasure(cupUnitOfMeasure.get());
        } else if (gramUnitOfMeasure.isPresent()){
            mascarponeIngredient.setAmount(250L);
            mascarponeIngredient.setUnitOfMeasure(gramUnitOfMeasure.get());
        }
        mascarponeIngredient = ingredientRepository.save(mascarponeIngredient);

        Ingredient eggIngredient = new Ingredient();
        eggIngredient.setName("egg");
        eggIngredient.setAmount(2L);
        eggIngredient = ingredientRepository.save(eggIngredient);

        Ingredient vanillaExtractIngredient = new Ingredient();
        vanillaExtractIngredient.setName("Vanilla extract");
        if(teaspoonUnitOfMeasure.isPresent()){
            vanillaExtractIngredient.setAmount(1L);
            vanillaExtractIngredient.setUnitOfMeasure(teaspoonUnitOfMeasure.get());
        }
        vanillaExtractIngredient = ingredientRepository.save(vanillaExtractIngredient);

        Recipe pandoroTiramisuRecipe = new Recipe();
        pandoroTiramisuRecipe.setName("Pandoro Tiramisù");
        pandoroTiramisuRecipe.setCost(Cost.MODERATE);
        pandoroTiramisuRecipe.setPreparationTime(20);
        pandoroTiramisuRecipe.setDifficulty(Difficulty.MODERATE);
        pandoroTiramisuRecipe.setServings(4);

        pandoroTiramisuRecipe.addIngredient(mascarponeIngredient);
        pandoroTiramisuRecipe.addIngredient(eggIngredient);
        pandoroTiramisuRecipe.addIngredient(vanillaExtractIngredient);

        if(sweetCategory.isPresent()){
            pandoroTiramisuRecipe.getCategories().add(sweetCategory.get());
        } else {
            log.info("Category Sweet is not present");
        }
        pandoroTiramisuRecipe.setInstructions(
                "To prepare pandoro tiramisù, start by brewing the coffee and leaving it to cool. Separate the eggs, place the yolks in one bowl and the whites in another. Add 0.25 cup of sugar and the vanilla extract 2, then beat with an electric whisk for around 3 minutes 3\n" +
                        "to obtain a light-colored and frothy mixture 4. Gradually add the mascarpone cheese 5 and stir it in using the electric whisk 6. \n" +
                        "Continue in this way to obtain a thick and compact cream 7. Leave to one side and prepare the egg whites. Add the remaining 0.25 cup of sugar 8 and stir with the thoroughly washed and dried electric whisk 9. \n" +
                        "Beat the whites until stiff 10. Now gradually add the whites to the mascarpone cream 11 and delicately stir from the top using a downward motion, to avoid deflating them 12. \n" +
                        "Continue in this way to obtain a thick cream 13. Now cut the pandoro into roughly 0.4 inch thick slices 14. Then cut into 8 discs using a shaping ring mold 15. We used a 2.8 inch one, you can decide according to the size of the glass you wish to use. \n" +
                        "Dice any left over pandoro 16. Serve as the decoration. The coffee will have cooled to lukewarm by now: add the rum 17 and a teaspoon of sugar 18. Stir to melt.\n" +
                        "Now take your glass and start by adding a thin layer of cream 19. Top with a pandoro disc 20 and add a couple of teaspoons of the coffee 21. \n" +
                        "Continue with another layer of cream 22, add another pandoro disc, then soak with the coffee once more 23. Fill the glass to the brim by adding one last layer of cream 24.\n" +
                        "Top with the diced pandoro 25, sprinkle with the cocoa powder 26 and serve your pandoro tiramisù 27. ");
        pandoroTiramisuRecipe.setDescription("Do you hear the bells on Santa's sleigh too? Let's prepare some pandoro tiramisù together, a dessert that is easy to make, perfect for the festive season! A creamy and delicious alternative to classic tiramisù. Classic lady fingers are replaced by pandoro discs, the mascarpone cream remains unchanged and the coffee soak is flavored with a touch of rum. Dice any remaining pandoro and use it to decorate your dessert, making it even more enticing and waste-free. This year each guest will have their own portion, but if you prefer you can make this tiramisù in a tray! Pandoro tiramisù is also a great way for using any leftover slices once the holidays are over!\n" +
                "If you are looking for other ways to use pandoro, try the pandoro cake or pandoro tree.");

        pandoroTiramisuRecipe = recipeRepository.save(pandoroTiramisuRecipe);


    }
}
