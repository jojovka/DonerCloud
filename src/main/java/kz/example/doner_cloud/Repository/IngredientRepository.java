package kz.example.doner_cloud.Repository;

import kz.example.doner_cloud.Model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
