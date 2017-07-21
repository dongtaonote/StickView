package com.example.stickview.scrollablelayout.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.stickview.R;
import com.example.stickview.scrollablelayout.fragment.PagerHeaderFragment;

public class ScrollAbleMainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scrollable);
        showPagerHeaderFragment(null);
    }

    public void showPagerHeaderFragment(View view) {
        showFragment(PagerHeaderFragment.class);
    }

    public <T extends Fragment> void showFragment(Class<T> clzz) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        try {
            if (fragment == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, clzz.newInstance(), clzz.getSimpleName()).commit();
            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, clzz.newInstance(), clzz.getSimpleName()).commit();
            }
            getSupportActionBar().setTitle(clzz.getSimpleName());
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
    }
}
