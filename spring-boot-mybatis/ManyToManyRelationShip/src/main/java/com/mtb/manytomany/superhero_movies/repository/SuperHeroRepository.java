package com.mtb.manytomany.superhero_movies.repository;

import com.mtb.manytomany.superhero_movies.model.SuperHero;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

/**
 * @author MithileshB
 * @created 05/07/2020 - 10:44 AM
 * @project spring-boot-mybatis
 */
public class SuperHeroRepository {

    private EntityManager entityManager;

    public SuperHeroRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<SuperHero> save(SuperHero superHero) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(superHero);
            entityManager.getTransaction().commit();
            return Optional.of(superHero);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<SuperHero> findById(Integer id) {
        SuperHero superHero = entityManager.find(SuperHero.class, id);
        return superHero != null ? Optional.of(superHero) : Optional.empty();
    }

    public List<SuperHero> findAll() {
        return entityManager.createQuery("from SuperHero").getResultList();
    }

    public void deleteById(Integer id) {
        SuperHero superHero = entityManager.find(SuperHero.class, id);

        if (superHero != null) {
            try {
                entityManager.getTransaction().begin();
                superHero.getMovies().forEach(movie -> {
                    movie.getSuperHeroesSet().remove(superHero);
                });
                entityManager.remove(superHero);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
