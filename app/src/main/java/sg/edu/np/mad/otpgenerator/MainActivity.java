package sg.edu.np.mad.otpgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User userObj = new User();
        EditText nameInput = (EditText) findViewById(R.id.nameInp);
        EditText passInput = (EditText) findViewById(R.id.passInp);
        Button loginBut = (Button) findViewById(R.id.loginButton);
        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userObj.Username = nameInput.getText().toString();
                userObj.Password = passInput.getText().toString();

                Intent homePage = new Intent(MainActivity.this, OTP.class);
                homePage.putExtra("userDetails", userObj);
                startActivity(homePage);
            }
        });

    }
}