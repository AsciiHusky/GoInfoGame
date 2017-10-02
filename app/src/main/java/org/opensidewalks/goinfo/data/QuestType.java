package org.opensidewalks.goinfo.data;

import org.opensidewalks.goinfo.quests.AbstractQuestAnswerFragment;

public interface QuestType
{
	/** @return the dialog in which the user can add the data */
	AbstractQuestAnswerFragment createForm();

	/** @return the icon resource id used to display this quest type on the map */
	int getIcon();

	/** @return the title resource id used to display the quest's question */
	int getTitle();
}
