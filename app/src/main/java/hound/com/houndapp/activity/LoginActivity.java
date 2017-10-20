package hound.com.houndapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hound.com.houndapp.R;
import hound.com.houndapp.model.TypeFaceUtil;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.input_email)
    TextView email;

    @BindView(R.id.input_password)
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        TypeFaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/AvertaDemo_Regular.otf");

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        TextView tRegister = (TextView) findViewById(R.id.link_forgot_pass);
        tRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        String emailValue = email.getText().toString();
        String passwordValue = password.getText().toString();

        //TODO validations

        auth.signInWithEmailAndPassword(emailValue, passwordValue)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() == false) {
                            //TODO What is going on here
                        } else {
                            //TODO Continue to menu
                            finish();
                        }
                    }
                });

    }

    @OnClick(R.id.link_signup)
    public void onClickRegistro(){
        System.out.print("Go to register");
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

}
