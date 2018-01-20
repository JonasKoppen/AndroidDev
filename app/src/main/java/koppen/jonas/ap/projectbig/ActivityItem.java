package koppen.jonas.ap.projectbig;

/**
 * Created by Viktor on 13-12-2017.
 */

public class ActivityItem {
    private String name;
    private Class klasse; //added by jonas, remove comment when viewed

    //constructor
    public ActivityItem(String name, Class klasse){
        this.name = name;
        this.klasse = klasse;
    }


    //properties
    public String getName(){return name;}
    public Class getKlasse(){return  klasse;}
}
