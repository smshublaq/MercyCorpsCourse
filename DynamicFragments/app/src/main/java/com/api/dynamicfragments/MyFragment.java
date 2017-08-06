package com.api.dynamicfragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private IActivityEnabledListener aeListener;

    Context context;

    public MyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_my, container, false);
        Button btn = myView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment detailsFragment = new DetailsFragment();

                Bundle bundle = new Bundle();
                bundle.putString(IntentExtraKeys.MY_KEY,"ahmed");
                detailsFragment.setArguments(bundle);

                transaction.replace(R.id.container,detailsFragment);
                transaction.commit();
                */
                Fragment detailsFragment = new DetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString(IntentExtraKeys.MY_KEY,"ahmed");
                detailsFragment.setArguments(bundle);
                FragmentsUtil.replaceFragment(getActivity(),R.id.container,detailsFragment,false);

            }
        });
        return myView;
    }

    public Context getMyContext(){
        return this.context;
    }

    private interface IActivityEnabledListener {
        void onActivityEnabled(FragmentActivity activity);
    }


    private void getAvailableActivity(IActivityEnabledListener listener) {
        if (getActivity() == null) {
            aeListener = listener;

        } else {
            listener.onActivityEnabled(getActivity());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (aeListener != null) {
            aeListener.onActivityEnabled((FragmentActivity) activity);
            aeListener = null;
        }


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (aeListener != null) {
            aeListener.onActivityEnabled((FragmentActivity) context);
            aeListener = null;
        }
    }

}
