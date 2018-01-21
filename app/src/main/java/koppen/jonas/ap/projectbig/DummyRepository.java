package koppen.jonas.ap.projectbig;

import java.util.ArrayList;
import java.util.List;

import koppen.jonas.ap.projectbig.ResistorCalc.*;

/**
 * Created by Viktor on 13-12-2017.
 */

public class DummyRepository {



    public static List<ActivityItem> getActivitys() {
        List<ActivityItem> activityList = new ArrayList<>();

        activityList.add(new ActivityItem("KleurCode", koppen.jonas.ap.projectbig.ResistorCalc.MainActivity.class));
        activityList.add(new ActivityItem("Afspraken", koppen.jonas.ap.projectbig.Afspraken.MainActivity.class));
        activityList.add(new ActivityItem("ChatApp database firebase", koppen.jonas.ap.projectbig.ChatApp.MainActivity.class));
        activityList.add(new ActivityItem("layouts", koppen.jonas.ap.projectbig.layoutsTest.MainActivity.class));
        activityList.add(new ActivityItem("notification", koppen.jonas.ap.projectbig.notification.MainActivity.class));
        activityList.add(new ActivityItem("lifecyle", koppen.jonas.ap.projectbig.lifeCycle.MainActivity.class));
        activityList.add(new ActivityItem("storrage", koppen.jonas.ap.projectbig.storrage.MainActivity.class));
        activityList.add(new ActivityItem("threas", koppen.jonas.ap.projectbig.threads.MainActivity.class));
        activityList.add(new ActivityItem("Fibonacci", koppen.jonas.ap.projectbig.Fibonnaci.MainActivity.class));
        //activityList.add(new ActivityItem("REALM", koppen.jonas.ap.projectbig.realmStorrage.MainActivity.class));
        return activityList;
    }
}


