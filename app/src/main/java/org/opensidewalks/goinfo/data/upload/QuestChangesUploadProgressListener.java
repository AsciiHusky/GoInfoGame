package org.opensidewalks.goinfo.data.upload;

public interface QuestChangesUploadProgressListener
{
	void onError(Exception e);
	void onFinished();
}
