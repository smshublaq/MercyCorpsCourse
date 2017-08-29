package com.app.widgetexample;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by iSaleem on 8/29/17.
 */

public class MyAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        int widgetsCount = appWidgetIds.length;

        for (int i=0;i<widgetsCount;i++){
            int widgetId = appWidgetIds[i];
            Random r = new Random();
            String number = r.nextInt(900) + "";

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.widget_layout);
            remoteViews.setTextViewText(R.id.tvNumber,number);

            Intent intent = new Intent(context,MyAppWidget.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,new int[]{widgetId});
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    widgetId,intent,PendingIntent.FLAG_UPDATE_CURRENT);


            remoteViews.setOnClickPendingIntent(R.id.btnRefresh,pendingIntent);


            appWidgetManager.updateAppWidget(widgetId,remoteViews);
        }


    }
}
