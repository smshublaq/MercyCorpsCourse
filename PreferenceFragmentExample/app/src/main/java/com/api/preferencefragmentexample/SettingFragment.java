package com.api.preferencefragmentexample;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by iSaleem on 8/6/17.
 */

public class SettingFragment extends PreferenceFragment {

    public SettingFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        Preference preference = getPreferenceManager().findPreference("edit_text_pref");
        Toast.makeText(getActivity(),         preference.getTitle()
                , Toast.LENGTH_SHORT).show();



        preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Toast.makeText(getActivity(), (String)o, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }


}
