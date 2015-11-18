package com.ajgc.volleyajgcrappi;

import android.content.Context;
import android.util.Log;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by angel.gonzalez on 11/11/2015.
 */
public class HttpServiciosControllerVolley {

    private Context context;
    private IListenerResult _IListenerResult;
    private String URLServicio;


    public  HttpServiciosControllerVolley(Context context, String url){

        this.context = context;
        this.URLServicio = url;
    }


    public void callMethodoPost(){

        JSONObject jsonObject = null;


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, this.URLServicio, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {






                if(_IListenerResult != null){

                    _IListenerResult.onProcessFinish(response);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                String mensajeError = VolleyErrorHelper.getMessage(error, context);

                if(_IListenerResult != null){

                    if(mensajeError != null){
                        _IListenerResult.onError(mensajeError);
                    }
                    else {
                        _IListenerResult.onError(error.getMessage());
                    }

                }
            }
        }){





            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }


        };

        int socketTimeout = 30000;//30 segundos
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjectRequest.setRetryPolicy(policy);


        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    public void setListenerResult(IListenerResult p_ListenerResult){

        _IListenerResult = p_ListenerResult;
    }



}

