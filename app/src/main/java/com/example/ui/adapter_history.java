package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_history {

    public static class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

        Context mContext;
        List<item_history> mData;

        public Adapter(Context mContext, List<item_history> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            LayoutInflater inflater = LayoutInflater.from(mContext);
            View v = inflater.inflate(R.layout.history_card, parent, false);

            return new myViewHolder(v);
        }


        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

            holder.diseases_name_java.setText(mData.get(position).getDiseasesname_name());
            holder.doctor_java.setText(mData.get(position).getDoctor_name());
            holder.diseases_date_java.setText(mData.get(position).getDiseases_date());

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class myViewHolder extends RecyclerView.ViewHolder {

            TextView diseases_name_java;
            TextView doctor_java;
            TextView diseases_date_java;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                diseases_name_java = itemView.findViewById(R.id.diseases_name);
                doctor_java = itemView.findViewById(R.id.doctor_name);
                diseases_date_java = itemView.findViewById(R.id.diseases_date);
            }

        }
    }

}
