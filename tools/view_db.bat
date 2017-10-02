%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/databases/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/databases/streetcomplete.db
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell cp /data/data/org.opensidewalks.goinfo/databases/streetcomplete.db /sdcard/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe pull /sdcard/streetcomplete.db streetcomplete.db
"C:\Program Files\DB Browser for SQLite\DB Browser for SQLite.exe" streetcomplete.db
del streetcomplete.db