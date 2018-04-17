package com.example.ghostl.proyectocibertec.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.model.PrincipalData;
import com.example.ghostl.proyectocibertec.utils.Constants;
import com.example.ghostl.proyectocibertec.utils.Util;
import com.example.ghostl.proyectocibertec.views.adapters.PrincipalAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {

    private List<PrincipalData> itemList = new ArrayList<>();

    RecyclerView mRecyclerView;
    ProgressBar mProgressBar;
    LinearLayoutManager mLinearLayoutManager;
    PrincipalAdapter mPrincipalAdapter;
    CoordinatorLayout mCoordinatorLayout;

    public static EventsFragment newInstance(){
        EventsFragment principalFragment = new EventsFragment();
        return principalFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.even_news, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Fragment ", "Event" );

        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mCoordinatorLayout = view.findViewById(R.id.coordinatorLayout);
        mProgressBar = view.findViewById(R.id.pProgressBar);
        mRecyclerView = view.findViewById(R.id.rRecycleView);

        loadData();

    }

    private void loadData() {
        itemList.clear();

        mRecyclerView.clearOnScrollListeners();
        mRecyclerView.removeAllViews();
        mPrincipalAdapter = new PrincipalAdapter(itemList);

        mProgressBar.setVisibility(View.VISIBLE);


        if(Constants.mock){
            mProgressBar.setVisibility(View.GONE);
            addDataMock(itemList);
            mRecyclerView.setLayoutManager(mLinearLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setAdapter(mPrincipalAdapter);

        }else{

        }
    }

    private void addDataMock(List<PrincipalData> itemList) {

        PrincipalData principalData1 = new PrincipalData("Evento", "test de evento", "http://e.rpp-noticias.io/medium/2018/03/05/portada_375637.jpg", 4,12, "-12.088212792096702", "-77.00347423553467","Av. Javier Prado 225");
        PrincipalData principalData2 = new PrincipalData("Evento Principal", "test de evento", "http://e.rpp-noticias.io/medium/2018/03/05/portada_204620.jpg", 4, 13, "-12.07207553860705", "-77.00278700927629","Av. Nicolas Arriola 1225");
        PrincipalData principalData3 = new PrincipalData("Evento Informativo", "test de evento" , "http://e.rpp-noticias.io/medium/2018/03/05/portada_204620.jpg", 4, 12, "-12.088212792096702", "-77.00347423553467","Av. Javier Prado 225");


        itemList.add(principalData1);
        itemList.add(principalData2);
        itemList.add(principalData3);

    }
}
