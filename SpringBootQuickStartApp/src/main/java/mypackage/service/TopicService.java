package mypackage.service;

import mypackage.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays
			.asList(new Topic("1", "name of topic 1", "description 1"),
					new Topic("2", "name of topic 2", "description 2"),
					new Topic("3", "name of topic 3", "description 3")));

	public List<Topic> getAllTopics(){
		return topics;
	}

	public Topic getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); i++){
			Topic topic1 = topics.get(i);
			if(topic.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t ->t.getId().equals(id));
	}
}
