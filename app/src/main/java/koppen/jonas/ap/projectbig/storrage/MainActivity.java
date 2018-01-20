package koppen.jonas.ap.projectbig.storrage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Nullable;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmResults;
import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {

    EditText wishList;

    Realm realm;
    WhishList wishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wishes = new WhishList();
        setContentView(R.layout.activity_main_storrage);
        wishList = (EditText) findViewById(R.id.editWishList);

        loadList(findViewById(R.id.btnSave));

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

    public void saveList(View v){
        saveListFile();
    }

    public void saveListPref(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("saved_list):", wishList.getText().toString());
        editor.apply();
    }

    public void saveListFile(){
        FileOutputStream fos = null;
        try{
            fos = openFileOutput("wishlist", MODE_PRIVATE);
            fos.write(wishList.getText().toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"save error: fnf",Toast.LENGTH_LONG).show();
        } finally {
            Toast.makeText(MainActivity.this,"Save complete",Toast.LENGTH_LONG).show();
            try {

                if (fos != null){fos.close();}
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }


    public void loadList(View v){
        loadListFile();
    }

    public void loadListPref(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        wishList.setText(preferences.getString("saved_list", "Enter Items Here"));
    }

    public void loadListFile(){
        FileInputStream fis = null;
        String tekst = "";
        try{
            fis = openFileInput("wishlist");
            byte[] buffer = new byte[100];
            int noBytesRead = fis.read(buffer);
            tekst = new String(buffer,0,noBytesRead);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"Load error: fnf",Toast.LENGTH_LONG).show();
        } finally {
            try{
                if(fis != null) {fis.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }Toast.makeText(MainActivity.this,"Load Complete",Toast.LENGTH_LONG).show();
        wishList.setText(tekst);
    }

}
