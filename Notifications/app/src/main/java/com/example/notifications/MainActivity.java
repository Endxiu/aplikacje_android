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
                        .setContentTitle("I remember you was conflicted")
                        .setContentText("Misusing your influence\n"+"Sometimes I did the same\n")
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
                        .setContentTitle("I remember you was conflicted")
                        .setContentText("Misusing your influence")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Misusing your influence\n" +
                                "Sometimes I did the same\n" +
                                "Abusing my power, full of resentment\n" +
                                "Resentment that turned into a deep depression\n" +
                                "Found myself screaming in the hotel room\n" +
                                "I didn’t wanna self destruct\n" +
                                "The evils of Lucy was all around me\n" +
                                "So I went running for answers\n" +
                                "Until I came home\n" +
                                "But that didn’t stop survivor’s guilt\n" +
                                "Going back and forth trying to convince myself the stripes I earned\n" +
                                "Or maybe how A-1 my foundation was\n" +
                                "But while my loved ones was fighting the continuous war back in the city, I was entering a new one\n" +
                                "A war that was based on apartheid and discrimination\n" +
                                "Made me wanna go back to the city and tell the homies what I learned\n" +
                                "The word was respect\n" +
                                "Just because you wore a different gang color than mine's\n" +
                                "Doesn’t mean I can’t respect you as a black man\n" +
                                "Forgetting all the pain and hurt we caused each other in these streets\n" +
                                "If I respect you, we unify and stop the enemy from killing us\n" +
                                "But I don’t know, I’m no mortal man, maybe I’m just another nigga"))
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