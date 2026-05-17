package co.edu.uniquindio.poo.evenly.classes.model;

public class Evenly {
    private static Evenly instance;
//    private static User CurrentUser;

    private Evenly(){}

    /**
     * getInstance verificara que siempre haya una sola instancia de
     * evenly, cumpliendo con el proposito de singleton
     * @return Evenly
     */
    public static Evenly getInstance() {
        if (instance == null) {
            instance = new Evenly();
            return instance;
        }
        return instance;
    }

}
