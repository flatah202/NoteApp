package mf.o.self_educated.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Save_list_note extends AppCompatActivity {

    TextView listShow;
    EditText titleNote , inputNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_list_note);
        listShow = (TextView) findViewById(R.id.listShow);



        listShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listShow.setText("titleNote: "+titleNote.getText());
            }
        });

    }// End of Override


}/// End of Save_list_note claas