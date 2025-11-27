package com.example.menuservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final PizzaRepository pizzaRepository;

    @Override
    public void run(String... args) {
        if (pizzaRepository.count() == 0) {
            Pizza margherita = new Pizza();
            margherita.setName("Margherita");
            margherita.setDescription("Klasyczna pizza z sosem pomidorowym, mozzarellą i bazylią");
            margherita.setPrice(25.99);
            margherita.setSize("średnia");
            margherita.setAvailable(true);
            margherita.setImageUrl("https://images.unsplash.com/photo-1574071318508-1cdbab80d002");

            Pizza pepperoni = new Pizza();
            pepperoni.setName("Pepperoni");
            pepperoni.setDescription("Pizza z sosem pomidorowym, mozzarellą i pikantnym salami");
            pepperoni.setPrice(29.99);
            pepperoni.setSize("średnia");
            pepperoni.setAvailable(true);
            pepperoni.setImageUrl("https://images.unsplash.com/photo-1628840042765-356cda07504e");

            Pizza quattroFormaggi = new Pizza();
            quattroFormaggi.setName("Quattro Formaggi");
            quattroFormaggi.setDescription("Pizza z czterema rodzajami sera: mozzarella, gorgonzola, parmezan i ricotta");
            quattroFormaggi.setPrice(32.99);
            quattroFormaggi.setSize("średnia");
            quattroFormaggi.setAvailable(true);
            quattroFormaggi.setImageUrl("https://images.unsplash.com/photo-1513104890138-7c749659a591");

            pizzaRepository.save(margherita);
            pizzaRepository.save(pepperoni);
            pizzaRepository.save(quattroFormaggi);

            System.out.println("✅ Zainicjalizowano bazę danych z 3 pizzami");
        }
    }
}

