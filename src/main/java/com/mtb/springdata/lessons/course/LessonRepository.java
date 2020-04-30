package com.mtb.springdata.lessons.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson,String> {

    public List<Lesson> findByTopicId(String topicId);
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)
}
