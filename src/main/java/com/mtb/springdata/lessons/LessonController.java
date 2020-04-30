package com.mtb.springdata.lessons;

import com.mtb.springdata.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @RequestMapping("topics/{id}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable String courseId){

        return lessonService.getAllLessons(courseId);
    }

    @RequestMapping("topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLesson(@PathVariable String id){
        return lessonService.getLesson(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId,@PathVariable String topicId){
        lesson.setCourse(new Course(courseId,"","",topicId));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method=RequestMethod.PUT,value="topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String courseId,@PathVariable String topicId){
        lesson.setCourse(new Course(courseId,"","",topicId));
        lessonService.updateLesson(lesson);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteLesson(@PathVariable String id){
        lessonService.deleteLesson(id);
    }
}
