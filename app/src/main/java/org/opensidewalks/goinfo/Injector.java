package org.opensidewalks.goinfo;

public enum Injector
{
	instance;

	private ApplicationComponent applicationComponent;

	void initializeApplicationComponent(StreetCompleteApplication app)
	{
		applicationComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(app))
				.build();
	}

	public ApplicationComponent getApplicationComponent() {
		return applicationComponent;
	}
}
