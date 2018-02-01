package com.omnify.hire;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.omnify.hire.fragments.FragmentA;
import com.omnify.hire.fragments.FragmentB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, new FragmentA());
        fragmentTransaction.commit();

    }

    public void loadFragB(int[] numbers) {
        Bundle bundle = new Bundle();
        bundle.putIntArray("numbers", numbers);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentB.setArguments(bundle);
        fragmentTransaction.replace(android.R.id.content, fragmentB);
        fragmentTransaction.commit();
    }
}
