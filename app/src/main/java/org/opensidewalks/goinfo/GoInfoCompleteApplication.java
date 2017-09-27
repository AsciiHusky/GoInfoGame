package org.opensidewalks.goinfo;

import android.app.Application;

import org.opensidewalks.goinfo.data.meta.CountryBoundaries;

import java.util.concurrent.FutureTask;

import javax.inject.Inject;

import org.opensidewalks.goinfo.tangram.TangramQuestSpriteSheetCreator;

public class GoInfoCompleteApplication extends Application
{
	@Inject FutureTask<CountryBoundaries> countryBoundariesFuture;
	@Inject TangramQuestSpriteSheetCreator spriteSheetCreator;

	@Override
	public void onCreate()
	{
		super.onCreate();
		Injector.instance.initializeApplicationComponent(this);
		Injector.instance.getApplicationComponent().inject(this);
		preload();
	}

	/** Load some things in the background that are needed later */
	private void preload()
	{
		// sprite sheet is necessary to display quests
		new Thread(new Runnable() { @Override public void run() { spriteSheetCreator.get(); }}).start();
		// country boundaries are necessary latest for when a quest is opened
		new Thread(countryBoundariesFuture).start();
	}
}
