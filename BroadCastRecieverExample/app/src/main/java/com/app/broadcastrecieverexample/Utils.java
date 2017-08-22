package com.app.broadcastrecieverexample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by iSaleem on 8/22/17.
 */

public class Utils {

    public static void getPref(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("aa",context.MODE_PRIVATE);
    }
}
