package ru.my_restaurant_voting_system.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.my_restaurant_voting_system.model.Dish;
import ru.my_restaurant_voting_system.model.Menu;
import ru.my_restaurant_voting_system.model.Restaurant;

import java.util.List;

@org.springframework.stereotype.Repository
@Transactional(readOnly = true)
public class RepositoryImpl implements Repository {

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant(Restaurant restaurant) {
        if (!restaurant.isNew() && getRestaurant(restaurant.getId()) == null) {
            return null;
        }
        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        return crudRestaurantRepository.findById(restaurantId).get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return crudRestaurantRepository.findAll();
    }

    @Override
    public boolean deleteRestaurant(int id) {
        return crudRestaurantRepository.delete(id) != 0;
    }

    @Override
    public void addMenu(Restaurant restaurant, Dish... dish) {

    }

    @Override
    @Transactional
    public void addDish(Restaurant restaurant, Dish dish) {

    }

    @Override
    public Menu getMenu(int menuId) {
        return null;
    }

    @Override
    public List<Menu> getAllMenus(Restaurant restaurant) {
        return null;
    }

    @Override
    @Transactional
    public void vote(Restaurant restaurant) {

    }
}
