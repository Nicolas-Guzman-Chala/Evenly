package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import co.edu.uniquindio.poo.evenly.classes.navigation.SceneManager;
import co.edu.uniquindio.poo.evenly.classes.service.ImageService;

public class Evenly {

    private static Evenly instance;

    private final EventService eventService;

    private final SceneManager sceneManager;

    private final ImageService imageService;

    private Evenly() {

        this.eventService =
                new EventService();

        this.sceneManager =
                new SceneManager();

        this.imageService =
                new ImageService();
    }

    public static Evenly getInstance(){

        if(instance == null){

            instance = new Evenly();
        }

        return instance;
    }

    public EventService getEventService() {

        return eventService;
    }

    public SceneManager getSceneManager() {

        return sceneManager;
    }

    public ImageService getImageService() {

        return imageService;
    }
}