package koppen.jonas.ap.projectbig.threads;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_threads);

        textView = (TextView) findViewById(R.id.test_output);

    }

    public void activateThread(View v){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for
                        (int i =
                         0; i < 100; i++) {
                    try
                    {
                        Thread.sleep
                                (100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final int j = i; // Well this is ugly
                    runOnUiThread(new Runnable() { // And this
                        public void run() {
                            textView.setText(j + " %");
                        }
                    });
                }
                runOnUiThread(new Runnable() { // And this
                    public void run() {
                        textView.setText("DONE!");
                    }
                });
            }
        });
        t.start();
    }

    public void activateAsyncTask(View v)
    {
        AsyncTask t = new AsyncTask<Void, Integer, String>() {
            @Override
            protected String doInBackground(Void... params) {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(i);
                }
                return "DONE!";
            }
            @Override
            protected void onProgressUpdate(Integer... progress) {
                textView.setText(progress[0] + " %");
            }
            @Override
            protected void onPostExecute(String result) {
                textView.setText(result);
            }
        };
        t.execute(new String[] { textView.getText().toString() }); // Voor labo 5
    }
}
