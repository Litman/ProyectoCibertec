package com.example.ghostl.proyectocibertec.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.model.PrincipalData;
import com.example.ghostl.proyectocibertec.views.adapters.PrincipalAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    PrincipalAdapter mPrincipalAdapter;
    List<PrincipalData> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        initObjectts();
        prepareRecyclerView();
    }

    private void initObjectts() {

    }

    private void prepareRecyclerView() {
        mRecyclerView = findViewById(R.id.rRecycleViewRigth);
        LinearLayoutManager layoutManager = new LinearLayoutManager( this);

        mPrincipalAdapter = new PrincipalAdapter(items);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mPrincipalAdapter);

    }
}
