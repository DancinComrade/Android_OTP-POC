package sg.edu.np.mad.otpgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        User userData = (User) getIntent().getSerializableExtra("userDetails");
        TextView usernameView = (TextView) findViewById(R.id.userN);
        TextView passwordView = (TextView) findViewById(R.id.passW);
        usernameView.setText(userData.Username);
        passwordView.setText(userData.Password);

        String generatedOTP = String.format("%06d", new Random().nextInt(999999));
        TextView otpView = (TextView) findViewById(R.id.otpView);
        otpView.setText(generatedOTP);

        TextView timerView = (TextView) findViewById(R.id.textView6);

        CountDownTimer myCountDown = new CountDownTimer(15000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timerView.setText(Long.toString(millisUntilFinished / 1000));
            };
            public void onFinish(){
                otpView.setText(String.format("%06d", new Random().nextInt(999999)));
                this.start();
            };
        }.start();

        Button generateButton = (Button) findViewById(R.id.button);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otpView.setText(String.format("%06d", new Random().nextInt(999999)));
                myCountDown.cancel(); // cancel
                myCountDown.start();  // then restart
            }
        });
    }
}