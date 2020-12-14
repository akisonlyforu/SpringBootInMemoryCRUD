package inmemory.Controller;

import inmemory.Entity.Topic;
import inmemory.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping("/topics/get-all-topics")
    public List<Topic> getAll() {
        return topicService.getAll() ;
    }

    @RequestMapping("/topics/get-one-by-name/{name}")
    public Topic getOne(@PathVariable String name) {
        return topicService.getOne(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/create-one")
    public List<Topic> createOne(@RequestBody Topic t) {
        return topicService.createOne(t);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/create-many")
    public List<Topic> createMany(@RequestBody Topic[] topics) {
        return topicService.createAll(topics);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/delete-one-by-name/{name}")
    public List<Topic> deleteOne(@PathVariable String name) {
        return topicService.deleteOne(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/delete-all-topics")
    public List<Topic> deleteAll() {
        return topicService.deleteAll() ;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/update-one-by-name/{name}")
    public List<Topic> updateOne(@PathVariable String name, @RequestBody Topic topic) {
        return topicService.updateOne(name, topic);
    }
}
