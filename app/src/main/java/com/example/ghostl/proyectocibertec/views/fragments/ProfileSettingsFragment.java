package com.example.ghostl.proyectocibertec.views.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.views.activities.ChangePasswordActivity;
import com.example.ghostl.proyectocibertec.views.activities.UpdateProfileActivity;

public class ProfileSettingsFragment extends Fragment{

    LinearLayout optionUpdate;
    LinearLayout optionChange;

    public static ProfileSettingsFragment newInstance(){
        ProfileSettingsFragment fragment = new ProfileSettingsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.profile_settings, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        optionChange = view.findViewById(R.id.lOptionChange);
        optionUpdate = view.findViewById(R.id.lOptionUpdate);

        optionChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        optionUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentUpdate = new Intent(getActivity(), UpdateProfileActivity.class);
                startActivity(intentUpdate);
            }
        });

    }
}
