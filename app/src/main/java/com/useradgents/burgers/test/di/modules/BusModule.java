package com.useradgents.burgers.test.di.modules;

import com.useradgents.burgers.test.app.NewsApi;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class BusModule {
	@Provides
	@Singleton
	public Bus provideBus(NewsApi authApi) {
		return new Bus();
	}
}
