package com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhavishaymankani.imperativebusinessventuresmachinetest.databinding.FragmentSubmitionBinding;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.viewmodel.SharedViewModel;


public class AllDetailsFragment extends Fragment {

    private FragmentSubmitionBinding binding;
    private SharedViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSubmitionBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.getLiveData().observe(requireActivity(), data -> {
            binding.nameData.setText(data.getName());
            binding.mobileNumberData.setText(data.getMobileNumber());
            binding.emailData.setText(data.getEmail());
            binding.permanentAddressData.setText(data.getAddress());
            binding.correspondingAddressData.setText(data.getCorrespondingAddress());
            binding.mothersNameData.setText(data.getMotherName());
            binding.fathersNameData.setText(data.getFatherName());
            binding.occuptionData.setText(data.getOccupation());
        });
    }
}