%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/databases/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/databases/goinfo.db
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell cp /data/data/org.opensidewalks.goinfo/databases/goinfo.db /sdcard/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe pull /sdcard/goinfo.db goinfo.db
"C:\Program Files\DB Browser for SQLite\DB Browser for SQLite.exe" goinfo.db
del goinfo.db
