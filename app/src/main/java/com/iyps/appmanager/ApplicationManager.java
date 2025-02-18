package com.iyps.appmanager;


import static com.iyps.preferences.PreferenceManager.THEME_PREF;

import android.app.Application;
import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;

import com.iyps.R;
import com.iyps.preferences.PreferenceManager;

public class ApplicationManager extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        PreferenceManager preferenceManager=new PreferenceManager(this);

        // THEME
        if (preferenceManager.getInt(THEME_PREF)==0){
            if (Build.VERSION.SDK_INT>=29){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        }

        else if (preferenceManager.getInt(THEME_PREF)==R.id.option_default){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
        else if (preferenceManager.getInt(THEME_PREF)==R.id.option_light){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        else if (preferenceManager.getInt(THEME_PREF)==R.id.option_dark){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }
}
