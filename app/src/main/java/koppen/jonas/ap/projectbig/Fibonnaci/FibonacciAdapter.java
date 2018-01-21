package koppen.jonas.ap.projectbig.Fibonnaci;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import koppen.jonas.ap.projectbig.R;

public class FibonacciAdapter extends ArrayAdapter<Double> {

    public FibonacciAdapter(Context context, Double[] arr) {
        super(context, -1, arr);
    }
    /*
    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(
                R.layout.fibonacci_list_item, null);

        TextView textView = (TextView)
                view.findViewById(R.id.fibonacci_list_entry);
        textView.setText(Double.toString(getItem(position)));

        ImageView imageView = (ImageView)
                view.findViewById(R.id.fibonacci_list_entry_image);
        boolean numberIsEven = getItem(position) % 2 == 0;
        imageView.setImageResource(numberIsEven ? R.drawable.even
                                            : R.drawable.odd);
        return view;
    }
    */

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

        TextView textView = (TextView)
                view.findViewById(R.id.fibonacci_list_entry);
        textView.setText(Double.toString(getItem(position)));

        ImageView imageView = (ImageView)
                view.findViewById(R.id.fibonacci_list_entry_image);
        boolean numberIsEven = getItem(position) % 2 == 0;
        imageView.setImageResource(numberIsEven ? R.drawable.even
                : R.drawable.odd);
        return view;
    }

}
