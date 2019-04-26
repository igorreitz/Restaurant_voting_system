package ru.my_restaurant_voting_system.model;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Set;

public class Menu {
    @Id
    private Integer id;

    private Set<Dish> dishes;

    private LocalDate date;

    private Restaurant restaurant;
}
