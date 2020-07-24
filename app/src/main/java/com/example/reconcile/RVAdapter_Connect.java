package com.example.reconcile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter_Connect extends RecyclerView.Adapter<RVAdapter_Connect.GroupViewHolder> {

    private Context mContext;
    private List<Group> mData;


    public RVAdapter_Connect(Context mContext, List<Group> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_connect, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, final int position) {

        holder.tv_group_name.setText(mData.get(position).getName());
        holder.group_img.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, ArticleActivity.class);

                //pass data to article activity
                intent.putExtra("Name",mData.get(position).getName());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());

                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView tv_group_name;
        ImageView group_img;
        CardView cardView;

        public GroupViewHolder(View itemView) {
            super(itemView);

            tv_group_name = (TextView) itemView.findViewById(R.id.group_name);
            group_img = (ImageView) itemView.findViewById(R.id.group_img);
            cardView = (CardView) itemView.findViewById(R.id.cardview);

        }
    }


}
