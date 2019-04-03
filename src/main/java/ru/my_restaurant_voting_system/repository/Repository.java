package ru.my_restaurant_voting_system.repository;

import ru.my_restaurant_voting_system.model.Dish;
import ru.my_restaurant_voting_system.model.Restaurant;
import ru.my_restaurant_voting_system.model.User;

public interface Repository {
    void addRestaurant(Restaurant restaurant);

    Restaurant getRestaurant();

    void addDish(Restaurant restaurant, Dish dish);

    void vote(Restaurant restaurant, User user);
}
