package koppen.jonas.ap.projectbig.Fibonnaci;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import koppen.jonas.ap.projectbig.R;

/**
 * Created by jonas on 21/01/2018.
 */

public class FibonacciAdapterhi extends ArrayAdapter<FiboItem> {
    public FibonacciAdapterhi(Context context, FiboItem[] arr) {
        super(context, -1, arr);
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        Log.i("FibonacciAdapter", "Getview " + position);

        View view = null;
        if (convertView != null) {
            view = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(
                    R.layout.fibonacci_list_item, null);
        }

        if(position < 2){
            getItem(position).setValue(0,1);
        }
        else {
            getItem(position).setValue(getItem(position-2).getValue(),getItem(position-1).getValue());
        }

        TextView textView = (TextView)
                view.findViewById(R.id.fibonacci_list_entry);
        textView.setText( Double.toString(getItem(position).getValue()));

        ImageView imageView = (ImageView)
                view.findViewById(R.id.fibonacci_list_entry_image);
        boolean numberIsEven = getItem(position).getValue() % 2 == 0;
        imageView.setImageResource(numberIsEven ? R.drawable.even
                : R.drawable.odd);
        return view;
    }

}
