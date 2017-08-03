package com.wisnu.recyclerviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showBottomSheetButton = (Button) findViewById(R.id.bottom_sheet_button);
        showBottomSheetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomBottomSheetDialogFragment customBottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
                customBottomSheetDialogFragment.show(getSupportFragmentManager(), "" /*this is for send some value to CustomBottomSheetDialogFragment, for now this sample is no needed*/);
            }
        });
    }
}
