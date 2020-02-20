package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_report {

    public static class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

        Context mContext;
        List<item_report> mData;

        public Adapter(Context mContext, List<item_report> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            LayoutInflater inflater = LayoutInflater.from(mContext);
            View v = inflater.inflate(R.layout.report_card, parent, false);

            return new myViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            holder.report_name_java.setText(mData.get(position).getReport_name());
            holder.report_date_java.setText(mData.get(position).getReport_date());

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class myViewHolder extends RecyclerView.ViewHolder {

            TextView report_name_java;
            TextView report_date_java;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                report_name_java = itemView.findViewById(R.id.report_name);
                report_date_java = itemView.findViewById(R.id.report_date);
            }
        }

    }

}
