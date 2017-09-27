package org.opensidewalks.streetcomplete.statistics;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;

import org.opensidewalks.streetcomplete.Injector;
import org.opensidewalks.streetcomplete.data.QuestStatus;
import org.opensidewalks.streetcomplete.data.osm.persist.OsmQuestDao;
import org.opensidewalks.streetcomplete.data.statistics.QuestStatisticsDao;

import javax.inject.Inject;

public class AnswersCounter extends android.support.v7.widget.AppCompatTextView
{
	@Inject
    QuestStatisticsDao questStatisticsDB;
	@Inject
    OsmQuestDao questDB;

	private int answeredQuests;
	private int solvedQuests;

	public AnswersCounter(Context context)
	{
		super(context);
		init();
	}

	public AnswersCounter(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

	public AnswersCounter(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init();
	}

	private void init()
	{
		Injector.instance.getApplicationComponent().inject(this);
	}

	public void answeredQuest(String source)
	{
		answeredQuests++;
		updateText();
	}

	public void undidQuest(String source)
	{
		answeredQuests--;
		updateText();
	}

	public void update()
	{
		new AsyncTask<Void, Void, Void>()
		{
			@Override protected Void doInBackground(Void... params)
			{
				answeredQuests = questDB.getCount(null, QuestStatus.ANSWERED);
				solvedQuests = questStatisticsDB.getTotalAmount();
				return null;
			}

			@Override protected void onPostExecute(Void result)
			{
				updateText();
			}
		}.execute();
	}

	private void updateText()
	{
		String text = "" + solvedQuests;
		if(answeredQuests < 0) text += " (" + answeredQuests + ")";
		else if(answeredQuests > 0) text += " (+" + answeredQuests + ")";

		// min ems = number of digits in solved quests plus the "(+XX)" for answered quests
		setMinEms((int) Math.floor(Math.log10(solvedQuests)) + 4 + 2);
		setText(text);
	}
}
