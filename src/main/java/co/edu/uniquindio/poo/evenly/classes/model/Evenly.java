package co.edu.uniquindio.poo.evenly.classes.model;

public class Evenly {
    private static Evenly instance;
//    private static User CurrentUser;

    private Evenly(){};

    public static Evenly getInstance() {
        return instance;
    }

    public static void setInstance(Evenly instance) {
        Evenly.instance = instance;
    }
}
