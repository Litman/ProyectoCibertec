package com.example.ghostl.proyectocibertec.views.ViewHolders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.model.PrincipalData;

public class ItemsViewHolder extends RecyclerView.ViewHolder {

    PrincipalData item;
    ImageView imgItem;
    TextView tvDescription, tvTitle;

    public ItemsViewHolder(View itemView){
        super(itemView);

        imgItem = itemView.findViewById(R.id.imageView4);
        tvDescription = itemView.findViewById(R.id.tDescription);
        tvTitle = itemView.findViewById(R.id.tTitle);
    }


    public void bind(PrincipalData newItem) {
        this.item = newItem;

        tvTitle.setText(newItem.getTitle());

        tvDescription.setText(newItem.getDescription());

    }
}
