package com.mtb.springdata.course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {

    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)
}
