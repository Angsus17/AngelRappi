package com.ajgc.volleyajgcrappi;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by angel.gonzalez on 05/08/2015.
 */
public class JSONParser {


    /**
     * Método que convierte un objeto a un string json.
     * @param object objeto a convertir a JSON.
     * @return string en formato json.
     */
    public String ObjectToJSON(Object object){

        try{


            Gson gson = new Gson();

            String toJson = gson.toJson(object);

            return  toJson;
        }
        catch (Exception ex){

            Log.e("RelacionCruce", "Sucedió un error al parsear el objeto a JSON. Error: " + ex.getMessage());

            throw ex;
        }
    }

    /**
     * Método que convierte cualquier objeto a JSONObject respetando el formato de fecha requerido para WCF.
     * @param object objeto a convertir.
     * @return JSONObject del objeto convertido.
     * @throws JSONException
     */
    public JSONObject ObjectJavaToJSONWCF(Object object) throws JSONException {

        try {

            Gson gson = new GsonHelper().getGson();

            String json = gson.toJson(object);

            return new JSONObject(json);

        } catch (JSONException e) {
            e.printStackTrace();

            throw e;
        }

    }

    public JSONArray ObjectJavaToJSONArrayWCF(Object object) throws JSONException {

        try {

            Gson gson = new GsonHelper().getGson();

            String json = gson.toJson(object);

            return new JSONArray(json);

        } catch (JSONException e) {
            e.printStackTrace();

            throw e;
        }

    }

}
