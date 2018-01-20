package koppen.jonas.ap.projectbig.layoutsTest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;import koppen.jonas.ap.projectbig.R;import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    /*
    CheckBox ckbIn;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.txvState);
        findViewById(R.id.ckbSetState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean c = ((CheckBox) v).isChecked();
                txtView.setText(c ? "ON" : "OFF);
                txtView.setTextColor(c ? Color.GREEN : Color.RED);
                if (c.isChecked()) {
                    txtView.setText("ON");
                    txtView.setTextColor(Color.GREEN);
                } else {
                    txtView.setText("OFF");
                    txtView.setTextColor(Color.RED);
                }
            }
        });
    }
    */
    CalendarView cal;
    TextView txtOut;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayoutoef);
        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calenDer();
            }
        });
    }

    public void calenDer(){
        setContentView(R.layout.calender);
        txtOut = (TextView) findViewById(R.id.textView) ;
        cal = (CalendarView) findViewById(R.id.calendarJ);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String out = "";
                out = dayOfMonth + "/" + (month+1) + "/" + year;
                txtOut.setText(out);

            }
        });
        findViewById(R.id.btnnext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonplay();
            }
        });
    }

    TextView txtLocOut;
    public void buttonplay(){
        setContentView(R.layout.buttomsup);
        txtLocOut = (TextView) findViewById(R.id.txtLocOut);
        txtLocOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testgrid();
            }
        });
    }

    public void setLoc(View v){
        Button b = (Button) v;
        txtLocOut.setText(b.getText());
    }

    public void testgrid(){
        setContentView(R.layout.testgridfinal);
    }

    public void playButton(){
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.txvState);
        findViewById(R.id.ckbSetState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean c = ((CheckBox) v).isChecked();
                txtView.setText(c ? "ON" : "OFF");
                        txtView.setTextColor(c ? Color.GREEN : Color.RED);
                if (c) {
                    txtView.setText("ON");
                    txtView.setTextColor(Color.GREEN);
                } else {
                    txtView.setText("OFF");
                    txtView.setTextColor(Color.RED);
                }
            }
        });
    }


}
