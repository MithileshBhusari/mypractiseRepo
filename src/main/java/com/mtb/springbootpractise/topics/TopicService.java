package com.mtb.springbootpractise.topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

      private List<Topic> topicList= new ArrayList<>(Arrays.asList(
              new Topic("Spring","Spring Framework","Spring Framework Description"),
                new Topic("Java","Core Java","Core Java Description"),
                new Topic("Javascript","Javascript","Javascript Description")
        ));

      public List<Topic> getAllTopics(){
          return topicList;
      }

      public Topic getTopic(String id){
          return topicList.stream().filter(t->t.getId().equals(id)).findFirst().get();
      }

      public void addTopic(Topic topic){
          topicList.add(topic);
      }

    public void updateTopic(Topic topic, String id) {
        for(int i=0;i<topicList.size();i++){
            Topic topic1=topicList.get(i);
            if(topic1.getId().equals(id)){
                topicList.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
          topicList.removeIf(t->t.getId().equals(id));
    }
}
