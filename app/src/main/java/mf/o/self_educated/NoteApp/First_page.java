package mf.o.self_educated.NoteApp;

import static mf.o.self_educated.NoteApp.R.menu.setting_options;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class First_page extends AppCompatActivity {

    // All the button in the first page
    private Button work , shopping , todo , study, money, monthly , yearly, add;

    public View Lan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        work = findViewById(R.id.work_button);
        shopping = findViewById(R.id.shopping_button);
        todo = findViewById(R.id.todo_button);
        study = findViewById(R.id.study_button);
        money = findViewById(R.id.money_button);
        monthly = findViewById(R.id.monthly_button);
        yearly = findViewById(R.id.yearly_button);
        Lan = findViewById(R.id.language);






//      work button move to
        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(First_page.this,Work_page.class);
                startActivity(intent);
            }// End of onClick
        });// End of setOnClickListener for work



        //shopping button move to
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_page.this,Shopping_page.class);
                startActivity(intent);
            } // End of onClick
        }); // End of setOnClickListener for shopping


        //   TO DO button move to
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(First_page.this, Todo_page.class);
                startActivity(intent);
            } // End of onClick
        }); // End of setOnClickListener for  to do


//         study buttcon move to
        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_page.this, Study_page.class);
                startActivity(intent);
            }// End of onClick
        });// End of setOnClickListener for study


        //monthly button move to
        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_page.this, Monthly_page.class);
                startActivity(intent);
            }// End of onClick
        });// End of setOnClickListener for monthly


        //yearly button move to
        yearly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_page.this, Yearly_page.class);
                startActivity(intent);
            }// End of onClick
        }); // End of setOnClickListener for yearly



        //money button move to
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_page.this,Money_page.class);
                startActivity(intent);
            }// End of onClick
        });// End of setOnClickListener for money



        //Add button move to











    }// End of onCreate(Bundle savedInstanceState)














    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(setting_options,menu);
        return true;
    }// End of the onCreateOptionsMenu menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_all:
                Toast.makeText(this, getString(R.string.message_show_all), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(this,  getString(R.string.message_delete),Toast.LENGTH_SHORT).show();
             return true;
            case R.id.Arabic_button:
                LocalHelper.setLocale(this,"ar");//for french;


                return true;
            case R.id.English_button:
                LocalHelper.setLocale(this,"en-rUS");//for french;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }// End of onOptionsItemSelected for Menu






}// End of First_page class
