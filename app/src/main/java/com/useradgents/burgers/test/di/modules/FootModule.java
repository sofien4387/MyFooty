package com.useradgents.burgers.test.di.modules;

import com.useradgents.burgers.test.app.FootApi;
import com.useradgents.burgers.test.app.NewsApi;
import com.useradgents.burgers.test.mvp.FootService;
import com.useradgents.burgers.test.mvp.NewsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class})
public class FootModule {
	@Provides
	@Singleton
	public NewsService provideNewsService(NewsApi newsApi) {
		return new NewsService(newsApi);
	}
	@Provides
	@Singleton
	public FootService provideFootService(FootApi footApi) {
		return new FootService(footApi);
	}
}