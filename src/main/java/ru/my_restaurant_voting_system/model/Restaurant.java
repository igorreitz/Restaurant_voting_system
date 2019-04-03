package ru.my_restaurant_voting_system.model;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class Restaurant {
    private String name;

    private Map<LocalDate, Set<Dish>> menu;

    private Set<User> votedUsers;
}
