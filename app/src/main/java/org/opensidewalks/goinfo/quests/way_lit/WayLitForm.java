package org.opensidewalks.goinfo.quests.way_lit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.opensidewalks.goinfo.R;
import org.opensidewalks.goinfo.quests.YesNoQuestAnswerFragment;

public class WayLitForm extends YesNoQuestAnswerFragment
{
	public static final String OTHER_ANSWER = "OTHER_ANSWER";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);
		addOtherAnswers();
		return view;
	}

	private void addOtherAnswers()
	{
		addOtherAnswer(R.string.quest_way_lit_24_7, new Runnable()
		{
			@Override public void run()
			{
				applyAnswer("24/7");
			}
		});
		addOtherAnswer(R.string.quest_way_lit_automatic, new Runnable()
		{
			@Override public void run()
			{
				applyAnswer("automatic");
			}
		});
	}

	private void applyAnswer(String value)
	{
		Bundle answer = new Bundle();
		answer.putString(OTHER_ANSWER, value);
		applyImmediateAnswer(answer);
	}
}
