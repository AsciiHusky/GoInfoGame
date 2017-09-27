package org.opensidewalks.streetcomplete.data.osmnotes;

import de.westnordost.streetcomplete.R;
import org.opensidewalks.streetcomplete.data.QuestType;
import org.opensidewalks.streetcomplete.quests.AbstractQuestAnswerFragment;
import org.opensidewalks.streetcomplete.quests.note_discussion.NoteDiscussionForm;

public class OsmNoteQuestType implements QuestType
{
	@Override public AbstractQuestAnswerFragment createForm() { return new NoteDiscussionForm(); }
	@Override public int getIcon() { return R.drawable.ic_quest_notes; }
	@Override public int getTitle() { return R.string.quest_noteDiscussion_title; }
}
