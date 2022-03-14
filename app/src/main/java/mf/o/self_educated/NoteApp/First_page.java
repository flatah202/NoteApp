package mf.o.self_educated.NoteApp;

import static android.widget.Toast.LENGTH_SHORT;
import static mf.o.self_educated.NoteApp.R.menu.setting_options;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class First_page extends AppCompatActivity {

    // All the button in the first page
    private Button work , shopping , todo , study, money, monthly , yearly, add;

    public View Lan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
    }//End of onCreate(Bundle savedInstanceState)



    //WorkButton method
    public void workButton (View view){
        Intent workButton = new Intent(First_page.this, Work_page.class);
        startActivity(workButton);
    }// End of workButton method


    //ShoppingButton method
    public void shoppingButton(View view){
        Intent shoppingButton  =  new Intent(First_page.this, Shopping_page.class);
        startActivity(shoppingButton);

    }// End of shoppingButton method



    // todoButton method
    public void todoButton (View view){
        Intent todoButton = new Intent(First_page.this, Todo_page.class);
        startActivity(todoButton);
    }// End of todoButton method


    //StudyButton method
    public void studyButton(View view){
        Intent studyButton = new Intent(First_page.this, Study_page.class);
        startActivity(studyButton);
    }// End of StudyButton method


    //MonthlyGoalButton method
    public void monthlyGoalButton (View view){
        Intent monthlyGoalButton = new Intent(First_page.this , Monthly_page.class);
        startActivity(monthlyGoalButton);
    }// End of monthlyGoalButton method

    //yearlyGoalButton method
    public void yearlyGoalButton (View view){
        Intent yearlyGoalButton = new Intent(First_page.this , Yearly_page.class);
        startActivity(yearlyGoalButton);
    }// End of yearlyGoalButton method



    //FinancialButton method
    public void FinancialButton (View view){
        Intent FinancialButton = new Intent(First_page.this , Money_page.class);
        startActivity(FinancialButton);
    }// End of the FinancialButton method


    //addButton method
    public void addButton (View view){
        Intent addButton = new Intent(First_page.this , AddNew_notes.class);
        startActivity(addButton);
    }






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
                Toast.makeText(this, getString(R.string.message_show_all), LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(this,  getString(R.string.message_delete), LENGTH_SHORT).show();
             return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }// End of onOptionsItemSelected for Menu






}// End of First_page class
