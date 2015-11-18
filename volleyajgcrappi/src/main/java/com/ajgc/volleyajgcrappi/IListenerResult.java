package com.ajgc.volleyajgcrappi;

/**
 * Created by angel.gonzalez on 04/08/2015.
 */
public interface IListenerResult<T> {



    void onProcessFinish(T response);

    void onError(String p_MensajeError);
}