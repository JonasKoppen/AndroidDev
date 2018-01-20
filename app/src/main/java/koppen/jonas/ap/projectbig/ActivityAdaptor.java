package koppen.jonas.ap.projectbig;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import koppen.jonas.ap.projectbig.ResistorCalc.ResistorCalcBtnValue;

/**
 * Created by jonas on 16/12/2017.
 */

public class ActivityAdaptor extends ArrayAdapter<ResistorCalcBtnValue> {
    public ActivityAdaptor(Context context, ArrayList values) {
        super(context,-1, values);
    }

    public View getView(int position,
                        View convertView,
                        ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.resistor_calc_list, null, false);
        ((TextView)itemView.findViewById(R.id.btnCalcItem)).setBackgroundColor(ContextCompat.getColor(getContext(), getItem(position).getColorCode()));
        ((TextView)itemView.findViewById(R.id.btnCalcItem)).setText( "\n");
        return itemView;
    }
}
