package mf.o.self_educated.NoteApp;

import static android.graphics.ColorSpace.Model.XYZ;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Language_page extends AppCompatActivity {

    Button ar , en;
    TextView changed;
    Context context;
    Resources resources;
    private Button work , shopping , todo , study, money, monthly , yearly;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_page);
        ar = findViewById(R.id.Arabic_button);
        en = findViewById(R.id.English_button);
        changed = findViewById(R.id.changed);
        work = findViewById(R.id.work_button);
        shopping = findViewById(R.id.shopping_button);
        todo = findViewById(R.id.todo_button);
        study = findViewById(R.id.study_button);
        money = findViewById(R.id.money_button);
        monthly = findViewById(R.id.monthly_button);
        yearly = findViewById(R.id.yearly_button);




    }// End of onCreate



}// End of Language_page class