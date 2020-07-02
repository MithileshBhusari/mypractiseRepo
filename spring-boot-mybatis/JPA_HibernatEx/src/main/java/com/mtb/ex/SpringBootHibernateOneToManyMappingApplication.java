package com.mtb.ex;

import com.mtb.ex.entity.Comment;
import com.mtb.ex.entity.Post;
import com.mtb.ex.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MithileshB
 * @created 02/07/2020 - 3:40 PM
 * @project spring-boot-mybatis
 */

@SpringBootApplication
public class SpringBootHibernateOneToManyMappingApplication implements CommandLineRunner {
    @Autowired
    private PostRepository postRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateOneToManyMappingApplication.class,args);
    }
    @Override
    public void run(String... args) throws Exception {

        Post post=new Post("Spring boot practise ","One to Many mapping using JPA and hibernate");

        Comment comment1=new Comment("Very useful");
        Comment comment2=new Comment("informative");
        Comment comment3=new Comment("Great Post");

        post.getComments().add(comment1);
        post.getComments().add(comment2);
        post.getComments().add(comment3);

        this.postRepository.save(post);
    }
}
