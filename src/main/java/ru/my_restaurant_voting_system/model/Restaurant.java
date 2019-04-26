package ru.my_restaurant_voting_system.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    //private Menu menu;

    //private Set<User> votedUsers;


}
