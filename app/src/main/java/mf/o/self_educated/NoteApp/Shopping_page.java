package mf.o.self_educated.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Shopping_page extends AppCompatActivity {

    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_page);
        input = findViewById(R.id.input);



    }// End of onCreate


}// End of Shopping_page class