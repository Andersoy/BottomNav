package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    DBHandler db;
    private ListView moetelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHandler(this);
        for(int i = 0; i<10; i++){
            db.leggTilMoete(i);
        }



        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistener);
        setTitle("Møter");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new MeetingFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_meetings:
                            selectedFragment = new MeetingFragment();
                            setTitle("Møter");
                            break;
                        case R.id.nav_contacts:
                            selectedFragment = new ContactsFragment();
                            setTitle("Kontakter");
                            break;
                        case R.id.nav_preferences:
                            selectedFragment = new PreferencesFragment();
                            setTitle("Preferanser");
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }

            };

}