package ru.my_restaurant_voting_system.web;

import org.springframework.beans.factory.annotation.Autowired;
import ru.my_restaurant_voting_system.model.Restaurant;
import ru.my_restaurant_voting_system.repository.Repository;

public class UserRestController {
    @Autowired
    private Repository repository;

    public void vote(Restaurant restaurant) {
        repository.vote(restaurant);
    }
}
