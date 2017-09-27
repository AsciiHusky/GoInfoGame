package org.opensidewalks.streetcomplete.data.upload;

public interface QuestChangesUploadProgressListener
{
	void onError(Exception e);
	void onFinished();
}
