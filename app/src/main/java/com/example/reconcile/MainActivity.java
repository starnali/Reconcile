package com.example.reconcile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private NewsFragment newsFragment;
    private DiscussionFragment discussionFragment;
    private EventsFragment eventsFragment;
    private ConnectFragment connectFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        newsFragment = new NewsFragment();
        discussionFragment = new DiscussionFragment();
        eventsFragment = new EventsFragment();
        connectFragment = new ConnectFragment();

        setFragment(newsFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_news  :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(newsFragment);
                        return true;

                    case R.id.nav_discuss:
                        mMainNav.setItemBackgroundResource((R.color.colorAccent));
                        setFragment(discussionFragment);
                        return true;

                    case R.id.nav_events:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(eventsFragment);
                        return true;

                    case R.id.nav_connect:
                        mMainNav.setItemBackgroundResource(R.color.color4);
                        setFragment(connectFragment);
                        return true;

                    default:
                        return false;


                }

            }
        });


    }

    private void setFragment (Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}