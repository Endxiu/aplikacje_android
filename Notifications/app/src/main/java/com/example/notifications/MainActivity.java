package com.example.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "my_chanel_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button.setOnClickListener(v->{
            sendNotification();
        });
        button2.setOnClickListener(v->{
            sendNotificationLong();
        });
        button3.setOnClickListener(v->{
            sendNotificationIMG();
        });
    }
    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Kanał powiadomień";
            String description = "Opis kanału powiadomień";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }
    private void sendNotification(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS},1);
                return;
            }
        }

        Intent intent = new Intent(MainActivity.this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.blank)
                        .setContentTitle("Powiadomienie krótkie")
                        .setContentText("I can't wait for you to shut me up\n" + "and make me hip like badass")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(1,builder.build());
    }
    private void sendNotificationLong(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS},1);
                return;
            }
        }

        Intent intent = new Intent(MainActivity.this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.gnx)
                        .setContentTitle("Powiadomienie długie")
                        .setContentText("Msi Shut me up!")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Msi Shut me up!\n" +
                                "The bass, the rock, the mic, the treble\n" +
                                "I like my coffee black, just like my metal\n" +
                                "With the bass, the rock, the mic, the treble\n" +
                                "I like my coffee black just like my metal\n" +
                                "Cause I can't wait for you to knock me up\n" +
                                "In a minute, minute, in a fuckin' minute\n" +
                                "I can't wait for you to knock me up\n" +
                                "In a minute, minute, in a second\n" +
                                "I can't wait for you to shut me up and make me hip like badass\n" +
                                "I can't wait for you to shut me up\n" +
                                "Shut it up\n" +
                                "I can't wait for you to shut me up and make me hip like badass\n" +
                                "I can't wait for you to shut me up\n" +
                                "Shut it up\n" +
                                "La, la, la\n" +
                                "(Ooh) la, la, la\n" +
                                "(Ooh) la, la, la\n" +
                                "(Ooh)\n" +
                                "The bass, the rock, the mic, the treble\n" +
                                "I like my coffee black, just like my metal\n" +
                                "With the bass, the rock, the mic, the treble\n" +
                                "I like my coffee black just like my metal\n" +
                                "Cause I can't wait for you to nock me up\n" +
                                "In a minute, minute, in a fuckin' minute\n" +
                                "I can't wait for you to nock me up\n" +
                                "In a minute, minute, in a second\n"))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(1,builder.build());
    }
    private void sendNotificationIMG(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hweir);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS},1);
                return;
            }
        }

        Intent intent = new Intent(MainActivity.this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.hweir)
                        .setContentTitle("SEE AS I SEE")
                        .setContentText("FEEL WITH ME")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(1,builder.build());
    }
}