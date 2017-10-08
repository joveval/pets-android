package hound.com.houndapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.v4.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

import hound.com.houndapp.R;

/**
 * Created by Usuario on 4/10/2017.
 */

public class RegisterStepperAdaper extends AbstractFragmentStepAdapter {

    public static final String CURRENT_STEP_POSITION_KEY="currentPos";

    public RegisterStepperAdaper(FragmentManager fm, Context context){
        super(fm,context);
    }

    @Override
    public Step createStep(@IntRange(from = 0L) int position) {

        final RegisterStep1 step1 = new RegisterStep1();
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY,position);
        step1.setArguments(b);


        return step1;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
