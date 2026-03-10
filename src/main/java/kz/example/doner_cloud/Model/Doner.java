package kz.example.doner_cloud.Model;

import lombok.Data;

import java.util.List;

@Data
public class Doner {

    private String name;
    private List<Ingredient> ingredients;
}
