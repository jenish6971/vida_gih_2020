package com.example.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class allergy_bottomsheet_dialog extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.allergy_bottomsheet, container, false);

        Button allergy_submit_btn_java = v.findViewById(R.id.allergy_submit_btn);
        final EditText alleryg_name_java = v.findViewById(R.id.allergy_name);
        final EditText allergy_side_effect_java = v.findViewById(R.id.allergy_side_effects);

        allergy_submit_btn_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked(alleryg_name_java.toString(),allergy_side_effect_java.toString());
                dismiss();
            }
        });

        return v;
    }

    public interface BottomSheetListener {
        void onButtonClicked(String allergy_named, String allergy_side_effected);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            mListener = (BottomSheetListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement BottomSheet Listener");
        }
    }

}
