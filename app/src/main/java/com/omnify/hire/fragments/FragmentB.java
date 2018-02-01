package com.omnify.hire.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.omnify.hire.R;
import com.omnify.hire.utils.MergeSort;
import com.omnify.hire.utils.QuickSort;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;

    int[] numbers = new int[20];
    private BroadcastReceiver qReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int[] quickSortNumbers = intent.getIntArrayExtra("qKey");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                if (i == 0) {
                    builder.append((i + 1) + ". \t" + quickSortNumbers[i]);
                } else {
                    builder.append("\n" + (i + 1) + ". \t" + quickSortNumbers[i]);
                }
            }
            textView1.setText(builder.toString());
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int[] mergeSortNumbers = intent.getIntArrayExtra("mKey");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                if (i == 0) {
                    builder.append((i + 1) + ". \t" + mergeSortNumbers[i]);
                } else {
                    builder.append("\n" + (i + 1) + ". \t" + mergeSortNumbers[i]);
                }
            }
            textView2.setText(builder.toString());
        }
    };

    public FragmentB() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        numbers = bundle.getIntArray("numbers");

        Intent i = new Intent(getActivity(), QuickSort.class);
        i.putExtra("KEY1", numbers);
        getActivity().startService(i);

        Intent i1 = new Intent(getActivity(), MergeSort.class);
        i1.putExtra("KEY2", numbers);
        getActivity().startService(i1);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(qReceiver, new IntentFilter("qSortReceiver"));
        getActivity().registerReceiver(mReceiver, new IntentFilter("mSortReceiver"));
    }
}
