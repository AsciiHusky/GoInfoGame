package de.westnordost.streetcomplete.quests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.westnordost.streetcomplete.R;

/**
 * Created by Neelam Purswani on 26-01-2018.
 */

public class RangeQuestAnswerFragment extends AbstractQuestAnswerFragment {

    /** Abstract base class for dialogs in which the user answers a yes/no quest */
     public static final String ANSWER = "answer";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            View view = super.onCreateView(inflater, container, savedInstanceState);
            View buttonPanel = setButtonsView(R.layout.answer_range);

            buttonPanel.findViewById(R.id.range1).setOnClickListener(new View.OnClickListener()
            {
                @Override public void onClick(View v)
                {
                    onClickgetRange("0");
                }
            });
            buttonPanel.findViewById(R.id.range2).setOnClickListener(new View.OnClickListener()
            {
                @Override public void onClick(View v)
                {
                    onClickgetRange("1-3");
                }
            });
            buttonPanel.findViewById(R.id.range3).setOnClickListener(new View.OnClickListener()
            {
                @Override public void onClick(View v)
                {
                    onClickgetRange("4-7");
                }
            });
            return view;
        }

        @Override public boolean hasChanges()
        {
            return false;
        }

        protected void onClickgetRange(String answer)
        {
            Bundle bundle = new Bundle();
            bundle.putString(ANSWER, answer);
            applyImmediateAnswer(bundle);
        }



}
