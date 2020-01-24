package com.example.gaana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gaana.Fragments.ChatFragment;
import com.example.gaana.Fragments.HomeFragment;
import com.example.gaana.Fragments.MusicFragment;
import com.example.gaana.Fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    HomeFragment objectHomeFragment;
    SearchFragment objectSearchFragment;
    MusicFragment objectMusicFragment;
    ChatFragment objectChatFragment;
    BottomNavigationView objectBottomNavigationView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(this);

        try {
            objectHomeFragment=new HomeFragment();
            objectSearchFragment=new SearchFragment();
            objectMusicFragment=new MusicFragment();
            objectChatFragment=new ChatFragment();
            changeFragment(objectHomeFragment);
            objectBottomNavigationView = findViewById(R.id.BNV);
            objectBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.homeitem:
                            objectBottomNavigationView.setBackgroundColor(Color.WHITE);
                            changeFragment(objectHomeFragment);
                            return true;

                        case R.id.searchitem:
                            objectBottomNavigationView.setBackgroundColor(Color.WHITE);
                            changeFragment(objectSearchFragment);
                            return true;

                        case R.id.mymusicitem:
                            objectBottomNavigationView.setBackgroundColor(Color.WHITE);
                            changeFragment(objectMusicFragment);
                            return true;

                        case R.id.chatitem:
                            objectBottomNavigationView.setBackgroundColor(Color.WHITE);
                            changeFragment(objectChatFragment);
                            return true;

                        default:
                            return false;
                    }
                }
            });
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void changeFragment(Fragment object) {
        try{
            FragmentTransaction objectFragmentTransaction=getSupportFragmentManager().beginTransaction();
            objectFragmentTransaction.replace(R.id.FL,object);
            objectFragmentTransaction.commit();
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
    }
}
