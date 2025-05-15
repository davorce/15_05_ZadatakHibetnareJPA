package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.Model.Ingredients;
import org.example.Model.Meal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Meal meal1 = new Meal();
        meal1.setName("Pizza");
        em.persist(meal1);

        Meal meal2 = new Meal();
        meal2.setName("Burger");
        em.persist(meal2);

        Meal meal3 = new Meal();
        meal3.setName("Salata");
        em.persist(meal3);

        Ingredients ingredients1 = new Ingredients();
        ingredients1.setName("Rajcica");
        meal1.getIngredients().add(ingredients1);
        meal2.getIngredients().add(ingredients1);
        meal3.getIngredients().add(ingredients1);
        em.persist(ingredients1);

        Ingredients ingredients2 = new Ingredients();
        ingredients2.setName("Sir");
        meal1.getIngredients().add(ingredients2);
        meal2.getIngredients().add(ingredients2);
        em.persist(ingredients2);

        Ingredients ingredients3 = new Ingredients();
        ingredients3.setName("Zelje");
        meal2.getIngredients().add(ingredients3);
        meal3.getIngredients().add(ingredients3);
        em.persist(ingredients3);

        List<Meal> meals = em.createQuery("select m from Meal m", Meal.class).getResultList();
        for (Meal m : meals) {
            System.out.println("Naziv jela: " + m.getName());
            for (Ingredients i : m.getIngredients()) {
                System.out.println("\t - " + i.getName());
            }
        }

        tx.commit();
        em.close();
        emf.close();
    }
}