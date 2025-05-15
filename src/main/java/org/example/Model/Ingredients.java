package org.example.Model;

import jakarta.persistence.*;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    public Ingredients() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meal getMeal(Meal meal1) {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
