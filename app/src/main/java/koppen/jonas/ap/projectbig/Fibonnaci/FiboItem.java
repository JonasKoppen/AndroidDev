package koppen.jonas.ap.projectbig.Fibonnaci;

import java.math.BigDecimal;

/**
 * Created by jonas on 21/01/2018.
 */

public class FiboItem {
    private int id;
    private double value;

    //constructor
    public FiboItem(int id){
        this.id = id;
        this.value = 0 ;
    }


    //properties
    public int getId(){return id;}
    public double getValue(){return  value;}

    public void setValue(double in1, double in2){
        value = in1 + in2;
    }
}
