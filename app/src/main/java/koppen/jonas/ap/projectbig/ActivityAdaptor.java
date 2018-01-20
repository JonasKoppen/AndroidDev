package koppen.jonas.ap.projectbig;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import koppen.jonas.ap.projectbig.ResistorCalc.Calculator;
import koppen.jonas.ap.projectbig.ResistorCalc.ResistorCalcBtnValue;

/**
 * Created by jonas on 16/12/2017.
 */

public class ActivityAdaptor extends ArrayAdapter<ActivityItem> {
    public ActivityAdaptor(Context context, List<ActivityItem> appointments)  {
        super(context, -1, appointments);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_listview, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.icon);
        TextView textView = (TextView)view.findViewById(R.id.name);

        textView.setText(getItem(position).getName());

        return view;
    }
}
