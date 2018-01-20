package koppen.jonas.ap.projectbig.Afspraken;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import koppen.jonas.ap.projectbig.R;

/**
 * Created by jonas on 31/10/2017.
 */

public class AfsprakenAdapter extends ArrayAdapter<Appointment> {
    public AfsprakenAdapter(Context context, ArrayList values) {
        super(context, -1, values);
    }

    public View getView(int position,
                        View convertView,
                        ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.afspraken_list, null, false);

        TextView textViewDate = itemView.findViewById(R.id.date);
        String output = String.format("%02d/%02d/%04d",
                getItem(position).getDay(),
                getItem(position).getMonth(),
                getItem(position).getYear());
        textViewDate.setText(output);
        TextView textViewUur = itemView.findViewById(R.id.time);
        output = String.format("%02d:%02d",
                getItem(position).getHour(),
                getItem(position).getMinute());
        textViewUur.setText(output);
        TextView textViewPerson = itemView.findViewById(R.id.person);
        textViewPerson.setText("   "+getItem(position).getContactName());
        TextView textViewLoc = itemView.findViewById(R.id.location);
        textViewLoc.setText("   "+getItem(position).getLocation());
        ImageView imgPerson = (ImageView) itemView.findViewById(R.id.picture);
        imgPerson.setImageResource(getItem(position).getPicture());
        return itemView;
    }

}
