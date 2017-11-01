package com.useradgents.burgers.test.ui.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.Window;

import com.arellomobile.mvp.sample.github.R;
import com.useradgents.burgers.test.ui.fragments.CompetitionsFragment;
import com.useradgents.burgers.test.ui.fragments.FixturesFragment;
import com.useradgents.burgers.test.ui.fragments.HomeFragment;
import com.useradgents.burgers.test.utils.OnFragmentInteractionListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BurgerBaseActivity implements OnFragmentInteractionListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        changeFragment(0);

        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_favorites:
                    changeFragment(0);
                    break;
                case R.id.action_schedules:
                    changeFragment(1);
                    break;
                case R.id.action_music:
                    changeFragment(2);
                    break;
            }
            return true;
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * To load fragments for sample
     * @param position menu index
     */
    private void changeFragment(int position) {

        Fragment newFragment = null;

        switch (position){
            case 0:
                newFragment = new HomeFragment();
                break;
            case 1:
                newFragment = new CompetitionsFragment();
                break;
            case 2:
                newFragment = new FixturesFragment();
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, newFragment)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
