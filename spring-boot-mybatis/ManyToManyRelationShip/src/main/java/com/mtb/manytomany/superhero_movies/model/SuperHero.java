package com.mtb.manytomany.superhero_movies.model;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author MithileshB
 * @created 05/07/2020 - 10:04 AM
 * @project spring-boot-mybatis
 */
@Entity
@Table(name = "super_hero")
public class SuperHero {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    /**we have set the fetch to EAGER, so that when we retrieve a SuperHero from the database,
     * we'll also automatically retrieve all of its corresponding Movies.
     * If we chose to perform a LAZY fetch instead, we would only retrieve each Movie as it was specifically accessed.
     * Lazy fetching is only possible while the SuperHero is attached to the EntityManager;
     * otherwise accessing a superhero's movies will throw an exception.
     * We want to be able to access a superhero's movies on demand, so in this case we choose the EAGER fetching strategy.
     *
     * Cascade operations define how superheroes and their corresponding movies are persisted to and from the database.
     * we have set the cascade attribute to CascadeType.PERSIST,
     * which means that when we save a superhero, its movies will also be saved.
     * */
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name = "SuperHero_Movie",
    joinColumns = {@JoinColumn(name = "superhero_id")},
    inverseJoinColumns = {@JoinColumn(name = "movie_id")})
    private Set<Movie> movies=new HashSet<>();

    public SuperHero(){
    }

    public SuperHero(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies.stream().map(Movie::getTitle).collect(Collectors.toList()) +'\''+
                '}';
    }
}
