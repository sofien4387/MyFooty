package com.useradgents.burgers.test.di.modules;

import com.useradgents.burgers.test.app.NewsApi;
import com.useradgents.burgers.test.app.FootApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module(includes = {RetrofitModule.class})
public class ApiModule {

	@Provides
	@Singleton
	public NewsApi provideNewsApi(@Named("newsFoot")Retrofit retrofitNewsFoot) {
		return retrofitNewsFoot.create(NewsApi.class);
	}

	@Provides
	@Singleton
	public FootApi provideFootApi(@Named("foot")Retrofit retrofitFoot) {
		return retrofitFoot.create(FootApi.class);
	}
}
