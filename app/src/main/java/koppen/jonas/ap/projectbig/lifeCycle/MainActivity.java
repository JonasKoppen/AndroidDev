package koppen.jonas.ap.projectbig.lifeCycle;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public int getal;

    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lifecycle);
        edit = findViewById(R.id.editText_Life);
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
        findViewById(R.id.btnlife).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getal ++;
                String tekst = "Getal: " + getal;
                Log.i("MainActivity", tekst);
            }
        });

        edit.setText(loadPreferenceText());
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
        savePreferenceText(edit.getText().toString());
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

    public void savePreferenceText(String in){
        SharedPreferences settings = getSharedPreferences("my_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        // Add changes (mSilentMode is class member here)
        editor.putString("text", in);
        // Commit the edits!
        editor.commit();
    }

    public String loadPreferenceText(){
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        return  preferences.getString("text", null);
    }

    public String loadIntStorrage(){
        FileInputStream fis = null;
        String text;
        try {
            fis = openFileInput("my_internal_file"); // Could throw FileNotFoundException
            byte[] buffer = new byte[100];
            int noBytesRead = fis.read(buffer); // Could throw IOException
            text = new String(buffer, 0, noBytesRead); // Only bytes 0 —> noBytesRead contain meaningful data
        } catch (IOException e) {
            // Something went wrong, file does not exist or could not read from it
            e.printStackTrace();
            text = "empty";
        } finally {
            try {
                if (fis != null) { fis.close(); }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text;
    }

    public void saveIntStorrage(String text){
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("my_internal_file", MODE_PRIVATE); // Could throw file not
            // found
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                    Log.i("save", "complete");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
