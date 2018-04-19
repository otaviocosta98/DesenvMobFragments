package br.com.usjt.desenvmob.viewpagerwithfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new TabsAdapter(fm));
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Frag 1").setTabListener(new MyTabListener(viewPager, 0)));
        actionBar.addTab(actionBar.newTab().setText("Frag 2").setTabListener(new MyTabListener(viewPager, 1)));
        actionBar.addTab(actionBar.newTab().setText("Frag 3").setTabListener(new MyTabListener(viewPager, 2)));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this, "chamou", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
