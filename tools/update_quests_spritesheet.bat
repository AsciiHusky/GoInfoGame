%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/files/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/files/quests.png
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell run-as org.opensidewalks.goinfo chmod 777 /data/data/org.opensidewalks.goinfo/files/goinfo_quests.yaml
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell cp /data/data/org.opensidewalks.goinfo/files/quests.png /sdcard/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe shell cp /data/data/org.opensidewalks.goinfo/files/goinfo_quests.yaml /sdcard/
%ANDROID_SDK_ROOT%\platform-tools\adb.exe pull /sdcard/quests.png ../app/src/main/assets/quests.png
%ANDROID_SDK_ROOT%\platform-tools\adb.exe pull /sdcard/goinfo_quests.yaml ../app/src/main/assets/goinfo_quests.yaml
