package koppen.jonas.ap.projectbig.Afspraken;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import koppen.jonas.ap.projectbig.R;

/**
 * Created by jonas on 31/10/2017.
 */

public class DetailActivity extends AppCompatActivity { //TODO af te werken
    Appointment appointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int position = getIntent().getIntExtra("position", 0);
        appointment = AppointmentDummyRepository.getInstance().getAppointments().get(position);

        setContentView(R.layout.afspraak_detail);
        ((TextView)findViewById(R.id.person)).setText(appointment.getContactName());
        ((TextView)findViewById(R.id.tijd)).setText(String.format("%02d/%02d/%04d\t%02d:%02d",
                appointment.getDay(),
                appointment.getMonth(),
                appointment.getYear(),
                appointment.getHour(),
                appointment.getMinute()));
        TextView location = (TextView)findViewById(R.id.location);
        location.setText(
                appointment.getLocation());
        ((TextView)findViewById(R.id.reason)).setText(appointment.getReason());
        ImageView tmpPicture = (ImageView)findViewById(R.id.detail_picture);
        tmpPicture.setImageResource(appointment.getPicture());

    }

    public void showMap(View v){
        Uri gmIntentUri = Uri.parse(appointment.getGeoLocation());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if(mapIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mapIntent);
        }
    }
}
