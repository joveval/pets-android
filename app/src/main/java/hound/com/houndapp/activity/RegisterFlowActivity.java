package hound.com.houndapp.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;


import butterknife.ButterKnife;
import butterknife.OnClick;
import hound.com.houndapp.R;

public class RegisterFlowActivity extends AppCompatActivity {

    private int currentPos = 1;

    final private static int RESULT_TO_LOAD_IMG=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_flow);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Registro");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.register_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cancel_register:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(RegisterFlowActivity.this,LoginActivity.class);
                startActivity(intent);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @OnClick({R.id.link_step2,R.id.link_step3,R.id.link_step4,R.id.link_step5,R.id.link_step6,R.id.link_step7,R.id.link_step8,R.id.link_step9})
    public void goNextStep(){
        View oldView = getViewByPosition(currentPos++);
        View newView = getViewByPosition(currentPos);
        oldView.setVisibility(View.GONE);
        newView.setVisibility(View.VISIBLE);
        if(currentPos==9){
            View view = findViewById(R.id.prevActionBtn);
            view.setVisibility(View.GONE);
        }
    }
    @OnClick(R.id.prevActionBtn)
    public void goBackStep(){
        View oldView = getViewByPosition(currentPos--);
        View newView = getViewByPosition(currentPos);
        oldView.setVisibility(View.GONE);
        newView.setVisibility(View.VISIBLE);

    }

    @OnClick(R.id.img_mascota)
    public void selectImage(){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,RESULT_TO_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_TO_LOAD_IMG && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.img_mascota);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }


    private View getViewByPosition(int pos){
        View view = null;
        switch (pos){
            case 1:
                view = (View)findViewById(R.id.include1);
                break;
            case 2:
                view = (View)findViewById(R.id.include2);
                break;
            case 3:
                view = (View)findViewById(R.id.include3);
                break;
            case 4:
                view = (View)findViewById(R.id.include4);
                break;
            case 5:
                view = (View)findViewById(R.id.include5);
                break;
            case 6:
                view = (View)findViewById(R.id.include6);
                break;
            case 7:
                view = (View)findViewById(R.id.include7);
                break;
            case 8:
                view = (View)findViewById(R.id.include8);
                break;
            case 9:
                view = (View)findViewById(R.id.include9);
                break;
        }
        return view;
    }
    private final static String[] DISTRITOS = {"Santiago de Surco","Cercado de Lima","Ate Vitarte","San Juan de Lurigancho"};
}
