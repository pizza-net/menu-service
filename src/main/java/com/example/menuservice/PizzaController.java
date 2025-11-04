package com.example.menuservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
@RequiredArgsConstructor
public class PizzaController {
    private final PizzaService pizzaService;

    @GetMapping
    public List<Pizza> getAll() {
        return pizzaService.getAll();
    }

    @GetMapping("/{id}")
    public Pizza getById(@PathVariable Long id) {
        return pizzaService.getById(id);
    }

    @PostMapping
    public Pizza add(@RequestBody Pizza pizza) {
        return pizzaService.addPizza(pizza);
    }

    @PutMapping("/{id}")
    public Pizza update(@PathVariable Long id, @RequestBody Pizza pizza) {
        return pizzaService.updatePizza(id, pizza);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pizzaService.deletePizza(id);
    }
}
