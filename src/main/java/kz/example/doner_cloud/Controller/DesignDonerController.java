package kz.example.doner_cloud.Controller;

import jakarta.validation.Valid;
import kz.example.doner_cloud.Model.Doner;
import kz.example.doner_cloud.Model.DonerOrder;
import kz.example.doner_cloud.Model.Ingredient;
import kz.example.doner_cloud.Model.Ingredient.Type;

import kz.example.doner_cloud.Repository.Impl.JdbcIngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("donerOrder")
public class DesignDonerController {

    private final JdbcIngredientRepository jdbcIngredientRepository;

    @Autowired
    public DesignDonerController(JdbcIngredientRepository jdbcIngredientRepository) {
        this.jdbcIngredientRepository = jdbcIngredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = jdbcIngredientRepository.findAll();
        Type[] types = Ingredient.Type.values();
        for(Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients, type));
        }
    }

    @ModelAttribute(name = "donerOrder")
    public DonerOrder order() {
        return new DonerOrder();
    }

    @ModelAttribute(name = "doner")
    public Doner doner() {
        return new Doner();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processDoner(
            @Valid Doner doner,
            Errors errors,
            @ModelAttribute DonerOrder donerOrder) {

        if (errors.hasErrors()) {
            return "design";
        }

        donerOrder.addDoner(doner);
        log.info("Processing doner: {}", doner);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
