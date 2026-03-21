package kz.example.doner_cloud.Repository;

import kz.example.doner_cloud.Model.Ingredient;

import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(long id);

    Ingredient save(Ingredient ingredient);
}
