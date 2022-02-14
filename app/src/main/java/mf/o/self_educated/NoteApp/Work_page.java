package mf.o.self_educated.NoteApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Work_page extends AppCompatActivity {

    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_page);
        input = findViewById(R.id.input);



    }// End of onCreate


}// End of Work_page class