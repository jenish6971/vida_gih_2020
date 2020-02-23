package com.example.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter_allergy {

    public static class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder>{


        Context mContext;
        List<item_allergy> mData;

        public Adapter(Context mContext, List<item_allergy> mData) {
            this.mContext = mContext;
            this.mData = mData;
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            LayoutInflater inflater = LayoutInflater.from(mContext);
            View v = inflater.inflate(R.layout.allergy_card, parent, false);

            return new myViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
            holder.allergy_name.setText(mData.get(position).getAllergy_name());
            holder.allergy_side_effects.setText(mData.get(position).getAllergy_side_effects());
        }



        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class myViewHolder extends RecyclerView.ViewHolder {

            TextView allergy_name;
            TextView allergy_side_effects;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                allergy_name = itemView.findViewById(R.id.allergy_name_text);
                allergy_side_effects= itemView.findViewById(R.id.allergy_side_effects_text);
            }

        }
    }
}
