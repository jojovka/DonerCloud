package kz.example.doner_cloud.Util;

import kz.example.doner_cloud.Model.Ingredient;
import kz.example.doner_cloud.Repository.Impl.JdbcIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import kz.example.doner_cloud.Model.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final JdbcIngredientRepository jdbcIngredientRepository;

    @Autowired
    IngredientByIdConverter(JdbcIngredientRepository jdbcIngredientRepository) {
        this.jdbcIngredientRepository = jdbcIngredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return jdbcIngredientRepository.findById(id).orElse(null);
    }
}