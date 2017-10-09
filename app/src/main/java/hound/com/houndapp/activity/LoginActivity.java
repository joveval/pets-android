package hound.com.houndapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hound.com.houndapp.R;

public class LoginActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        TextView tRegister = (TextView) findViewById(R.id.link_forgot_pass);
        tRegister.setMovementMethod(LinkMovementMethod.getInstance());



    }


    @OnClick(R.id.link_signup)
    public void onClickRegistro(){
        System.out.print("Go to register");
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

}
