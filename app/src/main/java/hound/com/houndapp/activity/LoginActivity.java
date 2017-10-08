package hound.com.houndapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import hound.com.houndapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tRegister = (TextView) findViewById(R.id.link_forgot_pass);
        tRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
