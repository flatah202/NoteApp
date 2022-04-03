package mf.o.self_educated.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Study_page extends AppCompatActivity {

    public Button start , stop , rest;
    public TextView timer ;
    public EditText input_timer;


    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mStartTimeInMillis;
    private long mTimeLeftInMillis;
    private long mEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_page);
        timer = (TextView) findViewById(R.id.timer);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        rest = (Button) findViewById(R.id.set);
        input_timer = (EditText) findViewById(R.id.input_timer);
    } // End of Override onCreate









    public void set_button(View view) {

        String input = input_timer.getText().toString();
        if (input.length() == 0) {
            Toast.makeText(Study_page.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        long millisInput = Long.parseLong(input) * 60000;
        if (millisInput == 0) {
            Toast.makeText(Study_page.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
            return;
        }


        setTime(millisInput);
        input_timer.setText("");
    }// End of set_button method


    public void Stop_button(View view) {

        if (mTimerRunning) {
            pauseTimer();
        } else {
            startTimer();
            closeKeyboard();
        }

    }// End of Stop_button mehtod

    public void Start_button (View view) {

        resetTimer();

    }// End of Start_button method




    private void setTime(long milliseconds) {

        mStartTimeInMillis = milliseconds;
        resetTimer();

    }// End of setTime method



    private void closeKeyboard() {

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }// End of closeKeyboard method


    private void startTimer() {

        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
    @Override
      public void onTick(long millisUntilFinished) {
        mTimeLeftInMillis = millisUntilFinished;
        updateCountDownText();
        }

        @Override
     public void onFinish() {
        mTimerRunning = false;
        updateWatchInterface();
        }
        }.start();

        mTimerRunning = true;
        updateWatchInterface();

    }// End of startTimer method


    private void pauseTimer() {

        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();


    }// End of pauseTimer

private void resetTimer() {

        mTimeLeftInMillis = mStartTimeInMillis;
        updateCountDownText();
        updateWatchInterface();


        }// End of resetTimer method



    private void updateWatchInterface() {


        if (mTimerRunning) {
            input_timer.setVisibility(View.INVISIBLE);
            rest.setVisibility(View.INVISIBLE);
            start.setVisibility(View.INVISIBLE);
            stop.setText("Pause");
        } else {
            input_timer.setVisibility(View.VISIBLE);
            rest.setVisibility(View.VISIBLE);
            stop.setText("Start");

            if (mTimeLeftInMillis < 1000) {
                stop.setVisibility(View.INVISIBLE);
            } else {
                stop.setVisibility(View.VISIBLE);
            }

            if (mTimeLeftInMillis < mStartTimeInMillis) {
                start.setVisibility(View.VISIBLE);
            } else {
                start.setVisibility(View.INVISIBLE);
            }
        }

    }// End of updateWatchInterface




    private void updateCountDownText() {

        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted;
        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }

        timer.setText(timeLeftFormatted);
    }// End of updateCountDownText




    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("startTimeInMillis", mStartTimeInMillis);
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }// End of onStop Override




    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        mStartTimeInMillis = prefs.getLong("startTimeInMillis", 600000);
        mTimeLeftInMillis = prefs.getLong("millisLeft", mStartTimeInMillis);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateWatchInterface();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
                updateWatchInterface();
            } else {
                startTimer();
            }
        }
    }// end of onStart Override







}// End of Study_page calls