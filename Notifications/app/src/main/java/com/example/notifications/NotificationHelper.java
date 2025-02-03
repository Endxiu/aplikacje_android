package com.example.notifications;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import java.security.PublicKey;

public class NotificationHelper {
    private static final String CHANEL_ID = "default_channel";
    private static final String CHANEL_NAME = "Kanał Powiadomień";
    private static final int NOTIFICATION_ID = 1;


    public static void setNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(activity, android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity,
                        new String[]{android.Manifest.permission.POST_NOTIFICATIONS},
                        1);
                return;
            }
        }
        NotificationManager notificationManager = (NotificationManager)
                activity.getSystemService(activity.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.0) {
            NotificationChannel channel = new NotificationChannel(CHANEL_ID,
                    CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(activity, CHANEL_ID)
                        .setSmallIcon(R.drawable.blank)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
