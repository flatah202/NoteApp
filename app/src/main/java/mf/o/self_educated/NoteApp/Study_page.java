package mf.o.self_educated.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Study_page extends AppCompatActivity {




    private long timeCountInMilliSeconds = 1 * 60000;


    public CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {

        public void onTick(long millisUntilFinished) {

            textTimer.setText("Seconds Remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() {

            textTimer.setText("Time Up!");

        }
    };


    private TimerStatus timerStatus = TimerStatus.STOPPED;
    private ProgressBar progressBarCircle;
    private EditText editTextMinute;
    private TextView textTimer;
    private ImageView buttonReset;
    private ImageView buttonStartStop;




    private enum TimerStatus {
        STARTED,
        STOPPED
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_page);

        // method call to initialize the views
        initViews();
        // method call to initialize the listeners
        initListeners();


    }// End of Override onCreate method





    /**
     * this is the method going to initialize the View
     *
     */

    private void initViews() {
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);
        editTextMinute = (EditText) findViewById(R.id.inputTimer);
        textTimer =  (TextView) findViewById(R.id.timer);
        buttonReset = (ImageView) findViewById(R.id.buttonReset);
        buttonStartStop =  (ImageView) findViewById(R.id.buttonStartStop);

    }// End of initViews method





    /**
     * method to initialize the click listeners
     */
    private void initListeners() {
        buttonReset.setOnClickListener(this::onClick);
        buttonStartStop.setOnClickListener(this::onClick);
    }




    /**
     * implemented method to listen clicks
     *
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonReset:
                reset();
                break;
            case R.id.buttonStartStop:
                startStop();
                break;
        }
    }




//    /**
//     * This is the ButtonStartStop method
//     *It is going to start the timer when you
//     * click it and change the button to stop and likewise
//     *
//     */
//    private void ButtonStartStop(View view) {
//
//        switch (view.getId()) {
//            case R.id.buttonReset:
//                reset();
//                break;
//            case R.id.buttonStartStop:
//                startStop();
//                break;
//        }
//    }// end of ButtonStartStop method


    /**
     * This is the ButtonReset method
     * It is going to rest the timer when
     * click it
     *
     */
//    private void ButtonReset(View view){
//
//        switch (view.getId()) {
//            case R.id.buttonStartStop:
//                startStop();
//                break;
//            case R.id.buttonReset:
//                reset();
//                break;
//        }
//
//
//    }// ENd of ButtonReset method



    /**
     * Here is the rest method
     */
    private void reset() {
        stopCountDownTimer();
        startCountDownTimer();
    }// End of rest method

  /**
   * This is the startStop method
 */
  private void startStop() {
    if (timerStatus == TimerStatus.STOPPED) {
        // call to initialize the timer values
        setTimerValues();
        // call to initialize the progress bar values
        setProgressBarValues();
        // showing the reset icon
        buttonReset.setVisibility(View.VISIBLE);
        // changing play icon to stop icon
        buttonStartStop.setImageResource(R.drawable.stop);
        // making edit text not editable
        editTextMinute.setEnabled(false);
        // changing the timer status to started
        timerStatus = TimerStatus.STARTED;
        // call to start the count down timer
        startCountDownTimer();

    } else {

        // hiding the reset icon
        buttonReset.setVisibility(View.GONE);
        // changing stop icon to start icon
        buttonStartStop.setImageResource(R.drawable.stop);
        // making edit text editable
        editTextMinute.setEnabled(true);
        // changing the timer status to stopped
        timerStatus = TimerStatus.STOPPED;
        stopCountDownTimer();
    }

    }// ENd of startStop method


    /**
     * method to initialize the values for count downTimer
     */
    private void setTimerValues () {
        int time;
        time = 0;
        if (!editTextMinute.getText().toString().isEmpty()) {
            // fetching value from edit text and type cast to integer
            time = Integer.parseInt(editTextMinute.getText().toString().trim());
        } else {
            // toast message to fill edit text
            Toast.makeText(getApplicationContext(), getString(R.string.message_minutes), Toast.LENGTH_LONG).show();
        }
        // assigning values after converting to milliseconds
        timeCountInMilliSeconds = time * 60 * 1000;

    }// Emd of setTimerValues method


    /**
     * method to start count downTimer
     */
    private void startCountDownTimer () {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textTimer.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textTimer.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // hiding the reset icon
                buttonReset.setVisibility(View.GONE);
                // changing stop icon to start icon
                buttonStartStop.setImageResource(R.drawable.start);
                // making edit text editable
                editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
            }

        }.start();
        countDownTimer.start();

    }// End of startCountDownTimer method


    /**
     * method to stop count downTimer
     */
    private void stopCountDownTimer () {
        countDownTimer.cancel();

    }// End of stopCountDownTimer method


    /**
     * method to set circular progress bar values
     */
    private void setProgressBarValues () {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);
    }


    /**
     * method to convert millisecond to time format
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    private String hmsTimeFormatter ( long milliSeconds){

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;


    }


}// End of Study_page calls



