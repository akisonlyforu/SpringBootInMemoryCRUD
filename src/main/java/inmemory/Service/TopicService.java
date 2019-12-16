package inmemory.Service;

import inmemory.Entity.Topic;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

@Service
public class TopicService {
    ArrayList<Topic> array = new ArrayList<Topic>();

    TopicService() {
        array.add(new Topic("1", "Java", "OOP language"));
        array.add(new Topic("2", "PHP", "Scripting language"));
    }

    public ArrayList<Topic> getAll() {
        return this.array ;
    }

    public Topic getOne(@PathVariable String name) {
        for (Topic t : this.array)
            if(t.getName().equals(name))
                return t;
        return new Topic("0", "null", "Object Not Found");
    }

    public ArrayList<Topic> createOne(Topic t) {
        this.array.add(t) ;
        return this.array;
    }

    public ArrayList<Topic> createAll(Topic[] topics) {
        Collections.addAll(this.array, topics);
        return this.array;
    }

    public ArrayList<Topic> deleteOne(String name) {
        for (Topic t : this.array)
            if(t.getName().equals(name))
                this.array.remove(t);
        return this.array;
    }

    public String deleteAll() {
        this.array.clear();
        this.array.add(new Topic("1", "Java", "OOP language"));
        this.array.add(new Topic("2", "PHP", "Scripting language"));
        return "List Set to Default";
    }

    public ArrayList<Topic> updateOne(String name, Topic topic) {
        boolean found = false ;
        Topic currentTopic = null ;
        ListIterator<Topic> iterator = this.array.listIterator();
        while(iterator.hasNext()){
            currentTopic = iterator.next();
            if(currentTopic.getName().equals(name)){
                found = true ;
                break;
            }
        }
        ArrayList <Topic> noResult = new ArrayList<Topic>();
        if(found) {
            this.array.remove(currentTopic);
            this.array.add(topic);
            return this.array;
        }
        else {
            noResult.add(new Topic("0", "null", "Object Not Found"));
        }
        return noResult;
    }
}
