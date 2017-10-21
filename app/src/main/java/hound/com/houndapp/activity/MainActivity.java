package hound.com.houndapp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import hound.com.houndapp.R;

public class MainActivity extends AppCompatActivity {


    View currentTabActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        currentTabActive =  findViewById(R.id.menu_include_tab_home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                View view ;
                switch (item.getItemId()) {

                    case R.id.menu_home:
                        // User chose the "Settings" item, show the app settings UI...
                        view =  findViewById(R.id.menu_include_tab_home);
                        break;
                    case R.id.menu_search:
                        view =  findViewById(R.id.menu_include_tab_search);
                        break;
                    case R.id.menu_map:
                        view =  findViewById(R.id.menu_include_tab_map);
                        break;
                    case R.id.menu_vote:
                        view =  findViewById(R.id.menu_include_tab_vote);
                        break;
                    case R.id.menu_me:
                        view =  findViewById(R.id.menu_include_tab_me);
                        break;
                    default:
                        // If we got here, the user's action was not recognized.
                        // Invoke the superclass to handle it.
                        return false;
                }
                currentTabActive.setVisibility(View.GONE);
                currentTabActive = view;
                view.setVisibility(View.VISIBLE);

                return true;
            }
        });
    }



}
