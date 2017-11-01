package com.useradgents.burgers.test.app;

import android.app.Application;

import com.useradgents.burgers.test.di.AppComponent;
import com.useradgents.burgers.test.di.DaggerAppComponent;
import com.useradgents.burgers.test.di.modules.ContextModule;

public class FootApp extends Application {
	private static AppComponent sAppComponent;

	@Override
	public void onCreate() {
		super.onCreate();

		sAppComponent = DaggerAppComponent.builder()
				.contextModule(new ContextModule(this))
				.build();

	}

	public static AppComponent getAppComponent() {
		return sAppComponent;
	}

}
