package com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.bhavishaymankani.imperativebusinessventuresmachinetest.R;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.databinding.ActivityMainBinding;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments.AddressDetailFragment;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments.AllDetailsFragment;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments.BasicDetailsFragment;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments.OtherDetailFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentManager fragmentManager;
    private final String[] titles = new String[]{"Basic Details", "Address Details", "Other Details", "All Details"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            launchFragment();
        } else {
            setTitle(titles[fragmentManager.getBackStackEntryCount() - 1]);
            if (fragmentManager.getBackStackEntryCount() > 2)
                binding.btnNext.setText(R.string.submit);
            if (fragmentManager.getBackStackEntryCount() > 3)
                binding.btnNext.setVisibility(View.INVISIBLE);
            if (fragmentManager.getBackStackEntryCount() <= 1)
                binding.btnPrev.setVisibility(View.INVISIBLE);
        }

        binding.btnNext.setOnClickListener(view -> launchFragment());

        binding.btnPrev.setOnClickListener(view -> onBackPressed());


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        binding.btnNext.setVisibility(View.VISIBLE);
        if (fragmentManager.getBackStackEntryCount() <= 2) binding.btnNext.setText(R.string.next);
        if (fragmentManager.getBackStackEntryCount() <= 0)
            finish();
        if (fragmentManager.getBackStackEntryCount() > 0)
            setTitle(titles[fragmentManager.getBackStackEntryCount() - 1]);
        if (fragmentManager.getBackStackEntryCount() <= 1)
            binding.btnPrev.setVisibility(View.INVISIBLE);
    }

    private void launchFragment() {
        Fragment fragment;
        switch (fragmentManager.getBackStackEntryCount()) {
            case 0:
                fragment = new BasicDetailsFragment();
                binding.btnPrev.setVisibility(View.INVISIBLE);
                setTitle(titles[fragmentManager.getBackStackEntryCount()]);
                break;
            case 1:
                fragment = new AddressDetailFragment();
                binding.btnPrev.setVisibility(View.VISIBLE);
                setTitle(titles[fragmentManager.getBackStackEntryCount()]);
                break;
            case 2:
                fragment = new OtherDetailFragment();
                setTitle(titles[fragmentManager.getBackStackEntryCount()]);
                binding.btnNext.setText(R.string.submit);
                break;
            default:
                fragment = new AllDetailsFragment();
                binding.btnNext.setVisibility(View.INVISIBLE);
                setTitle(titles[fragmentManager.getBackStackEntryCount()]);
                break;
        }
        fragmentManager
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }
}