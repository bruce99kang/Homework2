package com.example.android.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<Item_Data> mData;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;
            public CheckBox mCheckBox;
            public ViewHolder(View v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.info_text);
                mCheckBox = (CheckBox) v.findViewById(R.id.info_chcekbox);
            }
        }

        public MyAdapter(ArrayList<Item_Data> data) {
            mData = data;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            Item_Data item = mData.get(position);
            holder.mTextView.setText(item.getText());
            holder.mCheckBox.setChecked(item.isCheck());
            holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean b = ((CheckBox) view).isChecked();
                    holder.mCheckBox.setChecked(b);
                    mData.get(position).setCheck(b);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }


}
