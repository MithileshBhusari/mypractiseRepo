package com.mtb.ex.entity;

import javax.persistence.*;

/**
 * @author MithileshB
 * @created 02/07/2020 - 3:38 PM
 * @project spring-boot-mybatis
 */
@Entity
@Table(name="comments")
public class Comment {

    @Id //specifies primary key of any entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //provides for the specification of generationStrategies for the values of primary keys
    private long id;

    private String text;

    public Comment(){

    }

    public Comment(String text){
        super();
        this.text=text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
