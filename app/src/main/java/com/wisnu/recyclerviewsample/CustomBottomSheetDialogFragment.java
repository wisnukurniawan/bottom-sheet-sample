package com.wisnu.recyclerviewsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by wisnu on 01/08/2017.
 */

public class CustomBottomSheetDialogFragment extends BottomSheetDialogFragment {

    UndraggableBottomSheetBehavior undraggableBottomSheetBehavior = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.bottom_sheet_containner, container, false);

        Button toRecyclerView = (Button) view.findViewById(R.id.to_recycler_view);
        toRecyclerView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager()
                        .beginTransaction()
                        .replace(R.id.bottom_sheet_content, new RecyclerViewFragment())
                        .commitAllowingStateLoss();
            }
        });

        // Set custom behavior
        view.post(new Runnable() {
            @Override
            public void run() {
                adjustBottomSheetBehavior(view);
            }
        });

        // Change layout
        changeLayout();

        return view;
    }

    void adjustBottomSheetBehavior(View view) {
        undraggableBottomSheetBehavior = new UndraggableBottomSheetBehavior();
        undraggableBottomSheetBehavior.setBehaviorToView((View) view.getParent());
        undraggableBottomSheetBehavior.setPeekHeight(500);
        undraggableBottomSheetBehavior.setHideable(false);
    }

    void changeLayout() {
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.bottom_sheet_content, new AnotherFragment())
                .commitAllowingStateLoss();
    }

}
