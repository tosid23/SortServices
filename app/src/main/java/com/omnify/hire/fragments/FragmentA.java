package com.omnify.hire.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.omnify.hire.MainActivity;
import com.omnify.hire.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.randomize)
    Button randomize;

    @BindView(R.id.sort)
    Button sort;

    int[] numbers = new int[20];

    public FragmentA() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);
        randomizer();
        return view;
    }

    @OnClick(R.id.randomize)
    public void randomizer() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers[i] = random.nextInt(90) + 10;
        }
        updateText();
    }

    @OnClick(R.id.sort)
    public void sortOnClick() {
        ((MainActivity) getActivity()).loadFragB(numbers);
    }

    public void updateText() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (i == 0) {
                builder.append((i + 1) + ". \t" + numbers[i]);
            } else {
                builder.append("\n" + (i + 1) + ". \t" + numbers[i]);
            }
        }
        textView.setText(builder.toString());
    }

}
