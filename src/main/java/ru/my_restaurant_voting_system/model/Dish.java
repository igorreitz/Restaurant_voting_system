package ru.my_restaurant_voting_system.model;

import javax.persistence.Id;
import java.time.LocalDate;

public class Dish {
    @Id
    private Integer id;

    private String name;

    private int price;
}
