// EventService.java

package co.edu.uniquindio.poo.evenly.classes.service;

import co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO.*;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.Zona;
import co.edu.uniquindio.poo.evenly.classes.persistance.JsonUtil;
import co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO.CreateEventDTO;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    private static final String RUTE =
            "data/Events.json";

    private final List<Event> events;

    public EventService() {

        Type type =
                new TypeToken<ArrayList<Event>>(){}.getType();

        List<Event> loadedEvents =
                JsonUtil.read(RUTE, type);

        this.events =
                loadedEvents != null
                        ? loadedEvents
                        : new ArrayList<>();
    }

    public void createEvent(
            CreateEventDTO dto
    ) {

        validateEvent(dto);

        EventFactoryDTO factory =
                getFactory(
                        dto.category()
                );

        Event event =
                factory.createEventDTO(dto);

        events.add(event);

        save();
    }

    public List<Event> getEvents() {

        return events;
    }

    public List<Event> filterEvents(

            CategoriaEvento category,

            Cities city,

            double maxPrice,

            LocalDate date
    ){

        for (Event e : events) {
            System.out.println(
                    e.getName() +
                            " | category=" + e.getCategory() +
                            " | recinto=" + e.getRecinto()
            );
        }

        List<Event> filteredEvents =
                new ArrayList<>();

        for(Event event : events){

            boolean categoryMatch =

                    category == CategoriaEvento.TODOS ||

                            event.getCategory() == category;

            boolean cityMatch =

                    city == Cities.TODAS ||

                            event.getCity() == city;

            boolean priceMatch =
                    hasValidPrice(
                            event,
                            maxPrice
                    );

            boolean dateMatch =

                    date == null ||

                            event.getDate().equals(date);

            if(

                    categoryMatch &&

                            cityMatch &&

                            priceMatch &&

                            dateMatch
            ){

                filteredEvents.add(event);
            }
        }

        return filteredEvents;
    }

    private boolean hasValidPrice(Event event, double maxPrice) {

        return event.getPrice() <= maxPrice;
    }

    public void updateEvent(
            String id,
            Event updatedEvent
    ) {

        for(int i = 0; i < events.size(); i++){

            Event currentEvent =
                    events.get(i);

            if(currentEvent.getId().equals(id)){

                events.set(i, updatedEvent);

                save();

                return;
            }
        }

        throw new IllegalArgumentException(
                "Evento no encontrado"
        );
    }

    public void deleteEvent(
            String id
    ) {

        boolean removed =
                events.removeIf(
                        event ->
                                event.getId().equals(id)
                );

        if(!removed){

            throw new IllegalArgumentException(
                    "Evento no encontrado"
            );
        }

        save();
    }

    private void validateEvent(
            CreateEventDTO dto
    ) {

        if(dto == null){

            throw new IllegalArgumentException(
                    "El evento no puede ser null"
            );
        }

        if(dto.name() == null ||
                dto.name().isBlank()){

            throw new IllegalArgumentException(
                    "El nombre es obligatorio"
            );
        }

        if(dto.city() == null){

            throw new IllegalArgumentException(
                    "La ciudad es obligatoria"
            );
        }

        if(dto.date() == null){

            throw new IllegalArgumentException(
                    "La fecha es obligatoria"
            );
        }

        if(dto.hour() == null ||
                dto.hour().isBlank()){

            throw new IllegalArgumentException(
                    "La hora es obligatoria"
            );
        }

        if(dto.category() == null){

            throw new IllegalArgumentException(
                    "La categoria es obligatoria"
            );
        }

        if(dto.state() == null){

            throw new IllegalArgumentException(
                    "El estado es obligatorio"
            );
        }

        try {

            LocalTime.parse(
                    dto.hour()
            );

        } catch (Exception e){

            throw new IllegalArgumentException(
                    "Formato de hora inválido"
            );
        }
    }

    public EventFactoryDTO getFactory(
            CategoriaEvento categoria
    ) {

        return switch (categoria){

            case CONCIERTO ->
                    new ConciertoFactoryDTO();

            case TEATRO ->
                    new TeatroFactoryDTO();

            case CONFERENCIA ->
                    new ConferenciaFactoryDTO();

            default ->
                    throw new IllegalArgumentException(
                            "Categoria inválida"
                    );
        };
    }

    private void save() {

        JsonUtil.save(
                RUTE,
                events
        );
    }
}