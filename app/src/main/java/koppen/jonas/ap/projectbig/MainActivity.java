package koppen.jonas.ap.projectbig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import koppen.jonas.ap.projectbig.ResistorCalc.CalculatorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DummyRepository dummyRepository = new DummyRepository();
        final List<ActivityItem> activityItemList = dummyRepository.getActivitys();

        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(new ActivityAdaptor(this, activityItemList));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startNewClass(position);
            }
        });



    }

    public void startNewClass(int position){
        ActivityItem tmp = DummyRepository.getActivitys().get(position);
        Intent detail = new Intent(MainActivity.this, tmp.getKlasse());
        startActivity(detail);
    }
}
