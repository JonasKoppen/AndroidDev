package koppen.jonas.ap.projectbig.Fibonnaci;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fibonacci);
        int size = 10000;
        final FiboItem[] listf = new FiboItem[size];
        for(int i= 0; i < size; i++){
            listf[i] = new FiboItem(i);
        }
        ListView fiboListView = (ListView) findViewById(R.id.fibonacci_list_view);
        fiboListView.setAdapter(new FibonacciAdapterhi(this,listf));
        fiboListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                CharSequence text = listf[i].toString();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        /*
        int size = 25;
        final Double[] arr = new Double[size];
        for(int i = 0; i< size; i++){
            arr[i] = fibonacci(i);
        }

        ListView fiboListView = (ListView) findViewById(R.id.fibonacci_list_view);
        fiboListView.setAdapter(new FibonacciAdapter(this,arr));
        fiboListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                CharSequence text = arr[i].toString();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        */

    }


    public double fibonacci(double num){
        Log.i("getal,",Double.toString(num));
        if(num < 2){
            return 1;
        }
        else {
            return fibonacci(num - 2) + fibonacci(num -1);
        }
    }
}
