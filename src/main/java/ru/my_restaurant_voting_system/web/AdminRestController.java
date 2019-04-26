package ru.my_restaurant_voting_system.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.my_restaurant_voting_system.model.Dish;
import ru.my_restaurant_voting_system.model.Restaurant;
import ru.my_restaurant_voting_system.repository.Repository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private Repository repository;
    static final String REST_URL = "/rest/admin/";

    public AdminRestController(Repository repository) {
        this.repository = repository;
    }

    //RESTAURANT

    @PostMapping(value = "/restaurant", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        Restaurant created = repository.addRestaurant(restaurant);
        log.info("add {}", restaurant);


        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "restaurant/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping("restaurant")
    public List<Restaurant> getAll() {
        log.info("Get all restaurants");
        return repository.getAllRestaurants();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("Get restaurant with id {}", id);
        return repository.getRestaurant(id);
    }

    @DeleteMapping("/restaurant/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("Delete restaurant with id {}", id);
        repository.deleteRestaurant(id);
    }

/*    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDish(@PathVariable int id, Dish dish){
        repository.addDish(restaurant,dish);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMenu (Restaurant restaurant, Dish... dish) {
        repository.addMenu(restaurant,dish);
    }*/
}
