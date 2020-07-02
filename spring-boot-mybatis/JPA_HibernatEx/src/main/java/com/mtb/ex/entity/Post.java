package com.mtb.ex.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MithileshB
 * @created 02/07/2020 - 3:38 PM
 * @project spring-boot-mybatis
 */
@Entity
@Table(name="posts")
public class Post {

    @Id//Specifies primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //provides  for the specification of generation strategies for the values of primary keys.
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pc_fid",referencedColumnName = "id")
    List<Comment> comments=new ArrayList<>();

    public Post(){

    }

    public Post(String title,String description){
        super();
        this.title=title;
        this.description=description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
