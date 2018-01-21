package koppen.jonas.ap.projectbig.Fibonnaci;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import koppen.jonas.ap.projectbig.R;

/**
 * Created by jonas on 21/01/2018.
 */

public class FibonnacciBase extends BaseAdapter {
    Context context;
    int size;

    public FibonnacciBase(Context context, int size){
        this.size = size;
        this.context = context;
    }
    @Override
    public int getCount() {
        return size;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.fibonacci_list_item, parent, false);

        TextView t = (TextView)convertView.findViewById(R.id.fibonacci_list_entry);

        double Phi = (Math.sqrt(5)+1)/2;
        double Fibn = (Math.pow(Phi, position)-(-Math.pow(Phi,-position)))/ Math.sqrt(5);

        Log.i("IETS", ""+Fibn);

        t.setText("fib"+position+":"+Fibn);

        return convertView;
    }
}
