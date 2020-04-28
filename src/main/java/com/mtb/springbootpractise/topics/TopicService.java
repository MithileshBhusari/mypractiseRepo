package com.mtb.springbootpractise.topics;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

      private List<Topic> topicList= Arrays.asList(
              new Topic("Spring","Spring Framework","Spring Framework Description"),
                new Topic("Java","Core Java","Core Java Description"),
                new Topic("Javascript","Javascript","Javascript Description")
        );

      public List<Topic> getAllTopics(){
          return topicList;
      }
}
