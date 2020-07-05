package com.mtb.manytomany.superhero_movies.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author MithileshB
 * @created 05/07/2020 - 10:04 AM
 * @project spring-boot-mybatis
 */
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @ManyToMany(mappedBy = "movies",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<SuperHero> superHeroesSet= new HashSet<>();

    public Movie(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<SuperHero> getSuperHeroesSet() {
        return superHeroesSet;
    }

    public void setSuperHeroesSet(Set<SuperHero> superHeroesSet) {
        this.superHeroesSet = superHeroesSet;
    }

    public void addSuperHero(SuperHero superHero){
        superHeroesSet.add(superHero);
        superHero.getMovies().add(this);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
