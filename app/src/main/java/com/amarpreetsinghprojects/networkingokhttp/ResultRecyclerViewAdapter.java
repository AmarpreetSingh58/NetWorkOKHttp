package com.amarpreetsinghprojects.networkingokhttp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kulvi on 07/04/17.
 */

public class ResultRecyclerViewAdapter extends RecyclerView.Adapter<ResultRecyclerViewAdapter.ResultViewHolder> {

    ArrayList<UsersDetails> usersDetailsArrayList;
    RecyclerViewItemClickListner listner;

    public ResultRecyclerViewAdapter(ArrayList<UsersDetails> usersDetailsArrayList, RecyclerViewItemClickListner listner) {
        this.usersDetailsArrayList = usersDetailsArrayList;
        this.listner = listner;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (LayoutInflater.from(parent.getContext())).inflate(R.layout.search_single_item,parent,false);
        return new ResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        holder.Bind(usersDetailsArrayList.get(position),listner);
    }

    @Override
    public int getItemCount() {
        return usersDetailsArrayList.size();
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {
        TextView username,url;
        ImageView avatar;

        public ResultViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.resultSingleItemusername);
            url = (TextView)itemView.findViewById(R.id.resultSingleItemurlTV);
            avatar = (ImageView)itemView.findViewById(R.id.resultSingleItemIV);
        }
        public void Bind(final UsersDetails user, final RecyclerViewItemClickListner listner){
            avatar.setImageBitmap(user.getAvatar());
            username.setText(user.getUsername());
            url.setText(user.getProfilelink());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.OnItemClick(user);
                }
            });
        }
    }
}
