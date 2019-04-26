package ru.my_restaurant_voting_system.repository;

import ru.my_restaurant_voting_system.model.Dish;
import ru.my_restaurant_voting_system.model.Menu;
import ru.my_restaurant_voting_system.model.Restaurant;
import ru.my_restaurant_voting_system.model.User;

import java.util.List;

public interface Repository {
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(int restaurantId);
    List<Restaurant> getAllRestaurants();
    boolean deleteRestaurant(int id);

    void addMenu(Restaurant restaurant, Dish... dish);
    Menu getMenu(int menuId);
    List<Menu> getAllMenus(Restaurant restaurant);

    void addDish(Restaurant restaurant, Dish dish);


    void vote(Restaurant restaurant);
}
