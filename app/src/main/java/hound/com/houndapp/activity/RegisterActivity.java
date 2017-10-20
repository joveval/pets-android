package hound.com.houndapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.stepstone.stepper.StepperLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import hound.com.houndapp.R;
import hound.com.houndapp.fragment.RegisterStepperAdaper;

/**
 * Created by Usuario on 4/10/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    private StepperLayout stepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_flow_step2);
        ButterKnife.bind(this);
        //stepperLayout = (StepperLayout) findViewById(R.id.register_step_1);
        //stepperLayout.setAdapter(new RegisterStepperAdaper(getSupportFragmentManager(),this));
    }

    @OnClick(R.id.link_login)
    public void goToLogin(){
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_register)
    public void initRegister(){
        Intent intent = new Intent(RegisterActivity.this,RegisterFlowActivity.class);
        startActivity(intent);
    }
}
