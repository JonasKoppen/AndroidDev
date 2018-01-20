package koppen.jonas.ap.projectbig.realmStorrage;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jonas on 20/01/2018.
 */

public class Person extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private RealmList<Dog> dogs; // Declare one-to-many relationships

    // ... Generated getters and setters ...
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    public void setId(long age){this.id = age;}
    public long getId(){return this.id;}

    public RealmList<Dog> getDogs(){return this.dogs;}

}