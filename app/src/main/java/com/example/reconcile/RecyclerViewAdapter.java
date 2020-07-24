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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder> {

    private Context mContext;
    private List<News> mData;


    public RecyclerViewAdapter(Context mContext, List<News> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {

        holder.tv_news_title.setText(mData.get(position).getTitle());
        holder.news_img.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, ArticleActivity.class);

                //pass data to article activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());

                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

  /** method used to change card sizes
   * public boolean isHeader(int position) {
        return position==0;
    } **/

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_news_title;
        ImageView news_img;
        CardView cardView;

        public NewsViewHolder(View itemView) {
            super(itemView);

            tv_news_title = (TextView) itemView.findViewById(R.id.news_title);
            news_img = (ImageView) itemView.findViewById(R.id.news_img);
            cardView = (CardView) itemView.findViewById(R.id.cardview);

        }
    }


}
