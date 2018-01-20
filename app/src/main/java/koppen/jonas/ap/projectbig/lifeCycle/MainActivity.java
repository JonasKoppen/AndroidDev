package koppen.jonas.ap.projectbig.lifeCycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public int getal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lifecycle);
        Log.i(TAG, "onCreate");
        if(savedInstanceState != null) {
            int inGetal = savedInstanceState.getInt("getal", -1);
            if (inGetal != -1) {
                getal = inGetal;
            }
        }
        else {
            getal = 0;
        }
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getal ++;
                String tekst = "Getal: " + getal;
                Log.i("MainActivity", tekst);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    protected void onResume(){
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    protected void onStop(){
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }


    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("getal", getal);
        Log.i(TAG, "onSaved()");
    }

    protected void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);
        Log.i(TAG, "onRestore()");
    }
}
