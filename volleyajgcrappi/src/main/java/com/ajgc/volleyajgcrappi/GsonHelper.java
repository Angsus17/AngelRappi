package com.ajgc.volleyajgcrappi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by angel.gonzalez on 05/08/2015.
 */
public class GsonHelper {

    /**
     * Método que genera una instancia de GsonBuilder con representación de fechas.
     * @return Gson con representación de fechas.
     */
    public Gson getGson() {

        GsonBuilder builder = new GsonBuilder().setDateFormat(DateFormat.LONG, DateFormat.LONG);
        builder.registerTypeAdapter(Date.class, new DotNetDateDeserializer());
        builder.registerTypeAdapter(Date.class, new DotNetDateSerializer());

        return builder.create();
    }

    /**
     * Método que deserializa las fechas enviadas en formato del WCF.
     */
    public class DotNetDateDeserializer implements JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement json, Type typfOfT, JsonDeserializationContext context) {
            try {
                String dateStr = json.getAsString();
                if (dateStr != null) dateStr = dateStr.replace("/Date(", "");
                if (dateStr != null) dateStr = dateStr.replace("+0000)/", "");
                if (dateStr != null) dateStr = dateStr.replace(")/", "");
                long time = Long.parseLong(dateStr);
                return new Date(time);
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }

        }
    }

    /**
     * Clase que serializa las fechas en el formato esperado por el WCF.
     */
    public class DotNetDateSerializer implements JsonSerializer<Date> {
        @Override
        public JsonElement serialize(Date date, Type typfOfT, JsonSerializationContext context) {
            if (date == null)
                return null;

            String dateStr = "/Date(" + date.getTime() + ")/";

            return new JsonPrimitive(dateStr);
        }
    }
}

