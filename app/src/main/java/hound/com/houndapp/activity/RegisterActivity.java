package hound.com.houndapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stepstone.stepper.StepperLayout;

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

        stepperLayout = (StepperLayout) findViewById(R.id.register_step_1);
        stepperLayout.setAdapter(new RegisterStepperAdaper(getSupportFragmentManager(),this));
    }
}
