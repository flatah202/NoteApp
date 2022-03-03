package mf.o.self_educated.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PublicKey;

public class Work_page extends AppCompatActivity {

    public EditText titleNote , inputNote;
    public TextView save_show;
    public Button save;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_page);
        titleNote = (EditText) findViewById(R.id.note_title);
//        inputNote= (EditText) findViewById(R.id.input_note);
        save = (Button) findViewById(R.id.save_notes);
        save_show = (TextView) findViewById(R.id.save_show);



        //
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                save_show.setText("Title Note: "+titleNote.getText());


            }
        });


    }// End of Override



}// End of Work_page claas