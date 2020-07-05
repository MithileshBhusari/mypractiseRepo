package com.mtb.manytomany.superhero_movies;

import com.mtb.manytomany.superhero_movies.model.Movie;
import com.mtb.manytomany.superhero_movies.model.SuperHero;
import com.mtb.manytomany.superhero_movies.repository.MovieRepository;
import com.mtb.manytomany.superhero_movies.repository.SuperHeroRepository;
import org.h2.util.JdbcUtils;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author MithileshB
 * @created 05/07/2020 - 10:52 AM
 * @project spring-boot-mybatis
 */

@SpringBootApplication
@EnableJpaAuditing
public class MTMSuperHero_MovieMainClass {

    public static void main(String[] args) {
        //create our entityManager
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("SuperHeroes");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        MovieRepository movieRepository = new MovieRepository(entityManager);
        SuperHeroRepository superHeroRepository = new SuperHeroRepository(entityManager);

        //create SuperHeros
        SuperHero ironman=new SuperHero("Ironman");
        SuperHero thor=new SuperHero("Thor");
        SuperHero hulk=new SuperHero("Hulk");
        SuperHero spider_man=new SuperHero("Spider Man");
        SuperHero captain_america=new SuperHero("Captain America");
        SuperHero thanos=new SuperHero("Thanos");

        //Create Movies
        Movie avengers=new Movie("The Avengers");
        avengers.addSuperHero(ironman);
        avengers.addSuperHero(thor);
        avengers.addSuperHero(captain_america);
        avengers.addSuperHero(spider_man);
        avengers.addSuperHero(thanos);
        avengers.addSuperHero(hulk);
        movieRepository.save(avengers);


        Movie infinityWar=new Movie("Avengers: Infinity War");
        infinityWar.addSuperHero(ironman);
        infinityWar.addSuperHero(captain_america);
        infinityWar.addSuperHero(thanos);
        infinityWar.addSuperHero(spider_man);
        infinityWar.addSuperHero(thor);
        movieRepository.save(infinityWar);

        Movie thor_Ragnarok=new Movie("Thor: Ragnarok");
        thor_Ragnarok.addSuperHero(thor);
        thor_Ragnarok.addSuperHero(hulk);

        System.out.println("=======FIND ALL MOVIES===========");
        movieRepository.findAll().forEach(movie -> {
            System.out.println("Movie: ["+movie.getId()+"] "+movie.getTitle());
            movie.getSuperHeroesSet().forEach(System.out::println);
        });

        System.out.println("===========FIND ALL SUPERHEROS============");
        superHeroRepository.findAll().forEach(superHero -> {
            System.out.println("SuperHero :["+superHero.getId()+"] "+ superHero.getName());
            superHero.getMovies().forEach(System.out::println);
        });

        //Delete A Movie
        movieRepository.deleteById(1);
        System.out.println("=======After DELETING MOVIE with ID 1========");
        movieRepository.findAll().forEach(movie -> {
            System.out.println("Movie: ["+movie.getId()+"] "+movie.getTitle());
            movie.getSuperHeroesSet().forEach(System.out::println);
        });
        System.out.println("===========AFTER DELETING MOVIE WITH ID 1============");
        superHeroRepository.findAll().forEach(superHero -> {
            System.out.println("SuperHero :["+superHero.getId()+"] "+ superHero.getName());
            superHero.getMovies().forEach(System.out::println);
        });

        superHeroRepository.deleteById(2);
        System.out.println("=======After DELETING SUPERHERO with ID 2========");
        movieRepository.findAll().forEach(movie -> {
            System.out.println("Movie: ["+movie.getId()+"] "+movie.getTitle());
            movie.getSuperHeroesSet().forEach(System.out::println);
        });
        System.out.println("===========AFTER DELETING SUPERHERO WITH ID 2============");
        superHeroRepository.findAll().forEach(superHero -> {
            System.out.println("SuperHero :["+superHero.getId()+"] "+ superHero.getName());
            superHero.getMovies().forEach(System.out::println);
        });
      entityManager.close();
      entityManagerFactory.close();

    }
}
