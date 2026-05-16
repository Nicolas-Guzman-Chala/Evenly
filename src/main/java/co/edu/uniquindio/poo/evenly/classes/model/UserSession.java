package co.edu.uniquindio.poo.evenly.classes.model;

public class UserSession {

    private static User currentUser;

    public static void login(User user) {

        currentUser = user;
    }

    public static User getCurrentUser() {

        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserSession.currentUser = currentUser;
    }
}
