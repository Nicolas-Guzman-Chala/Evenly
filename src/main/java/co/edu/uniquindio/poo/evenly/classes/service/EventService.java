package co.edu.uniquindio.poo.evenly.classes.service;

import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.persistance.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EventService {
    private final String RUTE = "data/Events.json";

    private List<Event> events;

    public EventService () {
        Type type = new TypeToken<ArrayList<Event>>(){}.getType();

        events = JsonUtil.read(RUTE, type);

        if(events == null){
            events = new ArrayList<>();
        }
    }

    //Creating the CRUD

    //Create

    public void createEvent(Event event){
        events.add(event);

        save();
    }

    //Read

    public List<Event> getEvent() {
        return events;
    }

    //Update

    public void updateEvent(int id, Event newEvent){
        for(int i = 0; i < events.size(); i++){
            if(events.get(i).getIdEvent() == (id)){
                events.set(i, newEvent);
                save();
                break;
            }
        }
    }

    //Delete

    public void deleteEvent(int id){
        events.removeIf(user -> user.getIdEvent() == (id));

        save();
    }

    private void save() {
        JsonUtil.save(RUTE, events);
    }
}
