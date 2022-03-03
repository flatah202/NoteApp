package mf.o.self_educated.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Shopping_page extends AppCompatActivity {

    EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_page);
        input = findViewById(R.id.input);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Shopping_page.this, "Hello world", Toast.LENGTH_SHORT).show();
            }
        });


    }// End of onCreate


}// End of Shopping_page class