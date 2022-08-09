package com.justfriends;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.justfriends.activity.MainActivity;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.SendBirdPushHandler;
import com.sendbird.android.SendBirdPushHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicReference;

public class MyFirebaseMessagingService extends SendBirdPushHandler {

    private static final String FIRE = "MyFirebaseMsgService";
    private static final AtomicReference<String> pushToken = new AtomicReference<>();

    public interface ITokenResult {
        void onPushTokenReceived(String pushToken, SendBirdException e);
    }

    @Override
    public void onNewToken(String token) {
        pushToken.set(token);
    }

    // Invoked when a notification message has been delivered to the current user's client app.
    @Override
    public void onMessageReceived(Context context, RemoteMessage remoteMessage) {
        String channelUrl = null;
        try {
            if (remoteMessage.getData().containsKey("sendbird")) {
                JSONObject sendbird = new JSONObject(remoteMessage.getData().get("sendbird"));
                JSONObject channel = (JSONObject) sendbird.get("channel");
                channelUrl = (String) channel.get("channel_url");

                // If you want to customize a notification with the received FCM message,
                // write your method like the sendNotification() below.
                sendNotification(context, remoteMessage.getData().get("push_title"), remoteMessage.getData().get("message"), channelUrl);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean isUniquePushToken() {
        return false;
    }

    // alwaysReceiveMessage() determines whether push notifications for new messages
    // will be delivered even when the app is in foreground.
    // The default is false, meaning push notifications will be delivered
    // only when the app is in the background.
    @Override
    protected boolean alwaysReceiveMessage() {
        return true;
    }


    public void sendNotification(Context context, String messageTitle, String messageBody, String channelUrl) {
        // Implement your own way to create and show a notification containing the received HMS message.
        Intent intent
                = new Intent(context,
                MainActivity.class);
//
//            PendingIntent pendingIntent
//                    = PendingIntent.getActivity(
//                    context, 0, intent,
//                    PendingIntent.FLAG_IMMUTABLE);



        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context, channelUrl)
                        .setSmallIcon(R.drawable.ic_just_friend)
                        .setColor(Color.parseColor("#7469C4"))  // small icon background color
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.img_just_friends))
                        .setContentTitle(messageTitle)
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setDefaults(Notification.DEFAULT_ALL);
        Log.d(FIRE, messageBody);
        notificationBuilder = notificationBuilder.setContent(
                getCustomDesign(context, messageTitle, messageBody));
        // Create an object of NotificationManager class to
        // notify the
        // user of events that happen in the background.
        NotificationManager notificationManager
                = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE);
        // Check if the Android Version is greater than Oreo
        if (Build.VERSION.SDK_INT
                >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel
                    = new NotificationChannel(
                    channelUrl, "web_app",
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(
                    notificationChannel);
        }

        notificationManager.notify(0, notificationBuilder.build());
    }


    public static void getPushToken(ITokenResult listener) {
        String token = pushToken.get();
        if (!TextUtils.isEmpty(token)) {
            listener.onPushTokenReceived(token, null);
            return;
        }

        SendBirdPushHelper.getPushToken((newToken, e) -> {
            if (listener != null) {
                listener.onPushTokenReceived(newToken, e);
            }

            if (e == null) {
                pushToken.set(newToken);
            }
        });
    }

    private RemoteViews getCustomDesign(Context context, String title,
                                        String message) {
        @SuppressLint("RemoteViewLayout") RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.notification);
        remoteViews.setTextViewText(R.id.title, title);
        remoteViews.setTextViewText(R.id.message, message);
        remoteViews.setImageViewResource(R.id.icon,
                R.drawable.ic_app_icon);
        return remoteViews;
    }
}
