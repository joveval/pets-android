package hound.com.houndapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import hound.com.houndapp.R;

public class RegisterFlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_flow);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,DISTRITOS);
        AutoCompleteTextView distritosTxt = (AutoCompleteTextView) findViewById(R.id.input_distrito);
        distritosTxt.setAdapter(adapter);
    }


    private final static String[] DISTRITOS = {"Santiago de Surco","Cercado de Lima","Ate Vitarte","San Juan de Lurigancho"};
}
