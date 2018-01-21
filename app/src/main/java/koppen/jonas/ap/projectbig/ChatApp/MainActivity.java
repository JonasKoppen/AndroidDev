package koppen.jonas.ap.projectbig.ChatApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import koppen.jonas.ap.projectbig.R;

public class MainActivity extends AppCompatActivity {

    EditText editInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        editInput = findViewById(R.id.editInputChat);
        setValue("hi");
        ((Button)findViewById(R.id.btnEnterChat)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(editInput.getText().toString());
                editInput.setText("");
            }
        });
    }

    public void setValue(String value){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue(value);

    }

    public void getValue(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

    }
}
