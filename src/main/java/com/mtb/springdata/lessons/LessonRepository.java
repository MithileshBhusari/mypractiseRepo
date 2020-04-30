package com.mtb.springdata.lessons;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson,String> {

    public List<Lesson> findByCourseId(String courseId);
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)
}
