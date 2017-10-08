package hound.com.houndapp.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import hound.com.houndapp.R;

/**
 * Created by Usuario on 4/10/2017.
 */

public class RegisterStep1 extends Fragment implements Step {

    private static final String LAYOUT_RESOURCE_ID_ARG_KEY = "messageResourceId";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.register_flow_step3,container,false);
        return v;
    }


    public static RegisterStep1 newInstance(@LayoutRes int layoutResId) {

        Bundle args = new Bundle();
        args.putInt(LAYOUT_RESOURCE_ID_ARG_KEY,layoutResId);
        RegisterStep1 fragment = new RegisterStep1();
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}
