package koppen.jonas.ap.projectbig.storrage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    Thread t;
    Context hi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wishes = new WhishList();
        setContentView(R.layout.activity_main_storrage);
        wishList = (EditText) findViewById(R.id.editWishList);
        this.hi = this;

        loadList(findViewById(R.id.btnSave));
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] items = wishList.getText().toString().split("\n");
                for (int i = 0; i < 100; i++) {
                    List<String> listItems = Arrays.asList(items);
                    Collections.shuffle(listItems);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final int j = i; // Well this is ugly
                    runOnUiThread(new Runnable() { // And this
                        public void run() {
                            wishList.setText(j + " %");
                        }
                    });
                    String[] shuffledItems = new String[listItems.size()];
                    listItems.toArray(shuffledItems);
                    String progress = TextUtils.join("\n", shuffledItems);
                    // TODO publish progress
                    items = shuffledItems;
                }
                final String[] result = items;
                runOnUiThread(new Runnable() { // And this
                    public void run() {
                        Toast toast = Toast.makeText(hi, "Done", Toast.LENGTH_SHORT);
                        toast.show();
                        wishList.setText(TextUtils.join("\n", result));
                        saveListFile(TextUtils.join("\n", result));
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

    public void saveList(View v){
        saveListFile(wishList.getText().toString());
    }

    public void saveListPref(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("saved_list):", wishList.getText().toString());
        editor.apply();
    }

    public void saveListFile(String input){
        FileOutputStream fos = null;
        try{
            fos = openFileOutput("wishlist", MODE_PRIVATE);
            fos.write(input.getBytes());
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


    public void randomList(View v){
        t.start();
    }
}
