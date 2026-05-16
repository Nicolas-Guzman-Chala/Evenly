package co.edu.uniquindio.poo.evenly.classes.model;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class LocalDateTimeAdapter
        implements JsonSerializer<LocalDateTime>,
        JsonDeserializer<LocalDateTime> {

    @Override
    public JsonElement serialize(
            LocalDateTime localDateTime,
            Type type,
            JsonSerializationContext context
    ) {

        return new JsonPrimitive(
                localDateTime.toString()
        );
    }

    @Override
    public LocalDateTime deserialize(
            JsonElement json,
            Type type,
            JsonDeserializationContext context
    ) throws JsonParseException {

        return LocalDateTime.parse(
                json.getAsString()
        );
    }
}
