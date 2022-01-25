package mf.o.self_educated.NoteApp;

import static mf.o.self_educated.NoteApp.R.menu.setting_options;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class First_page extends AppCompatActivity {

    // All the button in the first page
    private ImageView work , shopping , todo , study, money, monthly , yearly, add;

    public View Ar , En , Lan;
    public Menu am;

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
        add = findViewById(R.id.add_button);
        Ar = findViewById(R.id.Arabic);
        En = findViewById(R.id.English);
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
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_page.this, AddNew_notes.class);
                startActivity(intent);
            }// End of onClick
        });// End of setOnClickListener for add



//        Ar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ChangeLanguage ();
//            }
//        });// End of setOnClickListener for Ar
//
//        En.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ChangeLanguage ("En");
//            }
//        });// End of setOnClickListener for En


    }// End of onCreate(Bundle savedInstanceState)



//    private void ChangeLanguage (String Language){
//
//        Locale locale = new Locale(Language);
//        Locale.setDefault(locale);
//        Configuration configuration = new Configuration();
//        configuration.locale=locale;
//        getApplicationContext().getResources().updateConfiguration(configuration,getApplicationContext().getResources().getDisplayMetrics());
//
//
//
//    }// End of ChangeLanguage class
//









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
                Toast.makeText(this, "All notes are here ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(this, "You have delete it successfully", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }// End of onOptionsItemSelected for Menu






}// End of First_page class
