package com.example.ghostl.proyectocibertec.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.model.PrincipalData;
import com.example.ghostl.proyectocibertec.views.ViewHolders.ItemsViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PrincipalAdapter extends RecyclerView.Adapter<ItemsViewHolder> implements View.OnClickListener   {

    private List<PrincipalData> mDataSource = new ArrayList();
    private Context context;

    public PrincipalAdapter(List<PrincipalData> mDataSource) {
        this.mDataSource = mDataSource;
    }

    public void setDataSource(List<PrincipalData> mDataSource) {
        this.mDataSource = mDataSource;
        notifyDataSetChanged();
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewPrincipal = inflater.inflate(R.layout.item_principal, parent, false);
        return new ItemsViewHolder(viewPrincipal);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {

        PrincipalData newItem = mDataSource.get(position);


        holder.bind(newItem);


    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    @Override
    public void onClick(View view) {

    }
}

