/**
 * @author Anastasiia Klyvchuk
 * @project security-26
 * @date 21.09.2026
 */
package chnu.edu.security26.service;

import chnu.edu.security26.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeService {

    private final List<Recipe> recipes = new ArrayList<>();

    public RecipeService() {
        recipes.add(Recipe.builder()
                .id("1")
                .name("Борщ")
                .description("Класичний український борщ з буряком та капустою")
                .cookingTimeMinutes(90)
                .difficulty("Середній")
                .build());

        recipes.add(Recipe.builder()
                .id("2")
                .name("Вареники з картоплею")
                .description("Домашні вареники з картопляним пюре")
                .cookingTimeMinutes(60)
                .difficulty("Легкий")
                .build());

        recipes.add(Recipe.builder()
                .id("3")
                .name("Деруни")
                .description("Смажені картопляні оладки зі сметаною")
                .cookingTimeMinutes(40)
                .difficulty("Легкий")
                .build());
    }

    public List<Recipe> getAll() {
        return recipes;
    }

    public Optional<Recipe> getById(String id) {
        return recipes.stream()
                .filter(recipe -> recipe.getId().equals(id))
                .findFirst();
    }

    public Recipe create(Recipe recipe) {
        if (recipe.getId() == null || recipe.getId().isBlank()) {
            recipe.setId(UUID.randomUUID().toString());
        }
        recipes.add(recipe);
        return recipe;
    }

    public Optional<Recipe> update(String id, Recipe updatedRecipe) {
        Optional<Recipe> existing = getById(id);
        existing.ifPresent(recipe -> {
            recipe.setName(updatedRecipe.getName());
            recipe.setDescription(updatedRecipe.getDescription());
            recipe.setCookingTimeMinutes(updatedRecipe.getCookingTimeMinutes());
            recipe.setDifficulty(updatedRecipe.getDifficulty());
        });
        return existing;
    }

    public boolean delete(String id) {
        return recipes.removeIf(recipe -> recipe.getId().equals(id));
    }
}
