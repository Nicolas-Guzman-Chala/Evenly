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

    public void updateUser(String id, User newUser){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getIdUser().equals(id)){
                users.set(i, newUser);
                save();
                break;
            }
        }
    }

    //Delete

    public void deleteUser(String id){
        users.removeIf(user -> user.getIdUser().equals(id));

        save();
    }

    private void save() {
        JsonUtil.save(RUTA, users);
    }
}
