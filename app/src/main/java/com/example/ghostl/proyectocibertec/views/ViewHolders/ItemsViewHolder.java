package com.example.ghostl.proyectocibertec.views.ViewHolders;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.model.PrincipalData;
import com.example.ghostl.proyectocibertec.utils.Constants;
import com.example.ghostl.proyectocibertec.views.activities.DetailDataActivity;
import com.example.ghostl.proyectocibertec.views.activities.EventActivity;

public class ItemsViewHolder extends RecyclerView.ViewHolder {

    PrincipalData item;
    ImageView imgItem;
    TextView tvDescription, tvTitle, mLocation, mDate;
    RelativeLayout rRelativeLayout;


    Intent intent = new Intent(itemView.getContext(), DetailDataActivity.class);

    public ItemsViewHolder(View itemView){
        super(itemView);

        imgItem = itemView.findViewById(R.id.iImage);
        tvDescription = itemView.findViewById(R.id.tDescription);
        tvTitle = itemView.findViewById(R.id.tTitle);
        rRelativeLayout = itemView.findViewById(R.id.relativeLayout);
        mLocation = itemView.findViewById(R.id.tLocation);
        mDate = itemView.findViewById(R.id.tDate);
    }


    public void bind(PrincipalData newItem) {
        this.item = newItem;

        itemView.setTag(this.item);

        tvTitle.setText(newItem.getTitle());

        tvDescription.setText(newItem.getDescription());

        if(item.getTypeData() == 3){
            PrincipalData item = (PrincipalData) itemView.getTag();

            intent.putExtra("id", item.getDescription());
            intent.putExtra("type", Constants.Item_Principal);

            rRelativeLayout.setVisibility(View.GONE);


        }else{
            PrincipalData item = (PrincipalData) itemView.getTag();

            intent = new Intent(itemView.getContext(), EventActivity.class);
            intent.putExtra("id", item.getDescription());
            intent.putExtra("type", Constants.Item_Event);

            rRelativeLayout.setVisibility(View.VISIBLE);

        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemView.getContext().startActivity(intent);

            }
        });

    }
}
