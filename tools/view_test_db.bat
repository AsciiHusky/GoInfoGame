%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/databases/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/databases/test_goinfo.db
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell cp /data/data/org.opensidewalks.goinfo/databases/test_goinfo.db /sdcard/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe pull /sdcard/test_goinfo.db test_goinfo.db
"C:\Program Files\DB Browser for SQLite\DB Browser for SQLite.exe" test_goinfo.db
del test_goinfo.db
