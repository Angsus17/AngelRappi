package com.ajgc.volleyajgcrappi;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

/**
 * Created by angel.gonzalez on 04/08/2015.
 */
public class VolleyErrorHelper {

    /**
     * M�todo que obtiene el mensaje de error de acuerdo al tipo de error.
     * @param error Objeto que contiene el error.
     * @param context Contexto de la app.
     * @return String con el mensaje de error.
     */
    public static String getMessage(Object error, Context context) {

        try {
            if (error instanceof TimeoutError) {
                return context.getResources().getString(R.string.timeout_error);
            } else if (isServerProblem(error)) {
                return handleServerError(error, context);
            } else if (isNetworkProblem(error)) {
                return context.getResources().getString(R.string.no_internet);
            }
            return context.getResources().getString(R.string.generic_error);
        }
        catch (Exception ex){
            Log.e("RECO", ex.getMessage());
        }

        return "No se encontro error..";
    }

    /**
     * M�todo que determina si el error est� relacionado con la red.
     * @param error
     * @return
     */
    private static boolean isNetworkProblem(Object error) {
        return (error instanceof NetworkError) || (error instanceof NoConnectionError);
    }
    /**
     * M�todo que determina si el error est� relacionado con el servidor.
     * @param error
     * @return
     */
    private static boolean isServerProblem(Object error) {
        return (error instanceof ServerError) || (error instanceof AuthFailureError);
    }
    /**
     * M�todo para determinar el tipo de error ocurrido con el servidor.
     *
     * @param err
     * @param context
     * @return
     */
    private static String handleServerError(Object err, Context context) {

        try{
        VolleyError error = (VolleyError) err;

        NetworkResponse response = error.networkResponse;

        if (response != null) {
            switch (response.statusCode) {
                case 404:
                case 422:
                case 401:
                    return context.getResources().getString(R.string.error_server);

                default:
                    return context.getResources().getString(R.string.generic_server_down);
            }
        }
        return context.getResources().getString(R.string.generic_error);
        }
        catch (Exception ex){
            Log.e("RECO", ex.getMessage());
        }

        return "No se encontro error.";
    }
}

