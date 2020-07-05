package com.mtb.manytomany.superhero_movies.repository;

import com.mtb.manytomany.superhero_movies.model.Movie;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * @author MithileshB
 * @created 05/07/2020 - 10:06 AM
 * @project spring-boot-mybatis
 */

public class MovieRepository {

    private EntityManager entityManager;

    public MovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Optional<Movie> save(Movie movie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
            return Optional.of(movie);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Movie> findById(Integer id) {
        Movie movie = entityManager.find(Movie.class, id);
        return movie != null ? Optional.of(movie) : Optional.empty();
    }

    public List<Movie> findAll() {
        return entityManager.createQuery("from Movie").getResultList();
    }

    public void deleteById(Integer id) {
        //Retrieve the movie with this ID
        Movie movie = entityManager.find(Movie.class, id);

        if (movie != null) {
            try {
                entityManager.getTransaction().begin();
                movie.getSuperHeroesSet().forEach(superHero -> {
                    superHero.getMovies().remove(movie);
                });
                entityManager.remove(movie);

                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
