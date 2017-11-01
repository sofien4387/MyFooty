package com.useradgents.burgers.test.di;

import android.content.Context;

import com.useradgents.burgers.test.di.modules.FootModule;
import com.useradgents.burgers.test.di.modules.BusModule;
import com.useradgents.burgers.test.di.modules.ContextModule;
import com.useradgents.burgers.test.managers.FootManager;
import com.useradgents.burgers.test.mvp.NewsService;
import com.useradgents.burgers.test.mvp.presenters.CompetitionsPresenter;
import com.useradgents.burgers.test.mvp.presenters.TeamsPresenter;
import com.useradgents.burgers.test.mvp.presenters.HomePresenter;
import com.useradgents.burgers.test.managers.NewsManager;
import com.useradgents.burgers.test.ui.activities.DetailsActivity;
import com.useradgents.burgers.test.ui.activities.MainActivity;
import com.useradgents.burgers.test.ui.fragments.CompetitionsFragment;
import com.useradgents.burgers.test.ui.fragments.HomeFragment;
import com.useradgents.burgers.test.ui.fragments.TeamsFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ContextModule.class, BusModule.class, FootModule.class })
public interface AppComponent {

	Context getContext();
	NewsService getAuthService();
	Bus getBus();

	void inject(NewsManager newsManager);
	void inject(FootManager footManager);

    void inject(MainActivity mainActivity);
    void inject(DetailsActivity detailsActivity);

    void inject(HomeFragment homeFragment);
    void inject(CompetitionsFragment competitionsFragment);
    void inject(TeamsFragment teamsFragment);

    void inject(HomePresenter mainPresenter);
    void inject(CompetitionsPresenter competitionsPresenter);
    void inject(TeamsPresenter competitionPresenter);

}


