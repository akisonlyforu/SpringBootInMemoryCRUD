package inmemory.Service;

import inmemory.Entity.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class TopicService {

    private final static String NOT_AVAILABLE = "NA";

    Map<String, Topic> stringTopicMap = new HashMap<>();

    TopicService() {
    }

    public List<Topic> getAll() {
        return (List<Topic>) this.stringTopicMap.values();
    }

    public Topic getOne(@PathVariable String name) {
        Topic topic = this.stringTopicMap.get(name);
        if(topic==null)
            return new Topic(NOT_AVAILABLE, "null", "Topic Not Found");
        return topic;
    }

    public List<Topic> createOne(Topic t) {
        this.stringTopicMap.put(t.getName(), t) ;
        return (List<Topic>) this.stringTopicMap.values();
    }

    public List<Topic> createAll(Topic[] topics) {
        for (Topic singleTopic: topics)
            this.stringTopicMap.put(singleTopic.getName(), singleTopic);
        return (List<Topic>) this.stringTopicMap.values();
    }

    public List<Topic> deleteOne(String name) {
        this.stringTopicMap.remove(name);
        return (List<Topic>) this.stringTopicMap.values();
    }

    public List<Topic> deleteAll() {
        this.stringTopicMap.clear();
        return (List<Topic>) this.stringTopicMap.values();
    }

    public List<Topic> updateOne(String name, Topic topic) {
        this.stringTopicMap.put(name, topic);
        return (List<Topic>) this.stringTopicMap.values();
    }
}
