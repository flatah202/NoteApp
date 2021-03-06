package mf.o.self_educated.NoteApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mf.o.self_educated.NoteApp.databinding.ActivityMainBinding;


public class Work_page extends AppCompatActivity {

    public EditText titleNote , inputNote;
    public TextView result;
    public RecyclerView recyclerView;
    public NotesListAdapter adapter;
    public String ListTitle[]={"One" , "Two" , "Three" , "Four" , "Five" , "Six" , "Seven" , "Nine" , "ten"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_page);
        titleNote = (EditText) findViewById(R.id.note_title);
        inputNote = (EditText) findViewById(R.id.input_notes);
        result  = (TextView) findViewById(R.id.result);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotesListAdapter(this,ListTitle);
        recyclerView.setAdapter(adapter);


    }// End of Override




    // save_button method
    public void save_button (View view){
        String Title = titleNote.getText().toString();
        String Notes = inputNote.getText().toString();
        result.setText("Tile: "+ Title +"\n"+ Notes);



    }// End of save_button method

    public void delete_button(View view){
        titleNote.setText("");
        inputNote.setText("");
        result.setText("");
        result.requestFocus();
    }// End of the delete_button method

}// End of Work_page claas