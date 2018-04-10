package com.example.ghostl.proyectocibertec.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ghostl.proyectocibertec.R;

public class PrincipalFragment extends Fragment {

    public static PrincipalFragment newInstance(){
        PrincipalFragment principalFragment = new PrincipalFragment();
        return principalFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.principal_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Fragment ", "Principal" );
    }
}
