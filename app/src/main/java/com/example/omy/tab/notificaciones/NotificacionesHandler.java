package com.example.omy.tab.notificaciones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import com.example.omy.tab.R;

public class NotificacionesHandler extends ContextWrapper {

    private NotificationManager manager;
    public static final String CHANEL_HIGH_ID = "1";
    private final String CHANEL_HIGH_NAME = "HIGH CHANNEL";
    private static final String CHANEL_LOW_ID = "2";
    private final String CHANEL_LOW_NAME = "LOW CHANNEL";

    public NotificacionesHandler(Context base) {
        super(base);
        createChanael();
    }


    public NotificationManager getManager() {
        if (manager == null) {
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        }
        return manager;
    }

    private void createChanael() {
        if (Build.VERSION.SDK_INT >= 26) {
            //create el high channel
            NotificationChannel highChannel = new NotificationChannel(CHANEL_HIGH_ID, CHANEL_HIGH_NAME, NotificationManager.IMPORTANCE_HIGH);
            //extra configuration no aplica para todos los moviles
            highChannel.enableLights(true); // luces para prender
            highChannel.setLightColor(Color.YELLOW);
            highChannel.setShowBadge(true); //puntito en elicono
            highChannel.enableVibration(true);
            highChannel.setVibrationPattern(new long[]{100,200,300,400,400,300,200,400}); //bibracion
            highChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);// tipode vista de la notificacion
            Uri defaultSonidoUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);//par pasar tono de notificacion
            highChannel.setSound(defaultSonidoUri,null);
 //end extraz
            NotificationChannel lowChannel = new NotificationChannel(CHANEL_LOW_ID, CHANEL_LOW_NAME, NotificationManager.IMPORTANCE_LOW);

            getManager().createNotificationChannel(highChannel);
            getManager().createNotificationChannel(lowChannel);
        }
    }


    public Notification.Builder crearNotificacion(String title, String mensaje, boolean isHigImportan) {
        if (Build.VERSION.SDK_INT >= 26) {
            if(isHigImportan)
            {
              return crearNotificacionWithChanel(title,mensaje,CHANEL_HIGH_ID);
            }
            return crearNotificacionWithChanel(title,mensaje,CHANEL_LOW_ID);
        }
        return this.crearNotififacionWithhoutChannel(title,mensaje);
    }

    private Notification.Builder crearNotificacionWithChanel(String titulo,String mensaje, String chanelId)// mayores o igual android oreo
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            return new Notification.Builder(getApplicationContext(),chanelId)
                    .setContentTitle(titulo)
                    .setContentText(mensaje)
                    .setColor(getColor(R.color.colorPrimary))
                    .setSmallIcon(R.drawable.nuevomsj)
                    .setAutoCancel(true);
        }
        return null;
    }

    private Notification.Builder crearNotififacionWithhoutChannel(String titulo,String mensaje) // anterior a andorid oreo
    {
        return new Notification.Builder(getApplicationContext())
                .setContentTitle(titulo)
                .setContentText(mensaje)
                .setSmallIcon(R.drawable.nuevomsj)
                .setAutoCancel(true);
    }
}
