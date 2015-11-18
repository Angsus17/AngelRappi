package com.angelgonzalez.rappi.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import com.angelgonzalez.rappi.model.Aplicaciones;
import com.google.gson.Gson;

/**
 * Created by angel.gonzalez on 17/11/2015.
 */
public class Util {

    private static boolean isArtist;

    public static boolean isTablet(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
               >= Configuration.SCREENLAYOUT_SIZE_LARGE;

    }

    public static  void setIsArtist(boolean p_isArtist){
        isArtist = p_isArtist;
    }

    public static boolean isArtist() {
        return isArtist;
    }

    public static void setRequestedOrientation(Context context){
        if(isTablet(context)){
            ((Activity)context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        else {
            ((Activity)context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }


}
