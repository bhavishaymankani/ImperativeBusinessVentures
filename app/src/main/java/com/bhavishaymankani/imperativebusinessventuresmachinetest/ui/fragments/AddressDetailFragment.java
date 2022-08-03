package com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhavishaymankani.imperativebusinessventuresmachinetest.databinding.FragmentAddressDetailBinding;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.model.Data;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.ui.base.BaseFragment;
import com.bhavishaymankani.imperativebusinessventuresmachinetest.viewmodel.SharedViewModel;


public class AddressDetailFragment extends BaseFragment {


    private SharedViewModel mViewModel;
    private FragmentAddressDetailBinding binding;
    private Data data;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddressDetailBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        observe();
    }

    @Override
    public void saveData() {
        Data data = this.data != null ? this.data : new Data();
        boolean isPermanentAddressEmpty = binding.permanentAddressEt.getText().toString().isEmpty();
        boolean isCorrespondingAddressEmpty = binding.correspondingAddressEt.getText().toString().isEmpty();

        if (!isPermanentAddressEmpty || !isCorrespondingAddressEmpty) {
            String permanentAddress = isPermanentAddressEmpty ? null : binding.permanentAddressEt.getText().toString();
            String correspondingAddress = isCorrespondingAddressEmpty ? null : binding.correspondingAddressEt.getText().toString();

            data.setAddress(permanentAddress);
            data.setCorrespondingAddress(correspondingAddress);

            mViewModel.setData(data);
        }


    }

    private void observe() {
        mViewModel.getLiveData().observe(requireActivity(), data -> {
            this.data = data;
            binding.permanentAddressEt.setText(data.getAddress());
            binding.correspondingAddressEt.setText(data.getCorrespondingAddress());
        });
    }


}