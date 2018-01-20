package koppen.jonas.ap.projectbig.Afspraken;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {
    String TAG ="hi";
    ListView listViewAfspraken;
    ArrayList<Appointment> afspraken;
    TextView banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_afspraken);
        afspraken = AppointmentDummyRepository.getInstance().getAppointments();
        checkList();
        listViewAfspraken = findViewById(R.id.listViewAfspraken);
        listViewAfspraken.setAdapter(new AfsprakenAdapter(this, afspraken));
        banner = findViewById(R.id.banner);
        banner.setText("Your next appointment with " + afspraken.get(0).toString());
        listViewAfspraken.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                showDetails(afspraken.get(position).getId());
            }
        });
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetails(afspraken.get(0).getId());
            }
        });
    }

    protected void showDetails(int position){
        Intent detail = new Intent(MainActivity.this, DetailActivity.class);
        detail.putExtra("position", position);
        startActivity(detail);
    }

    private void checkList(){ //Checkt of de lijst up to date is met de tijd
        Calendar rightNow = Calendar.getInstance();
        Iterator<Appointment> i = afspraken.iterator();
        while (i.hasNext()) {
            Appointment afspraak = i.next();
            if(rightNow.after(afspraak.getDate())){
                i.remove();
                //Log.i(TAG, "Appointment removed: ");
            }
            //Log.i(TAG, rightNow.after(afspraak.getDate()) ? "true":"false");
        }
    }
}
