package co.edu.uniquindio.poo.evenly.classes.service;

import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.persistance.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final String RUTA = "data/Users.json";

    private List<User> users;


    public UserService () {
        Type type = new TypeToken<ArrayList<User>>(){}.getType();

        users = JsonUtil.read(RUTA, type);

        if(users == null){
            users = new ArrayList<>();
        }
    }

    public int generateId() {

        int maxId = 0;

        for(User user : users) {

            if(user.getIdUser() > maxId) {

                maxId = user.getIdUser();
            }
        }

        return maxId + 1;
    }

    //Creating the CRUD

    //Create

    public void createUser(User user){
        users.add(user);

        save();
    }

    //Read

    public List<User> getUsers() {
        return users;
    }

    //Update

    public void updateUser(int id, User newUser){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getIdUser() == id){
                users.set(i, newUser);
                save();
                break;
            }
        }
    }

    public User login(String email,
                      String password) {

        for(User user : users) {

            if(user.getEmail().equals(email) &&
                    user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }

    //Delete

    public void deleteUser(int id){
        users.removeIf(user -> user.getIdUser() == id);

        save();
    }

    private void save() {
        JsonUtil.save(RUTA, users);
    }
}
