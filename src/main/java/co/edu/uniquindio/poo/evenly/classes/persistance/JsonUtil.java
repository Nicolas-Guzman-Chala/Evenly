package co.edu.uniquindio.poo.evenly.classes.persistance;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.*;
import java.lang.reflect.Type;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class JsonUtil {

    private static final Gson gson =
            new GsonBuilder()

                    .registerTypeAdapter(
                            LocalDate.class,
                            new LocalDateAdapter()
                    )

                    .registerTypeAdapter(
                            LocalDateTime.class,
                            new LocalDateTimeAdapter()
                    )
            .registerTypeAdapter(CategoriaEvento.class,
                    (JsonDeserializer<CategoriaEvento>) (json, type, context) ->
                            CategoriaEvento.valueOf(json.getAsString()))

                    .setPrettyPrinting()

                    .create();


    public static <T> void save(
            String path,
            T data
    ){

        try(FileWriter writer =
                    new FileWriter(path)){

            gson.toJson(data, writer);

        } catch (Exception e){

            e.printStackTrace();
        }
    }



    public static <T> T read(
            String path,
            Type type
    ){

        try(FileReader reader =
                    new FileReader(path)){

            return gson.fromJson(reader, type);

        } catch (Exception e){

            e.printStackTrace();
        }

        return null;
    }
}
