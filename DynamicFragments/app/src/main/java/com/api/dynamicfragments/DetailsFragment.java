package com.api.dynamicfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        Bundle bundle = getArguments();

        if(bundle.containsKey(IntentExtraKeys.MY_KEY)){
            String value = bundle.getString(IntentExtraKeys.MY_KEY);
            Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
        }
        return v;
    }

}
