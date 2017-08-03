package com.wisnu.recyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisnu.recyclerviewsample.MyAdapter.MyViewHolder;

import java.util.List;

/**
 * Created by wisnu on 03/08/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> stringContent;

    // it just set the list with constructor
    public MyAdapter(List<String> stringContent) {
        this.stringContent = stringContent;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (stringContent == null) {
            return;
        }
        holder.mTextView.setText(stringContent.get(position));
    }

    @Override
    public int getItemCount() {
        if (stringContent == null) {
            return 0;
        }
        return stringContent.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.content_for_recycler_view);
        }
    }

}
