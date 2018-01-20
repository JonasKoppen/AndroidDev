package koppen.jonas.ap.projectbig.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {
    public static final int notID = 001;
    public static final int Request_Code_Notification = 1;
    public static final String CHANNEL_ID = "my_channel_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notification);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyMe();
            }
        });
    }

    public void notifyMe() {

        Intent resultIntent = new Intent(this, DetailActivity.class);



        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                this,
                Request_Code_Notification,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        //Notification.Action action = new Notification.Action.Builder(R.drawable.add_icon, "Much Action", resultPendingIntent).build();
        Notification.Builder mBuilder =
                new Notification.Builder(this)    //for back navigation in the app
                        .setContentTitle("Very notification")
                        .setContentText("Much detail")
                        .setSmallIcon(R.drawable.android_icon)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                getResources(),
                                R.drawable.doge_n
                        ))
                        .addAction(R.drawable.add_icon
                                ,"Much Action"
                                , resultPendingIntent
                        );

        Notification not = mBuilder.build();
        manager.notify(notID, not);

    }

}
